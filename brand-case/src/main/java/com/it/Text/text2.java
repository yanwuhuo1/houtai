package com.it.Text;

import com.it.pojo.TextBrand;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
//获取构造方法
public class text2 {
    public static void main(String[] args) throws Exception {
        Class<TextBrand> textBrandClass = TextBrand.class;
//        getConstructor()获取构造方法
        Constructor<TextBrand> classLoader = textBrandClass.getConstructor(Integer.class, String.class);
        System.out.println(classLoader);
        //创建对象
        TextBrand zs = classLoader.newInstance( 121,"zs");
        System.out.println(zs);

        Constructor<TextBrand> classLoader1 = textBrandClass.getConstructor();
        System.out.println(classLoader);
        //创建对象
        TextBrand textBrand = textBrandClass.newInstance();
        System.out.println(textBrand);
    }
}
