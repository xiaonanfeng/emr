package com.zxit.share;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpSql {

    @SuppressWarnings("resource")
    public List<String> getTableInsertSql(Connection conn, String tableName,
                                          String where) throws Exception {
        ResultSet rs = null;
        Statement statement = null;
        List<String> list = null;
        try {
            DatabaseMetaData metadata = conn.getMetaData();
            rs = metadata.getColumns(null, null, tableName, "%"); // 得到表的字段列表

            String sql = "select 'insert into " + tableName + " values ( '";
            int count = 0;
            int counts = 0;
            // 获得列的总数
            while (rs.next()) {
                count++;

            }
            // 重新获得列数据 整理成sql
            rs = metadata.getColumns(null, null, tableName, "%"); // 得到表的字段列表
            while (rs.next()) {
                counts++;
                if (counts <= count) {
                    Object colName = rs.getObject("column_name");
                    sql += " ||'''' ||" + colName + "|| ''','";
                }
            }
            sql = sql.substring(0, sql.length() - 2) + "'";
            sql += " || ' );' from " + tableName + where;
            rs.close();

            //System.out.println(sql);
            // 执行
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            // 将SQL语句放到List中
            list = new ArrayList<String>();
            while (rs.next())
                list.add(rs.getObject(1).toString());
            rs.close();

            // System.out.println(list.size());
        } finally {
            if (rs != null)
                rs.close();
            if (statement != null)
                statement.close();
        }
        return list;
    }

    public static void main(String[] args) {
        // 通过xml读取数据库
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@10.58.7.164:1521:ORCL";// 数据库连接，oracle代表链接的是oracle数据库；thin:@MyDbComputerNameOrIP代表的是数据库所在的IP地址（可以保留thin:）；1521代表链接数据库的端口号；ORCL代表的是数据库名称

            String UserName = "zz120";// 数据库用户登陆名 ( 也有说是 schema 名字的 )

            String Password = "zz120";// 密码
            try {
                conn = DriverManager.getConnection(url, UserName, Password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ExpSql expSql = new ExpSql();
        try {
            List<String> list = expSql.getTableInsertSql(conn, "SYS_EMT_INFO", "");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
