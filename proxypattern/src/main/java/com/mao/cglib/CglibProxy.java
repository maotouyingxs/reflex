package com.mao.cglib;

import com.mao.proxy.IUserDao;
import com.mao.proxy.IUserDaoImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object targetObject;

    // 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
    public Object getInstance(Object target) {
        // 设置需要创建子类的类
        this.targetObject = target;
        // 操作字节码生成虚拟的子类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事物");
        Object result = methodProxy.invoke(targetObject, objects);
        System.out.println("关闭事物");
        // 返回代理对象
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        IUserDao iUserDao = (IUserDao) cglibProxy.getInstance(new IUserDaoImpl());
        iUserDao.add();
    }
}
