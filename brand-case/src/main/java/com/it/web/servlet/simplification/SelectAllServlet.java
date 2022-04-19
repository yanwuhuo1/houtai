package com.it.web.servlet.simplification;

import com.alibaba.fastjson.JSON;
import com.it.pojo.Brand;
import com.it.service.BrandService;
import com.it.service.Impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService= new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //调用service查询
        List<Brand> brands = brandService.selectAll();
        //转换成json
        String s = JSON.toJSONString(brands);
//        System.out.println(s);

        //设置字节码
        response.setContentType("text/json;charset=utf-8");
        //写入数据
        //输出到页面
        response.getWriter().write(s);
    }
}
