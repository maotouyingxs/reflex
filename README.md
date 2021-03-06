
1. 什么是反射、反射优缺点
2. 反射的用途/反射应用场景
3. 反射调用方法/给属性赋值
4. 反射如何越过泛型检查
5. 什么是注解/注解生效的原理
6. 自定义注解实现API接口限流框架
7. 自定义注解实现事务注解


### 1. [什么是Java反射](docs/reflex.md)
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
3. JDBC加载驱动连接 class.forname
   Class.forName("com.mysql.jdbc.Driver"); // 动态加载mysql驱动
   4.Spring容器框架IOC实例化对象
   <bean id="mayikt" class="com.mayikt.UserEntity" />

5. 自定义注解生效（反射+Aop）
6. 第三方核心的框架 mybatis orm 
### 4. 反射技术的使用
   1. Class类 代表类的实体，在运行的Java应用程序中表示类和接口
   2. Field类 代表类的成员变量（成员变量也称为类的属性）
   3. Method类 代表类的方法
   4. Constructor类 代表类的构造方法
   1. getField、getMethod和getCostructor方法可以获得指定名字的域、方法和构造器。
   2. getFields、getMethods和getCostructors方法可以获得类提供的public域、方法和构造器数组，其中包括超类的共有成员。
   3. getDeclatedFields、getDeclatedMethods和getDeclaredConstructors方法可以获得类中声明的全部域、方法和构造器，其中包括私有和受保护的成员，但不包括超类的成员。
### 3.反射机制获取类有三种方法
```java
// 方式一
Class<UserEntity> userEntityClass1 = UserEntity.class;
UserEntity userEntity1 = userEntityClass1.newInstance();
// 方式二
Class<?> userEntityClass2 = Class.forName("com.mao.entity.UserEntity");
UserEntity userEntity2 = (UserEntity) userEntityClass2.newInstance();
// 方式三
UserEntity userEntity = new UserEntity();
Class userEntityClass3 = userEntity.getClass();
```
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

### 5.设计模式
常用的：工厂方法模式、抽象工厂模式、单例模式、原型模式、
适配器模式、装饰器模式、代理模式、外观模式、组合模式、策略模式、模板方法模式、观察者模式
1. 创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
2. 结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
3. 行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
### 6. 设计模式的六大原则
1. 开闭原则（Open Close Principle）
开闭原则就是说对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。所以一句话概括就是：为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类，后面的具体设计中我们会提到这点。

2. 里氏代换原则（Liskov Substitution Principle）
里氏代换原则(Liskov Substitution Principle LSP)面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。 LSP是继承复用的基石，只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。里氏代换原则是对“开-闭”原则的补充。实现“开-闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。—— From Baidu 百科

3. 依赖倒转原则（Dependence Inversion Principle）
这个是开闭原则的基础，具体内容：真对接口编程，依赖于抽象而不依赖于具体。
接口隔离原则（Interface Segregation Principle）
这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。还是一个降低类之间的耦合度的意思，从这儿我们看出，其实设计模式就是一个软件的设计思想，从大型软件架构出发，为了升级和维护方便。所以上文中多次出现：降低依赖，降低耦合。

4. 迪米特法则（最少知道原则）（Demeter Principle）
为什么叫最少知道原则，就是说：一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。

5. 合成复用原则（Composite Reuse Principle）
原则是尽量使用合成/聚合的方式，而不是使用继承。

### 6. [单例设计模式](docs/singletonMode.md)
1. 什么是单例：
   保证一个类只有一个实例，并且提供一个访问该全局访问点
2. 单例优缺点
   1. 优点：
      1. 在单例模式中，活动的单例只有一个实例，对单例类的所有实例化得到的都是相同的一个实例。这样就 防止其它对象对自己的实例化，确保所有的对象都访问一个实例
      2. 单例模式具有一定的伸缩性，类自己来控制实例化进程，类就在改变实例化进程上有相应的伸缩性。
      3. 提供了对唯一实例的受控访问。
      4. 由于在系统内存中只存在一个对象，因此可以 节约系统资源，当 需要频繁创建和销毁的对象时单例模式无疑可以提高系统的性能。
      5. 允许可变数目的实例。
      6. 避免对共享资源的多重占用。
   2. 缺点：
      1. 不适用于变化的对象，如果同一类型的对象总是要在不同的用例场景发生变化，单例就会引起数据的错误，不能保存彼此的状态。
      2. 由于单利模式中没有抽象层，因此单例类的扩展有很大的困难。
      3. 单例类的职责过重，在一定程度上违背了“单一职责原则”。
      4. 滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为的单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；如果实例化的对象长时间不被利用，系统会认为是垃圾而被回收，这将导致对象状态的丢失。

