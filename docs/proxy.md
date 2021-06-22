## 代理模式
1.  什么是代理模式:
    通过代理控制对象的访问,可以详细访问某个对象的方法，在这个方法调用处理，或调用后处理。既(AOP微实现)  ,AOP核心技术面向切面编程。
    ![img.png](imgs/proxypattern.png)
2. 代理模式应用场景:
   SpringAOP、事物原理、日志打印、权限控制、远程调用、安全代理 可以隐蔽真实角色
3. 代理的分类:
    1. 静态代理(静态定义代理类)
    2. 动态代理(动态生成代理类)
    3. Jdk自带动态代理
    4. Cglib 、javaassist（字节码操作库）

**4. 静态代理**
1. 什么是静态代理:
   由程序员创建或工具生成代理类的源码，再编译代理类。所谓静态也就是在程序运行前就已经存在代理类的字节码文件，代理类和委托类的关系在运行前就确定了。
```java
public interface IUserDao {
    void add();
}
```
```java
public class IUserDaoImpl implements IUserDao{
    @Override
    public void add() {
        System.out.println("add方法...");
    }
}
```
```java
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
```
```java
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
```
**动态代理**
1. 什么是动态代理
   1. 代理对象,不需要实现接口
   2. 代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
   3. 动态代理也叫做:JDK代理,接口代理
2. JDK动态代理
   1. 原理：是根据类加载器和接口创建代理类（此代理类是接口的实现类，所以必须使用接口 面向接口生成代理，位于java.lang.reflect包下）
   2. 实现方式：
      1. 通过实现InvocationHandler接口创建自己的调用处理器 IvocationHandler handler = new InvocationHandlerImpl(…);
      2. 通过为Proxy类指定ClassLoader对象和一组interface创建动态代理类Class clazz = Proxy.getProxyClass(classLoader,new Class[]{…});
      3. 通过反射机制获取动态代理类的构造函数，其参数类型是调用处理器接口类型Constructor constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});
      4. 通过构造函数创建代理类实例，此时需将调用处理器对象作为参数被传入Interface Proxy = (Interface)constructor.newInstance(new Object[] (handler));
    3. 缺点：jdk动态代理，必须是面向接口，目标业务类必须实现接口
```java
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
        // 主要装载器、一组接口及调用处理动态代理实例
        IUserDao newProxyInstance = (IUserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        newProxyInstance.add();
    }
}
```
3. CGLIB动态代理
   1. 原理：利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
   2. 什么是CGLIB动态代理
      - 使用cglib[Code Generation Library]实现动态代理，并不要求委托类必须实现接口，底层采用asm字节码生成框架生成代理类的字节码

```java
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
```
4. CGLIB动态代理与JDK动态区别
   - java动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
   而cglib动态代理是利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
   Spring中。
     1. 如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP
     2. 如果目标对象实现了接口，可以强制使用CGLIB实现AOP
     3. 如果目标对象没有实现了接口，必须采用CGLIB库，spring会自动在JDK动态代理和CGLIB之间转换
   JDK动态代理只能对实现了接口的类生成代理，而不能针对类 。
   - CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法 。
   因为是继承，所以该类或方法最好不要声明成final ，final可以阻止继承和多态。
