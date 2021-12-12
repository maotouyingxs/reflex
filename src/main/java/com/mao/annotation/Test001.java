package com.mao.annotation;

import java.lang.reflect.Method;

/**
 * @author by maotouying
 * @Classname Test001
 * @Description 注解
 * @Date 2021/12/12 15:16
 */
public class Test001 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Class<?> userClass = Class.forName("com.mao.entity.UserEntity");
        Object user = userClass.newInstance();
        Method getUserName = userClass.getDeclaredMethod("getMayiktName");
        MayiktName mayiktName = getUserName.getDeclaredAnnotation(MayiktName.class);
        System.out.println(mayiktName);
    }
}
