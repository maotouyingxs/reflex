### 1. 什么是Java反射
1. 就是正在运行，动态获取这个类的所有信息。 
### 2. 反射机制的优缺点
第三方框架---创建对象 不是直接new 反射机制创建
目的：提供开发者能够更好封装框架实现扩展功能。
在一个类中 定义了一个私有属性/方法 反射机制破解私有属性

1. 优点：在运行时获得类的各种内容，进行反编译，对于Java这种先编译再运行的语言，能够让我们很方便的创建灵活的代码，这些代码可以在运行时装配，无需在组件之间进行源代码的链接，更加容易实现面向对象。
2. 缺点：
   1. 反射会消耗一定的系统资源，因此如果不需要动态地创建一个对象，那么就不需要用反射；
   2. 反射调用方法时可以忽略权限检查，因此可能会破坏封装性而导致安全问题。
### 2. 反射机制的作用
1. 反编译：.class-->.java
2. 通过反射机制访问java对象的属性，方法，构造方法等；
### 3.反射机制获取类有三种方法
1. Class.forName("类的完整路径")
   ```
        // 1.实例化对象 -- 无参构造函数
        // UserEntity userEntity = new UserEntity();
        // userEntity.userName = "猫头鹰";
        // System.out.println(userEntity.userName);
        // 2. 使用 Java 的反射机制创建对象  类的完整路径
        Class<?> forName = Class.forName("com.mao.entity.UserEntity");
        // 3. 使用反射机制创建对象
        UserEntity userEntity = (UserEntity) forName.newInstance();
        userEntity.userName = "反射对象";
        System.out.println(userEntity.userName);
        // 4. 反射的应用场景 jdbc连接、SpringIOC hibernate、mybatis
        // 5. 使用反射机制 获取类的信息
        Method[] methods = forName.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        // 6. 获取类的属性
        Field[] fields = forName.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
   ```
   ### 4. 反射创建api
|方法名称|	作用
---|---
|getDeclaredMethods []|	获取该类的所有方法
|getReturnType()|	获取该类的返回值
|getParameterTypes()|	获取传入参数
|getDeclaredFields()	|获取该类的所有字段
|setAccessible	|允许访问私有成员

### 5. 注解
1. 什么是注解：
   注解用来给类声明附加额外信息，可以标注在类、字段、方法等上面，编译器、JVM以及开
2. 常用注解
```
@Override     只能标注在子类覆盖父类的方法上面，有提示的作用
@Deprecated    标注在过时的方法或类上面，有提示的作用
@SuppressWarnings("unchecked")   标注在编译器认为有问题的类、方法等上面，用来取消编译器的警告提示，警告类型有serial、unchecked、unused、all

@Target(ElementType.METHOD) // 指定新注解可以标注在方法上
@Retention(RetentionPolicy.RUNTIME) // 指定新注解保留到程序运行时期
@Inherited // 指定新注解标注在父类上时可被子类继承 
public @interface MayiktName {
    public String name();
}
自定义注解 运行 ：反射+aop
```
3. 元注解：
   元注解用来在声明新注解时指定新注解的一些特性
```java
@Target 指定新注解标注的位置，比如类、字段、方法等，取值有ElementType.Method等
@Retention 指定新注解的信息保留到什么时候，取值有RetentionPolicy.RUNTIME等
@Inherited  指定新注解标注在父类上时可被子类继承
```   
4. 注的 Target
```java
TYPE：类、接口（包括注解类型）和枚举的声明
FIELD：字段声明（包括枚举常量）
METHOD：方法声明
PARAMETER：参数声明
CONSTRUCTOR：构造函数声明
LOCAL_VARIABLE：本地变量声明
ANNOTATION_TYPE：注解类型声明
PACKAGE：包声明
TYPE_PARAMETER：类型参数声明，JavaSE8引进，可以应用于类的泛型声明之处
TYPE_USE：JavaSE8引进，此类型包括类型声明和类型参数声明
```