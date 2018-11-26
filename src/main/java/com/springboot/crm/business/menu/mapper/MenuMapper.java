package com.springboot.crm.business.menu.mapper;

import com.springboot.crm.business.menu.model.MenuModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper {

    String table = " menu_table ";

    @Insert({
            "insert into "+ table+" (uuid,mc,parents,types,flag) values" +
                    " (#{model.uuid},#{model.mc},#{model.parents},#{model.types},#{model.flag})"
    })
    int add(@Param("model") MenuModel model);

    @Delete({
            "delete "+table+" where uuid = #{uuid}"
    })
    int deleteById(@Param("uuid") String uuid);

    @Update({
            "update "+ table +
                    " set mc = #{model.mc},parents = #{model.parents},types = #{model.types},flag = #{model.flag}" +
                    " where uuid = #{model.uuid}"
    })
    int updateById(@Param("model") MenuModel model);

    @Select({
            "select * from "+ table+" where parents = #{parents}"
    })
    List<MenuModel> findByParents(@Param("parents") String parents);

    @Select({
            "select * from "+ table+" where parents = #{parents} and mc = #{mc}"
    })
    List<MenuModel> findByParentsAndMc(@Param("parents") String parents,@Param("mc") String mc);

    @Select({
            "select * from "+ table
    })
    List<MenuModel> findAll();

}
