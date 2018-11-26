package com.springboot.crm.business.menu.controller;

import com.springboot.crm.business.menu.model.MenuModel;
import com.springboot.crm.business.menu.service.MenuService;
import com.springboot.crm.utils.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ResponseResult<List<MenuModel>> findAll() {
        return service.findByParents(null, false);
    }
}
