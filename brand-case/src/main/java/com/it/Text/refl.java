package com.it.Text;

import com.it.pojo.TextBrand;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class refl {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //可以创建任意类的对象，可以执行任意方法

        //加载配置文件
        Properties properties = new Properties();
        //获取配置文件
//        InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/main/java/com/it/Text/pro.properties"));
        properties.load(new FileInputStream("src/main/java/com/it/Text/pro.properties"));
        //获取配置文件中定义的数据
        String className = properties.getProperty("className");//获取类
        String methodName = properties.getProperty("methodName");//获取类中的方法
        //加载类进内存
        Class aClass = Class.forName(className);//将类加载进内存
        //创建对象
        Object o = aClass.newInstance();//创建新的对象//newInstance。调用类中获取无惨构造器，获取对应类的对象

        //获取方法对象
        Method method = aClass.getMethod(methodName);//获取类中的方法
        Object invoke = method.invoke(o);//


    }
}
