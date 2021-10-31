package com.mao.test;

import com.mao.entity.UserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author renshilin
 * @date 2021-10-31
 * 反射执行方法
 */
public class Test005 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.mao.entity.UserEntity");
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class);
        UserEntity userEntity = (UserEntity) constructor.newInstance("mao","pubmao");
        // 公有方法
        Method getUserName = aClass.getMethod("getPubUserName");
        getUserName.invoke(userEntity);
        // 私有方法
        Method getUserName1 = aClass.getDeclaredMethod("getPriUserName");
        // 设置允许访问私有方法
        getUserName1.setAccessible(true);
        getUserName1.invoke(userEntity);
    }
}
