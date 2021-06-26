package com.mao.exterior;

import com.mao.exterior.impl.AliSmsServiceImpl;
import com.mao.exterior.impl.EamilSmsServiceImpl;
import com.mao.exterior.impl.WeixinSmsSericeImpl;

/**
 * @author mao
 * @date 2021-06-26
 * 门面类
 */
public class Computer {
    private EamilSmsService eamilSmsService;
    private WeixinSmsSerice weixinSmsSerice;
    private AliSmsService aliSmsService;

    public Computer() {
        this.aliSmsService = new AliSmsServiceImpl();
        this.weixinSmsSerice = new WeixinSmsSericeImpl();
        this.eamilSmsService = new EamilSmsServiceImpl();
    }

    public void sendMsg() {
        aliSmsService.sendMsg();
        weixinSmsSerice.sendMsg();
        eamilSmsService.sendMsg();
    }
}
