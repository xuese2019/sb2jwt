package com.springboot.crm.business.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuModel implements Serializable {

    private String uuid;
    //菜单名称
    private String mc;
    //    菜单父级
    private String parents;
    //    菜单类型 1左侧 2按钮
    private String types;
    //    权限标识
    private String flag;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public MenuModel() {
        super();
    }

    public MenuModel(String uuid, String mc, String parents, String types, String flag) {
        this.uuid = uuid;
        this.mc = mc;
        this.parents = parents;
        this.types = types;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MenuModel{" +
                "uuid='" + uuid + '\'' +
                ", mc='" + mc + '\'' +
                ", parents='" + parents + '\'' +
                ", types='" + types + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
