package com.zxit.model;

import java.util.List;

public class TObject {

    private String selectIdAndName;//id和name
    private String style;//页面class
    private String onChgMthd;//onchange方法

    private String ObecjtName;//基本没啥用
    private List<String> InitStr;//初始化值


    public TObject() {
    }

    /**
     * @param selectIdAndName
     * @param style
     * @param onChgMthd
     */
    public TObject(String selectIdAndName, String style, String onChgMthd) {
        this.selectIdAndName = selectIdAndName;
        this.style = style;
        this.onChgMthd = onChgMthd;
    }

    public String getSelectIdAndName() {
        return selectIdAndName;
    }

    public void setSelectIdAndName(String selectIdAndName) {
        this.selectIdAndName = selectIdAndName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getOnChgMthd() {
        return onChgMthd;
    }

    public void setOnChgMthd(String onChgMthd) {
        this.onChgMthd = onChgMthd;
    }

    public List<String> getInitStr() {
        return InitStr;
    }

    public void setInitStr(List<String> initStr) {
        InitStr = initStr;
    }

    public String getObecjtName() {
        return ObecjtName;
    }

    public void setObecjtName(String obecjtName) {
        ObecjtName = obecjtName;
    }


}
