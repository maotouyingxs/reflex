package com.mao.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

    /**
     * 思考：在构造函数中，如果发生异常，对象会创建成功吗？ -- 不会
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 1.实例化对象 -- 无参构造函数
        // UserEntity userEntity = new UserEntity();
        // userEntity.userName = "猫头鹰";
        // System.out.println(userEntity.userName);
        // 2. 使用 Java 的反射机制创建对象  类的完整路径
        Class<?> forName = Class.forName("com.mao.entity.UserEntity");
        // 3. 使用反射机制创建对象
        // UserEntity userEntity = (UserEntity) forName.newInstance();
        // userEntity.userName = "反射对象";
        // System.out.println(userEntity.userName);
        // // 4. 反射的应用场景 jdbc连接、SpringIOC hibernate、mybatis
        // // 5. 使用反射机制 获取类的信息
        // Method[] methods = forName.getMethods();
        // for (Method method : methods) {
        //     System.out.println(method.getName());
        // }
        // // 6. 获取类的属性
        // Field[] fields = forName.getDeclaredFields();
        // for (Field field : fields) {
        //     System.out.println(field.getName());
        // }
        Constructor<?> constructor = forName.getConstructor(String.class);
        UserEntity userEntity = (UserEntity) constructor.newInstance("张三");
        System.out.println(userEntity.userName);
    }
}
