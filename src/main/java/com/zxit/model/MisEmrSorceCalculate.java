package com.zxit.model;


/**
 * 病历评分结果简单列表
 *
 * @author Administrator
 */
public class MisEmrSorceCalculate {

    private String emr_id;
    private Integer sorce_level;
    private Integer calculate;

    public MisEmrSorceCalculate() {

    }

    public MisEmrSorceCalculate(String emr_id, Integer sorce_level, Integer calculate) {
        this.emr_id = emr_id;
        this.sorce_level = sorce_level;
        this.calculate = calculate;
    }

    public String getEmr_id() {
        return emr_id;
    }

    public void setEmr_id(String emr_id) {
        this.emr_id = emr_id;
    }

    public Integer getSorce_level() {
        return sorce_level;
    }

    public void setSorce_level(Integer sorce_level) {
        this.sorce_level = sorce_level;
    }

    public Integer getCalculate() {
        return calculate;
    }

    public void setCalculate(Integer calculate) {
        this.calculate = calculate;
    }


}
