package com.mao.strategy;

/**
 * @author by maotouying
 * @Classname Strategy
 * @Description 策略模式 定义抽象方法 所有支持公共接口
 * @Date 2021/7/8 21:53
 */
public abstract class Strategy {
    /**
     * 算法方法
     */
    abstract void algorithmInterface();
}

class StrategyA extends Strategy {

    @Override
    void algorithmInterface() {
        System.out.println("普通会员算法A");
    }
}

class StrategyB extends Strategy {

    @Override
    void algorithmInterface() {
        System.out.println("黄金会员算法B");
    }
}

class StrategyC extends Strategy {

    @Override
    void algorithmInterface() {
        System.out.println("铂金会员算法C");
    }
}

/**
 * 使用上下文维护算法策略
 */
class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void algorithmInterface(){
        strategy.algorithmInterface();
    }
}
