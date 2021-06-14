package com.mao.factorymode;

import org.apache.commons.lang3.StringUtils;

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
