package com.zxit.wbss.obj;

/**
 * 呼出webSS JSON承载对象
 *
 * @author Administrator
 */
public class GW_RequestOpenConf {

    // / 急救事件受理LSH
    private String LSH;
    // / 出车序号
    private Integer CCXH;
    // / 请求医生ID
    private String REQ_USERID;
    // / 病历ID
    private String EMR_ID;
    // / 远程医学指导请求严重等级
    private Integer REQ_LEVEL;

    public String getLSH() {
        return LSH;
    }

    public void setLSH(String lSH) {
        LSH = lSH;
    }

    public Integer getCCXH() {
        return CCXH;
    }

    public void setCCXH(Integer cCXH) {
        CCXH = cCXH;
    }

    public String getREQ_USERID() {
        return REQ_USERID;
    }

    public void setREQ_USERID(String rEQ_USERID) {
        REQ_USERID = rEQ_USERID;
    }

    public String getEMR_ID() {
        return EMR_ID;
    }

    public void setEMR_ID(String eMR_ID) {
        EMR_ID = eMR_ID;
    }

    public Integer getREQ_LEVEL() {
        return REQ_LEVEL;
    }

    public void setREQ_LEVEL(Integer rEQ_LEVEL) {
        REQ_LEVEL = rEQ_LEVEL;
    }

    @Override
    public String toString() {
        return "GW_RequestOpenConf [LSH=" + LSH + ", CCXH=" + CCXH
                + ", REQ_USERID=" + REQ_USERID + ", EMR_ID=" + EMR_ID
                + ", REQ_LEVEL=" + REQ_LEVEL + "]";
    }


}
