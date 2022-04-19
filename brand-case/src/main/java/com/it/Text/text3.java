package com.it.Text;

import com.it.pojo.TextBrand;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//获取构造方法
public class text3 {
    public static void main(String[] args) throws Exception {
        Class<TextBrand> textBrandClass = TextBrand.class;
        //获取指定的名称方法
        Method setA = textBrandClass.getMethod("setA");
        TextBrand textBrand = new TextBrand();
        //invoke执行方法
       setA.invoke(textBrand);

        //获取指定的名称方法
        Method setA1 = textBrandClass.getMethod("setA1",Integer.class);
        //invoke执行方法
        setA1.invoke(textBrand,1);
        System.out.println("------------------------");

        //获取所有public修饰的方法
        Method[] methods = textBrandClass.getMethods();
        for (Method method :methods) {
            System.out.println(method);
        }


    }
}
