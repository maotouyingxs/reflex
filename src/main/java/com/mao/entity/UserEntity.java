package com.mao.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author maotouying
 */
public class UserEntity {
    private String userName;

    public UserEntity() {
        System.out.println("对象初始化...");
        // throw new RuntimeException();
    }

    public UserEntity(String userName) {
        System.out.println("userName:" + userName);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void getMayiktName() {
        System.out.println("mayikt...");
    }
    /**
     * 思考：在构造函数中，如果发生异常，对象会创建成功吗？ -- 不会
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 1.实例化对象 -- 无参构造函数
        // UserEntity userEntity = new UserEntity();
        // userEntity.userName = "猫头鹰";
        // System.out.println(userEntity.userName);
        // 方式一
        Class<UserEntity> userEntityClass1 = UserEntity.class;
        UserEntity userEntity1 = userEntityClass1.newInstance();
        // 方式二
        // 2. 使用 Java 的反射机制创建对象  类的完整路径
        Class<?> userEntityClass2 = Class.forName("com.mao.entity.UserEntity");
        // 3. 使用反射机制创建对象
        UserEntity userEntity2 = (UserEntity) userEntityClass2.newInstance();
        UserEntity userEntity = new UserEntity();
        Class userEntityClass3 = userEntity.getClass();
        userEntity2.userName = "反射对象";
        System.out.println(userEntity2.userName);
        // 4. 反射的应用场景 jdbc连接、SpringIOC hibernate、mybatis
        // 5. 使用反射机制 获取类的信息
        Method[] methods = userEntityClass2.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        // 6. 获取类的属性
        Field[] fields = userEntityClass2.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Constructor<?> constructor = userEntityClass2.getConstructor(String.class);
        UserEntity userEntity4 = (UserEntity) constructor.newInstance("张三");
        System.out.println(userEntity4.userName);
    }
}
