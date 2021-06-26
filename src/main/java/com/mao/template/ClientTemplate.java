package com.mao.template;

/**
 * @author mao
 * @date 2021-06-26
 */
public class ClientTemplate {
    public static void main(String[] args) {
        YiDong yiDong = new YiDong();
        yiDong.sendMessage();
        LianTong lianTong = new LianTong();
        lianTong.sendMessage();
    }
}