### 7. 单例创建方式
1.	饿汉式:类初始化时,会立即加载该对象，线程天生安全,调用效率高。
2.	懒汉式: 类初始化时,不会初始化该对象,真正需要使用的时候才会创建该对象,具备懒加载功能。
3.	静态内部方式:结合了懒汉式和饿汉式各自的优点，真正需要对象的时候才会加载，加载类是线程安全的。
4.	枚举单例: 使用枚举实现单例模式 优点:实现简单、调用效率高，枚举本身就是单例，由jvm从根本上提供保障!避免通过反射和反序列化的漏洞， 缺点没有延迟加载。
5.	双重检测锁方式 (因为JVM本质重排序的原因，可能会初始化多次，不推荐使用)
```java
/**
 * 饿汉模式
 */
public class User02 {
   // 类初始化的时候就会创建对象，天生线程安全，调用效率比较高，如果不适用对象的时候，就会浪费内存
   private static final User01 user01 = new User01();

   // 1. 将构造函数私有化
   private User01() {
   }

   public static User01 getInstance() {
      return user01;
   }

   //
   public static void main(String[] args) {
      User01 u1 = User01.getInstance();
      User01 u2 = User01.getInstance();
      System.out.println(u1 == u2);
   }
}
```
---
```java
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
```
```java
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
```
```java
/**
* 枚举单例
*/
public class User04 {
    private User04() {
    }

    public static User04 getInstance() {
        return SingletonUserEnum.INSTANCE.getInstance();
    }

    /**
     * 本身枚举就是单例的
     */
    static enum SingletonUserEnum {
        INSTANCE;
        private User04 user04;

        private SingletonUserEnum() {
            // 只会执行一次
            user04 = new User04();
        }

        public User04 getInstance() {
            return user04;
        }
    }

    public static void main(String[] args) {
        User04 u1 = User04.getInstance();
        User04 u2 = User04.getInstance();
        System.out.println(u1 == u2);
    }
}
```
---
### 8. 工厂模式
1. 什么是工厂模式: 实现了创建者和调用者分离，工厂模式分为简单工厂、工厂方法、抽象工厂模式
2. 工厂模式好处
   工厂模式是我们最常用的实例化对象模式了，是用工厂方法代替new操作的一种模式。
   利用工厂模式可以降低程序的耦合性，为后期的维护修改提供了很大的便利。
   将选择实现类、创建对象统一管理和控制。从而将调用者跟我们的实现类解耦。
3. 工厂模式分类
   1. 简单工厂模式: 简单工厂模式相当于是一个工厂中有各种产品，创建在一个类中，客户无需知道具体产品的名称，只需要知道产品类所对应的参数即可。但是工厂的职责过重，而且当类型过多时不利于系统的扩展维护。
### 9. 简单工厂模式
1. 简单工厂模式相当于是一个工厂中有各种产品，创建在一个类中，客户无需知道具体产品的名称，只需要知道产品类所对应的参数即可。但是工厂的职责过重，而且当类型过多时不利于系统的扩展维护。
   ![img.png](docs/imgs/simplefactory.png)
2. 单工厂的优点/缺点
   1. 优点：简单工厂模式能够根据外界给定的信息，决定究竟应该创建哪个具体类的对象。明确区分了各自的职责和权力，有利于整个软件体系结构的优化。
   2. 缺点：很明显工厂类集中了所有实例的创建逻辑，容易违反GRASPR的高内聚的责任分配原则
