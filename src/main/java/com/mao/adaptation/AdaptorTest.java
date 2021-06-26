package com.mao.adaptation;

import com.mao.adaptation.impl.Cn220vInterfaceImpl;

/**
 * @author mao
 * @date 2021-06-26
 */
public class AdaptorTest {
    public static void main(String[] args) {
        // 中国220V电源
        Cn220vInterfaceImpl cn220vInterface = new Cn220vInterfaceImpl();
        // 适配器
        PowerAdaptor powerAdaptor = new PowerAdaptor(cn220vInterface);
        // 电饭煲
        ElectricCooker electricCooker = new ElectricCooker(powerAdaptor);
        electricCooker.cook();
    }
}
