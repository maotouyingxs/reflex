package com.mao.buildmode;

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
