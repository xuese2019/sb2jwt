package com.springboot.crm.business.menu.service;

import com.springboot.crm.business.menu.model.MenuModel;
import com.springboot.crm.utils.result.ResponseResult;

import java.util.List;

public interface MenuService {

    ResponseResult<MenuModel> add(MenuModel model);

    ResponseResult<MenuModel> deleteById(String uuid);

    ResponseResult<MenuModel> updateById(MenuModel model);
//isDescendants = true 全部，isDescendants = false 只是下级
    ResponseResult<List<MenuModel>> findByParents(String parents,boolean isDescendants);
}
