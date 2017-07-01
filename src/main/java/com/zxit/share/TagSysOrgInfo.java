package com.zxit.share;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Component;

import com.zxit.model.SysOrgInfo;
import com.zxit.service.SysOrgInfoService;

@Component
public class TagSysOrgInfo extends BaseTagConfig {

    private static final long serialVersionUID = 1L;

    //注册服务
    private static SysOrgInfoService sysOrgInfoService;

    private String id;
    private String name;
    private String style;
    private Integer[] type;
    private String value;//值
    private Integer defaltValue;//默认值

    /**************** TagSupport *****************/
    @Override
    public int doStartTag() throws JspException {
        try {
            PageContext pageContext = this.pageContext;
            JspWriter writer = pageContext.getOut();
            writer.print(tagFactory());//输出前台的html
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }

    @SuppressWarnings("static-access")
    public String tagFactory() {
        sysOrgInfoService = this.getBean("sysOrgInfoService");//注册服务
        StringBuilder sb = new StringBuilder();
        sb.append("<select class='" + this.style + "' id='" + this.id + "' name='" + this.name + "' >");
        sb.append("<option pvalue=\"\" value=\"\" >&nbsp;</option>");
        try {

            List<SysOrgInfo> list = new ArrayList<SysOrgInfo>();
            if (this.type != null) {
                //list = sysOrgInfoService.findSysOrgInfoByType(this.type);
            }
            if (list.size() == 0) {
                return "";
            }
            for (SysOrgInfo d : list) {
                sb.append("<option pvalue=\"" + d.getSsjgdm() + "\" value=\"" + d.getOrgId() + "\"");
                //有值的情况下
                if (this.value != null) {
                    if (d.getOrgId().equals(value)) {
                        sb.append(" selected = \"selected\" ");//选中
                    }
                } else {
                    if (d.getOrgId().equals(defaltValue)) {
                        sb.append(" selected = \"selected\" ");//选中
                    }
                }
                sb.append(">" + d.getName() + "</option>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("</select>");
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer isDefaltValue() {
        return defaltValue;
    }

    public void setDefaltValue(Integer defaltValue) {
        this.defaltValue = defaltValue;
    }

    public Integer[] getType() {
        return type;
    }

    public void setType(Integer[] type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TagSysCode [id=" + id + ", name=" + name + ", style=" + style
                + ", type=" + type + ", value=" + value + ", defaltValue="
                + defaltValue + "]";
    }


}
