package com.zxit.model;

public class SysRoleStr {

    private String find;//查看权限
    private String save;//操作权限
    private String listAll;//是否遍历所有信息


    public String getListAll() {
        return listAll;
    }

    public void setListAll(String listAll) {
        this.listAll = listAll;
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    @Override
    public String toString() {
        return "SysRoleStr [find=" + find + ", save=" + save + ", listAll="
                + listAll + "]";
    }


}
