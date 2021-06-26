package com.mao.buildmode;

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
