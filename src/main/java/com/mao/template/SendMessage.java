package com.mao.template;

/**
 * @author mao
 * @date 2021-06-26
 */
public abstract class SendMessage {

    public void headLog() {
        System.out.println("调用运营商开始记录日志...");
    }

    public void footLog() {
        System.out.println("调用运营商结束记录日志...");
    }

    /**
     * 调用不同运营商发送短信
     */
    public abstract void httpRequest();

    /**
     * 发送短信
     */
    public void sendMessage() {
        headLog();
        httpRequest();
        footLog();
    }
}
