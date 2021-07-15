package com.hlzt.common.annotation;

import org.apache.poi.ss.formula.functions.T;

import java.lang.annotation.*;

/**
 * 用在Controller返回方法上
 *
 * @author hlzt-slx
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataDictClass {
    /**
     * 主要适用于data中对象的解析
     * @return
     */
    Class<?> ObjClass() default T.class;
}