```java
   public interface Car {
       void run();
   }
```
```java
/**
* 比亚迪汽车
  */
  public class BydCar implements Car {
  @Override
  public void run() {
  System.out.println("比亚迪汽车...");
  }
  }
```
```java
/**
 * 吉利汽车
 */
public class JiliCar implements Car {
    @Override
    public void run() {
        System.out.println("吉利汽车...");
    }
}
```
```java
/**
 * 汽车厂(4S店)
 */
public class CarFactory {
    public static Car createCar(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        if ("比亚迪".equals(name)) {
            return new BydCar();
        }
        if ("吉利".equals(name)) {
            return new JiliCar();
        }
        return null;
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        Car bydCar = CarFactory.createCar("比亚迪");
        Car jiliCar = CarFactory.createCar("吉利");
        bydCar.run();
        jiliCar.run();
    }
}
```

### 10. 工厂方法模式
1. 什么是工厂方法模式: 工厂方法模式Factory Method，又称多态性工厂模式。在工厂方法模式中，核心的工厂类不再负责所有的产品的创建，
![img.png](docs/imgs/methodfactory.png)
```java
   public interface Car {
       void run();
   }
```
```java
/**
* 比亚迪汽车
  */
  public class BydCar implements Car {
  @Override
  public void run() {
  System.out.println("比亚迪汽车...");
  }
  }
```
```java
/**
 * 吉利汽车
 */
public class JiliCar implements Car {
    @Override
    public void run() {
        System.out.println("吉利汽车...");
    }
}
```
```java
/**
 * 汽车厂(4S店)
 */
public interface CarFactory {
    Car createCar(String name);
}
```
```java
/**
 * 比亚迪汽车4S店销售
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar(String name) {
        return new BydCar();
    }
}
```
```java
/**
 * 吉利汽车4S店销售
 */
public class JiLiFactory implements CarFactory {
    @Override
    public Car createCar(String name) {
        return new JiliCar();
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        CarFactory carFactory = new BydFactory();
        Car car = carFactory.createCar("比亚迪");
        car.run();
        JiLiFactory jiLiFactory = new JiLiFactory();
        Car jiLiCar = jiLiFactory.createCar("吉利");
        jiLiCar.run();
    }
}
```
### 11. 抽象工厂模式
1. 什么是抽象工厂模式:
   抽象工厂简单地说是工厂的工厂，抽象工厂可以创建具体工厂，由具体工厂来产生具体产品。
   ![img.png](docs/imgs/abstractfactory.png)
   ![img.png](docs/imgs/abstractfactory2.png)

```java
/**
 * 发动机
 */
public interface Engine {
    void run();
    void start();
}

class EngineA implements Engine {

    @Override
    public void run() {
        System.out.println("发送机转速快...");
    }

    @Override
    public void start() {

    }
}

class EngineB implements Engine {
    @Override
    public void run() {
        System.out.println("发动机转速慢...");
    }

    @Override
    public void start() {

    }
}
```
```java
/**
 * 座椅
 */
public interface Chair {
    void run();
}

class ChairA implements Chair {
    @Override
    public void run() {
        System.out.println("自动加热...");
    }
}
class ChairB implements Chair {
    @Override
    public void run() {
        System.out.println("不能加热...");
    }
}
```
```java

/**
 * 包装厂
 */
public interface CarFactory {
    /**
     * 创建发动机
     *
     * @return 发动机
     */
    Engine createEngine();

    /**
     * 创建座椅
     *
     * @return 座椅
     */
    Chair createChair();
}

```
```java
public class JiLiFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public Chair createChair() {
        return new ChairA();
    }
}

```
```java
public class Client {
    public static void main(String[] args) {
        CarFactory jiLiFactory = new JiLiFactory();
        Engine engineA = jiLiFactory.createEngine();
        Chair chairA = jiLiFactory.createChair();
        engineA.run();
        engineA.start();
        chairA.run();
    }
}
```
--- 
### 12. [代理模式](docs/proxy.md)
1.  什么是代理模式:
    通过代理控制对象的访问,可以详细访问某个对象的方法，在这个方法调用处理，或调用后处理。既(AOP微实现)  ,AOP核心技术面向切面编程。
    ![img.png](docs/imgs/proxypattern.png)
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
**5. 动态代理**
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
---
### 1. 建造者模式
   1. 什么是建造者模式
