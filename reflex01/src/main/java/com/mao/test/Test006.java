package com.mao.test;

import com.mao.entity.UserEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author renshilin
 * @date 2021-10-31
 * 反射调用方法传参
 */
public class Test006 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.mao.entity.UserEntity");
        UserEntity userEntity = (UserEntity) aClass.newInstance();
        // 调用公有方法
        Method setPubUserNameMethod = aClass.getDeclaredMethod("setPubUserName", String.class);
        setPubUserNameMethod.invoke(userEntity, "pubmao");
        System.out.println(userEntity.getPubUserName());
        // 调用私有方法
        Method setUserNameMethod = aClass.getDeclaredMethod("setUserName", String.class);
        setUserNameMethod.invoke(userEntity, "mao");
        System.out.println(userEntity.getUserName());
    }
}
