package com.mao.singletonmode;

/**
 * 懒汉式
 */
public class User02 {
    //懒汉式：类初始化时，不会创建该对象，正真需要时，才会加载（创建），天生线程不安全，需要解决线程安全问题，所以效率比较低。
    private static User02 user02;

    private User02() {
    }


    // 线程安全 效率低
    public static synchronized User02 getInstance() {
        if (user02 == null) {
            user02 = new User02();
        }
        return user02;
    }

    public static void main(String[] args) {
        User02 u1 = User02.getInstance();
        User02 u2 = User02.getInstance();
        System.out.println(u1 == u2);
    }
}
