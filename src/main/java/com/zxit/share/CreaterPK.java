package com.zxit.share;


import java.util.Date;


import com.zxit.dao.ABaseDao;
import com.zxit.tools.UtilDate;

/**
 * 功能描述：生成数据库表中的主键的对象 作者：JoryLee 日期：
 */
public class CreaterPK {
    private static int random = 0; // 主键后缀

    /**
     * yyyymmddhhmmss+random5
     * 2016 03 24 00 22 58 00001
     *
     * @return
     */
    public static String CreatePK() {
        // 获得按照年月日生成的流水号
        String ymdhms = UtilDate.formatDate(new Date(), "yyyyMMddHHmmss");//年月日时分秒
        random++;
        if (random > 999999) {//。。。。有毛病的
            //0000000001
            random = 0;
        }
        String end = formatRdm(random);
        String strTmp = ymdhms + end;
        return strTmp;
    }

    /**
     * 给不够长的添加个0
     *
     * @param param
     * @return
     */
    private static String formatRdm(int param) {
        String returnStr = String.valueOf(param);
        while (returnStr.length() < 6) {
            returnStr = "0" + returnStr;
        }
        return returnStr;
    }

    /**
     * 根据序列生成key
     */
    public static String CreateSqPk(ABaseDao aBaseDao, String squenceName) {
        String pkey = aBaseDao.findBySQL("select " + squenceName + ".nextval  from dual").uniqueResult().toString();
        return pkey;
    }


    /**
     * 根据表和字段获取中文注释
     *
     * @param aBaseDao
     * @param tablename
     * @param colum
     * @return
     */
    public static String forCn(ABaseDao aBaseDao, String tablename, String colum) {
        String str = "";
        String sql = "";
        try {
            sql = "select comments from ( select replace(column_name,'_','') as colname ,comments,replace(Table_Name,'_','') as tablename from user_col_comments )"
                    + "where tablename = '"
                    + tablename.toUpperCase()
                    + "'  and colname = '" + colum.toUpperCase() + "' ";
            str = aBaseDao.findBySQL(sql).uniqueResult().toString();
        } catch (Exception e) {
            System.out.println(sql);
            return "<font color='red' title='" + tablename + ":" + colum + "'>这可能是个错误！</red>";
        }
        return str;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String str = CreaterPK.CreatePK();
            System.out.println(str);
        }
    }

}
