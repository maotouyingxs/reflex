package com.mao.singletonmode;

/**
 * 饿汉式
 */
public class User01 {
    // 类初始化的时候就会创建对象，天生线程安全，调用效率比较高，如果不适用对象的时候，就会浪费内存
    private static final User01 user01 = new User01();
    // 1. 将构造函数私有化
    private User01() {
    }

    public static User01 getInstance() {
        return user01;
    }

    //
    public static void main(String[] args) {
        User01 u1 = User01.getInstance();
        User01 u2 = User01.getInstance();
        System.out.println(u1 == u2);
    }
}
