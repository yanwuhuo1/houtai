package com.it.Text;

import com.it.pojo.TextBrand;

import javax.tools.Tool;
import java.lang.reflect.Field;

public class text1 {
    public static void main(String[] args) throws Exception {
        Class<TextBrand> textBrandClass = TextBrand.class;
        Field[] fields = textBrandClass.getFields();
        for (Field field : fields) {//getFields获取public修饰的成员变量
            System.out.println(field);
        }
        //Field只能修饰public设置的成员变量
        //getFields和getField,只能获取public设置的成员变量
        System.out.println("-----------------------");
        Field a = textBrandClass.getField("b");//getField只能获取被public修饰的成员变量


        TextBrand textBrand = new TextBrand();
        Object o = a.get(textBrand);
        System.out.println(o);
        System.out.println("设置b的值");
        a.set(textBrand, "zs");
        System.out.println(textBrand);
        System.out.println("-----------------------");

        //Field[] getDeclaredFields//获取所有的成员变量//不考虑修饰符
        Field[] declaredFields = textBrandClass.getDeclaredFields();
        for (Field o1 : declaredFields) {
            System.out.println(o1);
        }
        Field as = textBrandClass.getDeclaredField("a");

        //忽略访问权限修饰符的安全检查、
        as.setAccessible(true);//暴力反射

        Object o1 = as.get(textBrand);
        System.out.println(o1);


    }
}
