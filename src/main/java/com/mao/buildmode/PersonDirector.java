package com.mao.buildmode;

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
