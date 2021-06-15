package com.mao.proxy;

public class UserDaoProxy implements IUserDao {
    private IUserDao iUserDao;

    public UserDaoProxy(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void add() {
        System.out.println("开启事务...");
        iUserDao.add();
        System.out.println("提交事务...");
    }
}
