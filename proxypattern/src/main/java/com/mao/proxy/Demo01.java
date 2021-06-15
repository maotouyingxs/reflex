package com.mao.proxy;

/**
 * 静态代理，静态代理是需要生产代理对象的
 */
public class Demo01 {
    public static void main(String[] args) {
        IUserDao iUserDao = new IUserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(iUserDao);
        userDaoProxy.add();
    }
}
