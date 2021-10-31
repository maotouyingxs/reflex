package com.mao.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author renshilin
 * @date 2021-10-31
 * 通过反射越过泛型检查
 */
public class Test007 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("aa");
        Class<? extends List> aClass = arrayList.getClass();
        Method add = aClass.getDeclaredMethod("add", Object.class);
        Object invoke = add.invoke(arrayList, 1);
        System.out.println(arrayList.size());
        // arrayList.forEach(System.out::println);
    }
}