![img.png](./docs/imgs/buildMode.png)
      1. 建造者模式：是将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
      工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性，其实建造者模式就是前面抽象工厂模式和最后的Test结合起来得到的。
      建造者模式通常包括下面几个角色：
         1. Builder：给出一个抽象接口，以规范产品对象的各个组成成分的建造。这个接口规定要实现复杂对象的哪些部分的创建，并不涉及具体的对象部件的创建。
         2. ConcreteBuilder：实现Builder接口，针对不同的商业逻辑，具体化复杂对象的各部分的创建。 在建造过程完成后，提供产品的实例。
         3. Director：调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建。
         4. Product：要创建的复杂对象。
      2. 建造者应用场景
         1. 去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。
         19元每周三 汉堡+可乐+薯条=套餐可能会发生改变。
         2. JAVA 中的 StringBuilder 数组（单个字符）字整合在一起 字符串
      3. 使用场景：
         1. 需要生成的对象具有复杂的内部结构。
         2. 需要生成的对象内部属性本身相互依赖。
      **与工厂模式的区别是：建造者模式更加关注与零件装配的顺序。**

      4. 实际案例 :这里以游戏开发中人物的构造过程为例。在游戏中创建一个形象时，需要对每个部位进行创建。简化而言，需要创建头部，身体和四肢。
头部、体部、四肢
```java
/**
 * @author mao
 * @date 2021-06-26
 * description 人物对象
 */
public class Person {
    /**
     * 头部
     */
    private String head;
    /**
     * 体部
     */
    private String body;

    /**
     * 尾部
     */
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 * description 给出一个抽象接口，以规范产品对象的各个组成成分的建造。
 * 这个接口规定要实现复杂对象的哪些部分的创建，并不涉及具体的对象部件的创建
 */
public interface PersonBuilder {
    /**
     * 构建头部
     */
    void buildHead();

    /**
     * 构建体部
     */
    void buildBody();

    /**
     * 构建尾部
     */
    void buildFoot();

    /**
     * 组织人物
     *
     * @return 人物
     */
    Person buildPerson();
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 * description 实现Builder接口，创建美国人。 在建造过程完成后，提供产品的实例
 */
public class ManBuilder implements PersonBuilder {
    private Person person;

    public ManBuilder() {
        this.person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("美国人，头部，鼻子尖...");
    }

    @Override
    public void buildBody() {
        person.setBody("美国人，体部，块头大...");
    }

    @Override
    public void buildFoot() {
        person.setFoot("美国人，尾部，腿长...");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 * description 实现Builder接口，创建日本人。 在建造过程完成后，提供产品的实例
 */
public class JpBuilder implements PersonBuilder {
    private Person person;

    public JpBuilder() {
        this.person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("日本人，头部，圆脸...");
    }

    @Override
    public void buildBody() {
        person.setBody("日本人，体部，块头小...");
    }

    @Override
    public void buildFoot() {
        person.setFoot("日本人，尾部，腿短...");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 * description 调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder personBuilder) {
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildFoot();
        return personBuilder.buildPerson();
    }

    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector();
        // 构建美国人
        Person person = personDirector.constructPerson(new ManBuilder());
        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
        // 构建日本人
        Person person1 = personDirector.constructPerson(new JpBuilder());
        System.out.println(person1.getHead());
        System.out.println(person1.getBody());
        System.out.println(person1.getFoot());
    }
}
```
## 2. 模板方法
1. 什么是模板方法
   1. 模板方法模式：定义一个操作中的算法骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的
重复代码全部在父类里面，不同业务的，使用抽象方法，抽取给子类进行实现。抽取过程---抽象方法。
某些特定步骤。
   2. 核心：处理某个流程的代码已经都具备，但是其中某个节点的代码暂时不能确定。因此，我们采用工厂方法模式，将这个节点的代码实现转移给
子类完成。即：处理步骤在父类中定义好，具体的实现延迟到子类中定义。
说白了，就是将一些相同操作的代码，封装成一个算法的骨架。核心的部分留在子类中操作，在父类中只把那些骨架做好。
   3. 例如：
      1. 去银行办业务，银行给我们提供了一个模板就是：先取号，排对，办理业务（核心部分我们子类完成），给客服人员评分，完毕。
这里办理业务是属于子类来完成的，其他的取号，排队，评分则是一个模板。 
      2. 去餐厅吃饭，餐厅给提供的一套模板就是：先点餐，等待，吃饭（核心部分我们子类完成），买单
