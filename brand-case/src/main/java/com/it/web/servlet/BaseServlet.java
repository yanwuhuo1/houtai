package com.it.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路劲
        String requestURI = req.getRequestURI();

        //System.out.println(requestURI);
        //获取最后一段路劲

        int index = requestURI.lastIndexOf('/');

        System.out.println(index);

        String substring = requestURI.substring(index+1);

         System.out.println(substring);
        //执行方法

       // System.out.println(this);//com.it.web.servlet.BrandServlet@748dac42

        Class<? extends BaseServlet> aClass = this.getClass();
        //获取方法method对象
        try {
            Method method = aClass.getMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
