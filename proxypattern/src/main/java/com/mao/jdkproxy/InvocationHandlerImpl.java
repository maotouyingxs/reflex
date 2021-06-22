package com.mao.jdkproxy;

import com.mao.proxy.IUserDao;
import com.mao.proxy.IUserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  每次生成动态代理类对象时,实现了InvocationHandler接口的调用处理器对象
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Object target;// 这其实业务实现类对象，用来调用具体的业务方法

    // 通过构造函数传入目标对象
    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用开始处理");
        Object result = method.invoke(target, args);
        System.out.println("调用结束处理");
        return result;
    }

    public static void main(String[] args) {
        IUserDao iUserDao = new IUserDaoImpl();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(iUserDao);
        // 获取类加载器
        ClassLoader classLoader = iUserDao.getClass().getClassLoader();
        // 获取当前实现的接口
        Class<?>[] interfaces = iUserDao.getClass().getInterfaces();
        IUserDao newProxyInstance = (IUserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        newProxyInstance.add();
    }
}