这里吃饭是属于子类来完成的，其他的点餐，买单则是餐厅提供给我们客户的一个模板。
![img.png](./docs/imgs/templ.png)
```java
/**
 * @author mao
 * @date 2021-06-26
 */
public abstract class SendMessage {

    public void headLog() {
        System.out.println("调用运营商开始记录日志...");
    }

    public void footLog() {
        System.out.println("调用运营商结束记录日志...");
    }

    /**
     * 调用不同运营商发送短信
     */
    public abstract void httpRequest();

    /**
     * 发送短信
     */
    public void sendMessage() {
        headLog();
        httpRequest();
        footLog();
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 */
public class YiDong extends SendMessage{
    @Override
    public void httpRequest() {
        System.out.println("http://yidong...");
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 */
public class LianTong extends SendMessage{

    @Override
    public void httpRequest() {
        System.out.println("http://liantong...");
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 */
public class ClientTemplate {
    public static void main(String[] args) {
        YiDong yiDong = new YiDong();
        yiDong.sendMessage();
        LianTong lianTong = new LianTong();
        lianTong.sendMessage();
    }
}

```
### 3. 适配模式 
1. 什么是适配器
在设计模式中，适配器模式（英语：adapter pattern）有时候也称包装样式或者包装(wrapper)。将一个类的接口转接成用户所期待的。一个适配使得因接口不兼容而不能在一起工作的类工作在一起，做法是将类自己的接口包裹在一个已存在的类中。

2. 适配器分类
适配器分为，类适配器、对象适配、接口适配方式；
类适配器方式采用继承方式，对象适配方式使用构造函数传递

3. 适配器案例
我们就拿日本电饭煲的例子进行说明，日本电饭煲电源接口标准是110V电压，而中国标准电压接口是220V，所以要想在中国用日本电饭煲，需要一个电源转换器。

```java
/**
 * @author mao
 * @date 2021-06-26
 * 中国220V电源
 */
public interface Cn220vInterface {
    /**
     * 连接电源
     */
    void connect();
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 */
public class Cn220vInterfaceImpl implements Cn220vInterface {
    @Override
    public void connect() {
        System.out.println("中国220V电源开始连接...");
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 * 日本110V电源
 */
public interface Jp110vInterface {
    /**
     * 连接电源
     */
    void connect();
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 */
public class Jp110vInterfaceImpl implements Jp110vInterface {
    @Override
    public void connect() {
        System.out.println("日本110V电源开始连接...");
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 * 日本电饭煲
 */
public class ElectricCooker {
    private Jp110vInterface jp110vInterface;

    public ElectricCooker(Jp110vInterface jp110vInterface) {
        this.jp110vInterface = jp110vInterface;
    }

    /**
     * 电饭煲开始工作
     */
    public void cook() {
        jp110vInterface.connect();
        System.out.println("电饭煲开始工作...");
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 * 适配器 传入中国220V电源
 */
public class PowerAdaptor implements Jp110vInterface{
    private Cn220vInterface cn220vInterface;

    public PowerAdaptor(Cn220vInterface cn220vInterface) {
        this.cn220vInterface = cn220vInterface;
    }

    @Override
    public void connect() {
        cn220vInterface.connect();
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-26
 */
public class AdaptorTest {
    public static void main(String[] args) {
        // 中国220V电源
        Cn220vInterfaceImpl cn220vInterface = new Cn220vInterfaceImpl();
        // 适配器
        PowerAdaptor powerAdaptor = new PowerAdaptor(cn220vInterface);
        // 电饭煲
        ElectricCooker electricCooker = new ElectricCooker(powerAdaptor);
        electricCooker.cook();
    }
}
```
### 4. 外观模式
1. 什么是外观模式
外观模式（Facade Pattern）门面模式，隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。这种类型的设计模式属于结构型模式，它向现有的系统添加一个接口，来隐藏系统的复杂性。
这种模式涉及到一个单一的类，该类提供了客户端请求的简化方法和对现有系统类方法的委托调用。
![img.png](./docs/imgs/exterior.png)

