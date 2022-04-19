package com.it.service;


import com.it.pojo.Brand;
import com.it.pojo.PageBean;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface BrandService {
    //查询所有
    List<Brand> selectAll();

    //添加
    void add(Brand brand);

    //批量删除
    void deleteById(int[] ids);

    void del(int id);

    //分页查询//当前页码
    /*
     * currentPage当前页码
     * pageSize每页展示条数
     * */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /*
     * 分页条件查询
     * */
    PageBean<Brand> selectByPageAndCount(int currentPage, int pageSize, Brand brand);


    void  update(Brand brand);
}
