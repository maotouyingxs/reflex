package com.mao.annotation;

import java.lang.annotation.*;

/**
 * @author by maotouying
 * @Classname MayiktName
 * @Description TODO
 * @Date 2021/12/12 15:50
 */
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MayiktName {

}