### 5. 原型模式
1. 什么是原型模式
克隆
原型模式是一个创建型的模式。原型二字表明了改模式应该有一个样板实例，用户从这个样板对象中复制一个内部属性一致的对象，这个过程也就是我们称的“克隆”。被复制的实例就是我们所称的“原型”，这个原型是可定制的。原型模式多用于创建复杂的或者构造耗时的实例，因为这种情况下，复制一个已经存在的实例可使程序运行更高效。
原型模式应用场景

   1. 类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等，通过原型拷贝避免这些消耗。
   2. 通过new产生的一个对象需要非常繁琐的数据准备或者权限，这时可以使用原型模式。
   3. 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用，即保护性拷贝。
   4. Spring框架中的多例就是使用原型。 
2. 原型模式UML类图（通用）
   2. 原型模式主要用于对象的复制，它的核心是就是类图中的原型类Prototype。Prototype类需要具备以下两个条件：
      1. 实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。
      2. 重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，一般的类无法调用，因此Prototype类需要将clone方法的作用域修改为public类型。
3. 原型模式分为浅复制和深复制
   1. 浅复制 —-只是拷贝了基本类型的数据，而引用类型数据，复制后也是会发生引用，我们把这种拷贝叫做“（浅复制）浅拷贝”，换句话说，浅复制仅仅是指向被复制的内存地址，如果原地址中对象被改变了，那么浅复制出来的对象也会相应改变。
   2. 深复制 —-在计算机中开辟了一块新的内存地址用于存放复制的对象。

```java
/**
 * @author mao
 * @date 2021-06-27
 */
public class Book implements Cloneable{
    /**
     * 标题
     */
    private String title;
    /**
     * 图片列表
     */
    private ArrayList<String> image = new ArrayList<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book book = (Book) super.clone();
        // 深复制
        book.setImage((ArrayList<String>) image.clone());
        return book;
    }

    public void addImage(String img) {
        image.add(img);
    }

    /**
     * 打印内容
     */
    public void showBook() {
        System.out.println("-------start--------");
        System.out.println("title:" + this.title);
        for (String img : image) {
            System.out.println("image name:" + img);
        }
        System.out.println("-------end--------");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }
}
```
```java
/**
 * @author mao
 * @date 2021-06-27
 */
public class BookTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book();
        book1.setTitle("图书1");
        book1.addImage("图片1");
        book1.showBook();

        Book book2 = (Book) book1.clone();
        book2.setTitle("图书2");
        book2.addImage("图片2");
        book2.showBook();

        book1.showBook();
    }
}
```

### 6. 策略模式
1. 什么是策略模式
定义了一系列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。策略模式让算法独立于使用它的客户而独立变化。
2. 策略模式由三种角色组成
3. 策略模式应用场景：
策略模式的用意是针对一组算法或逻辑，将每一个算法或逻辑封装到具有共同接口的独立的类中，从而使得它们之间可以相互替换。策略模式使得算法或逻辑可以在不影响到客户端的情况下发生变化。说到策略模式就不得不提及OCP(Open Closed Principle) 开闭原则，即对扩展开放，对修改关闭。策略模式的出现很好地诠释了开闭原则，有效地减少了分支语句。
```java
/**
 * @author by maotouying
 * @Classname Strategy001
 * @Description 策略模式  会员分为3种等级  铂金会员 黄金会员 普通会员 获取价格都不一样
 * @Date 2021/7/8 21:07
 */
public class Strategy001 {
    public static void main(String[] args) {

        Context context;
        context = new Context(new StrategyA());
        context.algorithmInterface();
        context = new Context(new StrategyB());
        context.algorithmInterface();
        context = new Context(new StrategyC());
        context.algorithmInterface();
    }
}
```
```java
/**
 * @author by maotouying
 * @Classname Strategy
 * @Description 策略模式 定义抽象方法 所有支持公共接口
 * @Date 2021/7/8 21:53
 */
public abstract class Strategy {
    /**
     * 算法方法
     */
    abstract void algorithmInterface();
}

class StrategyA extends Strategy {

    @Override
    void algorithmInterface() {
        System.out.println("普通会员算法A");
    }
}

class StrategyB extends Strategy {

    @Override
    void algorithmInterface() {
        System.out.println("黄金会员算法B");
    }
}

class StrategyC extends Strategy {

    @Override
    void algorithmInterface() {
        System.out.println("铂金会员算法C");
    }
}

/**
 * 使用上下文维护算法策略
 */
class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void algorithmInterface(){
        strategy.algorithmInterface();
    }
}
```