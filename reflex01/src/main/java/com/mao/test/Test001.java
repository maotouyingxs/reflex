package com.mao.test;

import com.mao.entity.UserEntity;

/**
 * @author renshilin
 * @date 2021-10-31
 * 反射获取类的三种方式
 */
public class Test001 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // 1. 实例.getClass
        UserEntity userEntity = new UserEntity();
        Class<? extends UserEntity> entityClass1 = userEntity.getClass();
        UserEntity userEntity1 = entityClass1.newInstance();
        System.out.println(userEntity1 == userEntity);
        System.out.println(userEntity1);
        // 2. 直接获取class
        Class<UserEntity> entityClass2 = UserEntity.class;
        UserEntity userEntity2 = entityClass2.newInstance();
        System.out.println(userEntity2);
        // 3. Class.forName("com.mao.entity.UserEntity")
        Class<?> forName = Class.forName("com.mao.entity.UserEntity");
        UserEntity userEntity3 = (UserEntity) forName.newInstance();
        System.out.println(userEntity3);
    }
}
