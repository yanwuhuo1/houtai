package com.it.web.servlet;

import com.alibaba.fastjson.JSON;
import com.it.pojo.Brand;
import com.it.pojo.PageBean;
import com.it.service.BrandService;
import com.it.service.Impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();
    //查询
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<Brand> brands = brandService.selectAll();

        //2. 转为JSON
        String jsonString = JSON.toJSONString(brands);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    //分页查询
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //接收当前页码和每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    //根据条件分页查询
    public void selectByPageAndCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收当前页码和每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //接收页面传回来的方法体
        request.setCharacterEncoding("UTF-8");
        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        //转换brand对象
        Brand brand = JSON.parseObject(s, Brand.class);

        if (brand == null){
            brand = new Brand();
        }
        PageBean<Brand> pageBean = brandService.selectByPageAndCount(currentPage, pageSize,brand);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收页面传回来的方法体
        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        //转换brand对象
        Brand brand = JSON.parseObject(s, Brand.class);
        brandService.add(brand);
        response.getWriter().write("success");


    }

    //批量删除
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收页面传回来的方法体
        //接收数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        //转换int[]
        int[] ints = JSON.parseObject(s, int[].class);

        brandService.deleteById(ints);
        response.getWriter().write("success");
    }
    //删除
    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*//接收页面传回来的方法体
        //接收数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();


        //转换int[]
        Integer integer = JSON.parseObject(s, int.class);*/

        String id = request.getParameter("id");

        brandService.del(Integer.parseInt(id));
        response.getWriter().write("{\"code\": \"200\"}");
    }
    //修改
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        //转换int[]
        Brand brand = JSON.parseObject(s, Brand.class);

        brandService.update(brand);
        response.getWriter().write("success");
    }

}
