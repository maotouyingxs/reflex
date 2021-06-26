package com.mao.adaptation;

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
