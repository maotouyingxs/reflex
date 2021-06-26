package com.mao.buildmode;

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
