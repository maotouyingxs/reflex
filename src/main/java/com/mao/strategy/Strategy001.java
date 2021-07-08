package com.mao.strategy;

/**
 * @author by maotouying
 * @Classname Strategy001
 * @Description 策略模式  会员分为3种等级  铂金会员 黄金会员 普通会员 获取价格都不一样
 * @Date 2021/7/8 21:07
 */
public class Strategy001 {
    public static void main(String[] args) {

        Context context;
        context = new Context(new StrategyA());
        context.algorithmInterface();
        context = new Context(new StrategyB());
        context.algorithmInterface();
        context = new Context(new StrategyC());
        context.algorithmInterface();
    }
}
