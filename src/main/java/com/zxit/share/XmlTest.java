package com.zxit.share;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class XmlTest {

    public static void main(String[] args) {
        try {
            SAXBuilder saxbBuilder = new SAXBuilder();
            Document doc = saxbBuilder.build(XmlTest.class.getClassLoader().getResourceAsStream("prevs.xml"));
            Element root = doc.getRootElement();
            System.out.println("格式化XML");
            List Node = root.getChildren("prevs");
            for (int j = 0; j < Node.size(); j++) {
                Element e = (Element) Node.get(j);
                System.out.println(e.getAttributeValue("xzbm"));
                System.out.println(e.getChildText("memberType"));
                System.out.println(e.getChild("entityName").getAttributeValue("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
