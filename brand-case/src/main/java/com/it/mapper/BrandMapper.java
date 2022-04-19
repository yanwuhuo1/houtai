package com.it.mapper;

import com.it.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    //查询
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    //添加
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);


    //批量删除
    void deleteById(@Param("ids")int[] ids);

    //删除
    @Delete("delete from tb_brand where id = #{id}")
    void del(int id);

    //分页查询
    @Select("select * from tb_brand limit #{begin},#{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    //查询总记录数
    @Select("select count(*) from tb_brand")
    int selectTotalCount();



    //根据条件分页查询
    List<Brand> selectByPageAndCount(@Param("begin") int begin, @Param("size") int size,@Param("brand") Brand brand);

    //根据条件查询总记录数
    Integer selectTotalCountByCondition(@Param("brand") Brand brand);

    void update(@Param("brand") Brand brand);
}
