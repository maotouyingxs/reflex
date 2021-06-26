package com.mao.exterior.impl;

import com.mao.exterior.WeixinSmsSerice;

/**
 * @author mao
 * @date 2021-06-26
 */
public class WeixinSmsSericeImpl implements WeixinSmsSerice {
    @Override
    public void sendMsg() {
        System.out.println("微信发送...");
    }
}
