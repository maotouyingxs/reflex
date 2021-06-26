package com.mao.exterior;

/**
 * @author mao
 * @date 2021-06-26
 */
public class ClientTest {
    public static void main(String[] args) {
        /*
        AliSmsService aliSmsService = new AliSmsServiceImpl();
        WeixinSmsSerice weixinSmsSerice = new WeixinSmsSericeImpl();
        EamilSmsService eamilSmsService = new EamilSmsServiceImpl();
        aliSmsService.sendMsg();
        weixinSmsSerice.sendMsg();
        eamilSmsService.sendMsg();
        */
        new Computer().sendMsg();
    }
}
