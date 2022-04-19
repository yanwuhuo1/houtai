package com.it.web.servlet.simplification;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.it.pojo.Brand;
import com.it.service.BrandService;
import com.it.service.Impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService=new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




            //接收页面传回来的方法体
            BufferedReader reader = request.getReader();
            if (reader==null) {

                response.getWriter().write("");

            }else {
                String s = reader.readLine();

                //转换brand对象
                Brand brand = JSON.parseObject(s, Brand.class);
                brandService.add(brand);
                response.getWriter().write("success");
            }







    }
}
