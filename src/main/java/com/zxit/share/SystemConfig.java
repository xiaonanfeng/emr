package com.zxit.share;

public class SystemConfig {

    private String checker;// 系统注册码
    private String systemTitle;// 系统标题
    private String printTitle;// 打印标题
    private String xzbm;// 授权行政编码
    private Integer onlyDoctorLogin;// 限制医生登录
    private Integer shareMode;// 共享模式

    private String errLogin;
    private String errNotDoctor;
    private String errDuty;

    private String exitSentTo;//送往医院类型
    private String exitSzfz;//所在分站类型

    private Integer debugMode;// 打开调试模式
    private Integer maxPerPage;//每页显示最大数量

    private String filePath;
    private String fileType;

    private String emrCode;//外部病例编号生成规则

    private Integer imgHW;//桌面图标大小

    private String printPage;//打印页面

    private String alarmIP;//统计系统IP

    private Integer initCmplt;//是否启用模板

    private Integer autoReqScope;//修改审批间隔


    //无参构造
    public SystemConfig() {

    }

    //全参构造
    public SystemConfig(String checker, String systemTitle, String printTitle,
                        String xzbm, Integer onlyDoctorLogin,
                        Integer shareMode, String errLogin, String errNotDoctor,
                        String errDuty, String exitSentTo, String exitSzfz,
                        Integer debugMode, Integer maxPerPage, String filePath,
                        String fileType, String emrCode, Integer imgHW, String printPage,
                        String alarmIP, Integer initCmplt, Integer autoReqScope) {
        super();
        this.checker = checker;
        this.systemTitle = systemTitle;
        this.printTitle = printTitle;
        this.xzbm = xzbm;
        this.onlyDoctorLogin = onlyDoctorLogin;
        this.shareMode = shareMode;
        this.errLogin = errLogin;
        this.errNotDoctor = errNotDoctor;
        this.errDuty = errDuty;
        this.exitSentTo = exitSentTo;
        this.exitSzfz = exitSzfz;
        this.debugMode = debugMode;
        this.maxPerPage = maxPerPage;
        this.filePath = filePath;
        this.fileType = fileType;
        this.emrCode = emrCode;
        this.imgHW = imgHW;
        this.printPage = printPage;
        this.alarmIP = alarmIP;
        this.initCmplt = initCmplt;
        this.setAutoReqScope(autoReqScope);
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getSystemTitle() {
        return systemTitle;
    }

    public void setSystemTitle(String systemTitle) {
        this.systemTitle = systemTitle;
    }

    public String getPrintTitle() {
        return printTitle;
    }

    public void setPrintTitle(String printTitle) {
        this.printTitle = printTitle;
    }

    public String getXzbm() {
        return xzbm;
    }

    public void setXzbm(String xzbm) {
        this.xzbm = xzbm;
    }

    public Integer getOnlyDoctorLogin() {
        return onlyDoctorLogin;
    }

    public void setOnlyDoctorLogin(Integer onlyDoctorLogin) {
        this.onlyDoctorLogin = onlyDoctorLogin;
    }

    public Integer getShareMode() {
        return shareMode;
    }

    public void setShareMode(Integer shareMode) {
        this.shareMode = shareMode;
    }

    public String getErrLogin() {
        return errLogin;
    }

    public void setErrLogin(String errLogin) {
        this.errLogin = errLogin;
    }

    public String getErrNotDoctor() {
        return errNotDoctor;
    }

    public void setErrNotDoctor(String errNotDoctor) {
        this.errNotDoctor = errNotDoctor;
    }

    public String getErrDuty() {
        return errDuty;
    }

    public void setErrDuty(String errDuty) {
        this.errDuty = errDuty;
    }

    public Integer getDebugMode() {
        return debugMode;
    }

    public void setDebugMode(Integer debugMode) {
        this.debugMode = debugMode;
    }

    public String getExitSentTo() {
        return exitSentTo;
    }

    public void setExitSentTo(String exitSentTo) {
        this.exitSentTo = exitSentTo;
    }

    public String getExitSzfz() {
        return exitSzfz;
    }

    public void setExitSzfz(String exitSzfz) {
        this.exitSzfz = exitSzfz;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getMaxPerPage() {
        if (maxPerPage >= 100) {
            maxPerPage = 100;
        }
        return maxPerPage;
    }

    public void setMaxPerPage(Integer maxPerPage) {
        this.maxPerPage = maxPerPage;
    }

    public String getEmrCode() {
        return emrCode;
    }

    public void setEmrCode(String emrCode) {
        this.emrCode = emrCode;
    }

    public Integer getImgHW() {
        return imgHW;
    }

    public void setImgHW(Integer imgHW) {
        this.imgHW = imgHW;
    }

    public String getPrintPage() {
        return printPage;
    }

    public void setPrintPage(String printPage) {
        this.printPage = printPage;
    }

    public String getAlarmIP() {
        return alarmIP;
    }

    public void setAlarmIP(String alarmIP) {
        this.alarmIP = alarmIP;
    }

    public Integer getInitCmplt() {
        return initCmplt;
    }

    public void setInitCmplt(Integer initCmplt) {
        this.initCmplt = initCmplt;
    }

    public Integer getAutoReqScope() {
        return autoReqScope;
    }

    public void setAutoReqScope(Integer autoReqScope) {
        this.autoReqScope = autoReqScope;
    }


    /**
     * 郑州：心电图检查情况
     * 宁波：心电检查情况
     */
    private String ecgTdText;
    /**
     * 郑州：心电图诊断
     * 宁波：心电印象
     */
    private String ecgDiagTdText;//心电印象


    public String getEcgTdText() {
        return ecgTdText;
    }

    public void setEcgTdText(String ecgTdText) {
        this.ecgTdText = ecgTdText;
    }

    public String getEcgDiagTdText() {
        return ecgDiagTdText;
    }

    public void setEcgDiagTdText(String ecgDiagTdText) {
        this.ecgDiagTdText = ecgDiagTdText;
    }


    @Override
    public String toString() {
        String page = "SystemPageText [ecgTdText=" + ecgTdText + ", ecgDiagTdText="
                + ecgDiagTdText + "]";
        System.out.println(page);
        return page;
    }


}
