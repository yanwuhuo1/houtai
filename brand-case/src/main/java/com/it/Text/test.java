package com.it.Text;

import com.it.pojo.Brand;

import java.lang.reflect.Method;
/*
* 反射
*
* */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.it.pojo.Brand");
        System.out.println(aClass);

        Class<Brand> brandClass = Brand.class;
        System.out.println(brandClass);

        Brand brand = new Brand();
        Class<? extends Brand> aClass1 = brand.getClass();
        System.out.println(aClass1);

    }
}
