package com.mao.test;

import com.mao.entity.UserEntity;

import java.lang.reflect.Field;

/**
 * @author renshilin
 * @date 2021-10-31
 * 反射执行给公有函数赋值
 * 反射执行给私有函数赋值
 */
public class Test004 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.mao.entity.UserEntity");
        // 反射执行公有属性
        Field pubUserNameFiled = aClass.getField("pubUserName");
        UserEntity userEntity = (UserEntity) aClass.newInstance();
        pubUserNameFiled.set(userEntity,"mao");
        System.out.println(userEntity.getPubUserName());
        Field userNameFiled = aClass.getDeclaredField("userName");
        // 设置允许访问私有属性
        userNameFiled.setAccessible(true);
        userNameFiled.set(userEntity,"zhangsan");
        System.out.println(userEntity.getUserName());
    }
}
