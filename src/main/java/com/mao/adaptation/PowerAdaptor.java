package com.mao.adaptation;

/**
 * @author mao
 * @date 2021-06-26
 * 适配器 传入中国220V电源
 */
public class PowerAdaptor implements Jp110vInterface{
    private Cn220vInterface cn220vInterface;

    public PowerAdaptor(Cn220vInterface cn220vInterface) {
        this.cn220vInterface = cn220vInterface;
    }

    @Override
    public void connect() {
        cn220vInterface.connect();
    }
}
