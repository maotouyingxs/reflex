package com.mao.adaptation.impl;

import com.mao.adaptation.Jp110vInterface;

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
