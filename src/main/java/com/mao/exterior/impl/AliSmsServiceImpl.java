package com.mao.exterior.impl;

import com.mao.exterior.AliSmsService;

/**
 * @author mao
 * @date 2021-06-26
 */
public class AliSmsServiceImpl implements AliSmsService {
    @Override
    public void sendMsg() {
        System.out.println("阿里短信发送...");
    }
}
