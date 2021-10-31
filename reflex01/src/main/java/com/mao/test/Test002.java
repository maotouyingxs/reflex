package com.mao.test;

import com.mao.entity.UserEntity;

/**
 * @author renshilin
 * @date 2021-10-31
 * 运行时期一个类只有一个Class对象
 */
public class Test002 {
    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity();
        Class<? extends UserEntity> userEntityClass = userEntity.getClass();
        Class<UserEntity> userEntityClass1 = UserEntity.class;
        System.out.println(userEntityClass == userEntityClass1);
    }
}
