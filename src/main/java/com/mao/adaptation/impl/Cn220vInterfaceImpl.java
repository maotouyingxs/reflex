package com.mao.adaptation.impl;

import com.mao.adaptation.Cn220vInterface;

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
