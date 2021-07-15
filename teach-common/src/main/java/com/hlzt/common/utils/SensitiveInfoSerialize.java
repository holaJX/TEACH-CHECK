package com.hlzt.common.utils;

import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.hlzt.common.annotation.SensitiveInfo;
import com.hlzt.common.enums.SensitiveType;

import java.io.IOException;
import java.util.Objects;

/**
 * @author hlzt-slx
 */
public class SensitiveInfoSerialize extends JsonSerializer<String> implements ContextualSerializer {

    private SensitiveType type;

    public SensitiveInfoSerialize() {
    }

    public SensitiveInfoSerialize(final SensitiveType type) {
        this.type = type;
    }

    @Override
    public void serialize(final String s, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
        switch (this.type) {
            case CHINESE_NAME: {
                jsonGenerator.writeString(DesensitizedUtil.chineseName(s));
                break;
            }
            case ID_CARD: {
                jsonGenerator.writeString(DesensitizedUtil.idCardNum(s, 6, 2));
                break;
            }
            case FIXED_PHONE: {
                jsonGenerator.writeString(DesensitizedUtil.fixedPhone(s));
                break;
            }
            case MOBILE_PHONE: {
                jsonGenerator.writeString(DesensitizedUtil.mobilePhone(s));
                break;
            }
            case ADDRESS: {
                jsonGenerator.writeString(DesensitizedUtil.address(s, 4));
                break;
            }
            case EMAIL: {
                jsonGenerator.writeString(DesensitizedUtil.email(s));
                break;
            }
            case BANK_CARD: {
                jsonGenerator.writeString(DesensitizedUtil.bankCard(s));
                break;
            }
            case CNAPS_CODE: {
                jsonGenerator.writeString(DesensitizedUtil.bankCard(s));
                break;
            }
        }

    }

    @Override
    public JsonSerializer<?> createContextual(final SerializerProvider serializerProvider, final BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            // 为空直接跳过
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
                // 非 String 类直接跳过
                SensitiveInfo sensitiveInfo = beanProperty.getAnnotation(SensitiveInfo.class);
                if (sensitiveInfo == null) {
                    sensitiveInfo = beanProperty.getContextAnnotation(SensitiveInfo.class);
                }
                if (sensitiveInfo != null) {
                    // 如果能得到注解，就将注解的 value 传入 SensitiveInfoSerialize
                    return new SensitiveInfoSerialize(sensitiveInfo.value());
                }
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(beanProperty);
    }
}
