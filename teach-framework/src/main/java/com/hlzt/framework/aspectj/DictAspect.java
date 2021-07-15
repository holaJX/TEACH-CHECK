package com.hlzt.framework.aspectj;

import com.hlzt.common.annotation.DataDictClass;
import com.hlzt.common.annotation.Dict;
import com.hlzt.common.constant.Constants;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.system.service.ISysDictDataService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description: 字典aop类
 * @Author: slx
 * @Date: 2019-3-17 21:50
 * @Version: 1.0
 */
@Slf4j
@Aspect
@Component
public class DictAspect {
    @Autowired
    private ISysDictDataService dictDataService;

    /**
     * 定义切点Pointcut
     *
     * @param dataDictClass
     */
    @Pointcut("@annotation(dataDictClass)")
    public void doDataDictClass(DataDictClass dataDictClass) {
    }

    @Around("@annotation(dataDictClass)")
    public Object doAround(ProceedingJoinPoint pjp, DataDictClass dataDictClass) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object result = pjp.proceed();
        long time2 = System.currentTimeMillis();
        log.debug("获取JSON数据 耗时：" + (time2 - time1) + "ms");
        long start = System.currentTimeMillis();
        if (result != null) {
            this.parseDictText(result);
        }
        long end = System.currentTimeMillis();
        log.debug("解析注入JSON数据  耗时" + (end - start) + "ms");
        return result;
    }

    /**
     * 本方法针对返回对象为Result 的IPage的分页列表数据进行动态字典注入
     * 字典注入实现 通过对实体类添加注解@dict 来标识需要的字典内容,字典分为单字典code即可 ，table字典 code table text配合使用与原来jeecg的用法相同
     * 示例为SysUser   字段为sex 添加了注解@Dict(dictValue = "sex") 会在字典服务立马查出来对应的text 然后在请求list的时候将这个字典text，已字段名称加_dictText形式返回到前端
     * 例输入当前返回值的就会多出一个sex_dictText字段
     * {
     * sex:1,
     * sex_dictText:"男"
     * }
     * 前端直接取值sext_dictText在table里面无需再进行前端的字典转换了
     * customRender:function (text) {
     * if(text==1){
     * return "男";
     * }else if(text==2){
     * return "女";
     * }else{
     * return text;
     * }
     * }
     * 目前vue是这么进行字典渲染到table上的多了就很麻烦了 这个直接在服务端渲染完成前端可以直接用
     *
     * @param result
     */
    private void parseDictText(Object result) {
        //目前只渲染List 和 查询出的对象，暂时不处理Controller 层的分页数据
        if (result instanceof List && ((List) result).size() > 0) {
            for (Object record : (List) result) {
                addDictText(record);
            }
        } else {
            addDictText(result);
        }
    }

    private void addDictText(Object record) {
        Class<?> c = record.getClass();
        Class<?> p = c.getSuperclass();
        for (Field field : StringUtils.getAllFields(record)) {
            if (field.getAnnotation(Dict.class) != null) {
                String code = field.getAnnotation(Dict.class).dictValue();
                String text = field.getAnnotation(Dict.class).dictLabel();
                String table = field.getAnnotation(Dict.class).dictTable();
                try {
                    field.setAccessible(true);
                    if (field.get(record) != null) {
                        String key = String.valueOf(field.get(record));
                        //翻译字典值对应的txt
                        String textValue = translateDictValue(code, text, table, key);
                        Field dictField = null;
                        if ("createBy".equals(field.getName())) {
                            //log.debug(" 字典Val : " + textValue + "; __翻译字典字段__ " + field.getName() + Constant.DICT_LABEL_SUFFIX + "： " + textValue);
                            dictField = p.getDeclaredField(field.getName() + Constants.DICT_LABEL_SUFFIX);
                        }else {
                            //log.debug(" 字典Val : " + textValue + "; __翻译字典字段__ " + field.getName() + Constant.DICT_LABEL_SUFFIX + "： " + textValue);
                            dictField = c.getDeclaredField(field.getName() + Constants.DICT_LABEL_SUFFIX);
                        }
                        dictField.setAccessible(true);
                        dictField.set(record, textValue);

                    }

                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 翻译字典文本
     *
     * @param code
     * @param text
     * @param table
     * @param key
     * @return
     */
    private String translateDictValue(String code, String text, String table, String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        StringBuilder textValue = new StringBuilder();
        String[] keys = key.split(",");
        for (String k : keys) {
            String tmpValue;
            log.debug(" 字典 key : " + k);
            if (k.trim().length() == 0 || k.trim().equals("null")) {
                continue; //跳过循环
            }
            if (!StringUtils.isEmpty(table)) {
                log.debug("--DictAspect------dicTable=" + table + " ,dictLabel= " + text + " ,dictValue=" + code);
                tmpValue = dictDataService.selectTableDictLabelByValue(table, text, code, k.trim());
            } else {
                tmpValue = dictDataService.selectDictLabel(code, k.trim());
            }

            if (tmpValue != null) {
                if (!"".equals(textValue.toString())) {
                    textValue.append(",");
                }
                textValue.append(tmpValue);
            }
        }
        return textValue.toString();
    }
}
