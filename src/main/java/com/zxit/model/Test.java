package com.zxit.model;

import java.lang.reflect.Field;

/**
 * 代码生成器
 *
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("com.zxit.model.MisEmrPe"); //要包名+类名
            Field[] fields = c.getDeclaredFields();//拿到数据成员
            System.out.println("原属性");
            for (Field f : fields) {
                String name = f.getName();
                System.out.println(name);
            }
            System.out.println("生成input");
            for (Field f : fields) {
                String name = f.getName();
                System.out.println("<input id=\"" + name + "\" name=\"" + name + "\" class=\"input_full\" type=\"text\" >");
            }
            System.out.println("生成对象bean属性");
            for (Field f : fields) {
                String name = f.getName();
                System.out.println("${misEmrPe." + name + "}");
            }
            System.out.println("生成jquery代码");
            for (Field f : fields) {
                String name = f.getName();
                System.out.println(name + ":" + "$(\"#" + name + "\").val(),");
            }
            System.out.println("生成后台select");
            for (Field f : fields) {
                String name = f.getName();
                System.out.println("createSelects(Constants. ,\"" + name + "\",\"\",request);");
            }
            System.out.println("初始化赋值");
            for (Field f : fields) {
                String name = f.getName();
                System.out.println("custom_options($(\"#" + name + "\"),'${vmisEmrPe." + name + "}')");
            }
            System.out.println("系统常量");
            for (Field f : fields) {
                String name = f.getName();
                System.out.println("public static final Integer " + name + " = ;");
            }
        } catch (Exception e) {

        }

    }
}
