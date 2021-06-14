package com.mao.singletonmode;

/**
 * 静态内部类
 */
public class User03 {
    private User03() {
        System.out.println("初始化...");
    }

    public static class UserClassInstance {
        private static final User03 user03 = new User03();
    }

    public static User03 getInstance() {
        System.out.println("getInstance");
        return UserClassInstance.user03;
    }

    public static void main(String[] args) {
        User03 u1 = User03.getInstance();
        User03 u2 = User03.getInstance();
        System.out.println(u1 == u2);
    }
}
