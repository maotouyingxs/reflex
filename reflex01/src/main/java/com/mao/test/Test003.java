package com.mao.test;

import com.mao.entity.UserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author renshilin
 * @date 2021-10-31
 * 反射执行构造函数
 */
public class Test003 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> forName = Class.forName("com.mao.entity.UserEntity");
        // 默认执行无参构造函数
        UserEntity userEntity = (UserEntity) forName.newInstance();
        // 执行有参构造函数
        Constructor<?> constructor = forName.getConstructor(String.class);
        UserEntity userEntity1 = (UserEntity) constructor.newInstance("mao");
        System.out.println(userEntity.getUserName());
        System.out.println(userEntity1.getUserName());
    }
}
