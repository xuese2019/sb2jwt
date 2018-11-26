package com.springboot.crm.business.menu.service.impl;

import com.springboot.crm.business.menu.mapper.MenuMapper;
import com.springboot.crm.business.menu.model.MenuModel;
import com.springboot.crm.business.menu.service.MenuService;
import com.springboot.crm.utils.result.ResponseResult;
import com.springboot.crm.utils.uuidUtil.GetUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper mapper;

    @Transactional
    @Override
    public ResponseResult<MenuModel> add(MenuModel model) {
        List<MenuModel> list = mapper.findByParentsAndMc(model.getParents(), model.getMc());
        if (list.size() > 0)
            return new ResponseResult<>(false, "同一级别下名称重复");
        model.setUuid(GetUuid.getUUID());
        mapper.add(model);
        return new ResponseResult<>(true, "成功");
    }

    @Transactional
    @Override
    public ResponseResult<MenuModel> deleteById(String uuid) {
        mapper.deleteById(uuid);
        return new ResponseResult<>(true, "成功");
    }

    @Transactional
    @Override
    public ResponseResult<MenuModel> updateById(MenuModel model) {
        mapper.updateById(model);
        return new ResponseResult<>(true, "成功");
    }

    @Override
    public ResponseResult<List<MenuModel>> findByParents(String parents, boolean isDescendants) {
        List<MenuModel> list = new ArrayList<>();
        if (isDescendants) {
            list = mapper.findAll();
            if (list.size() > 0)
                return new ResponseResult<>(true, "成功", list);
        } else {
            list = mapper.findByParents(parents);
            if (list.size() > 0)
                return new ResponseResult<>(true, "成功", list);
        }
        return new ResponseResult<>(false, "未查询到记录");
    }
}
