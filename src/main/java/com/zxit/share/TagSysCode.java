package com.zxit.share;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Component;

import com.zxit.model.SysCode;
import com.zxit.service.SysCodeService;

@Component
public class TagSysCode extends BaseTagConfig {

    private static final long serialVersionUID = 1L;

    //注册服务
    private static SysCodeService sysCodeService;

    private String id;
    private String name;
    private String style;
    private Integer typeId;// syscode的typeid
    private Integer value;//值
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

    public String tagFactory() {
        sysCodeService = this.getBean("sysCodeService");//注册服务
        StringBuilder sb = new StringBuilder();
        sb.append("<select class='" + this.style + "' id='" + this.id
                + "' name='" + this.name + "' >");
        sb.append("<option pvalue=\"\" value=\"\" >&nbsp;</option>");
        try {

            List<SysCode> list = new ArrayList<SysCode>();
            if (this.typeId != null) {
                list = sysCodeService.findSysCodeByPid(typeId);
            }
            if (list.size() == 0) {
                return "";
            }
            for (SysCode d : list) {
                sb.append("<option pvalue=\"" + d.getSysCodeType().getTypeid() + "\" value=\"" + d.getCode() + "\"");
                //有值的情况下
                if (this.value != null) {
                    if (d.getCode().equals(value)) {
                        sb.append(" selected = \"selected\" ");//选中
                    }
                } else {
                    if (d.getCode().equals(defaltValue)) {
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer isDefaltValue() {
        return defaltValue;
    }

    public void setDefaltValue(Integer defaltValue) {
        this.defaltValue = defaltValue;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "TagSysCode [id=" + id + ", name=" + name + ", style=" + style
                + ", typeId=" + typeId + ", value=" + value + ", defaltValue="
                + defaltValue + "]";
    }

    public static void main(String[] args) {
        TagSysCode taglibService = new TagSysCode();
        System.out.println(taglibService.toString());
    }


}
