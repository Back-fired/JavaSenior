package com.hongmingxu.java.Class;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author hongmingxu
 * @create 2022-03-14 20:38
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD,METHOD,TYPE,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}
