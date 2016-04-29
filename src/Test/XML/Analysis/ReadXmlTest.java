package Test.XML.Analysis;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Created by mac-li on 16/4/29.
 */
public class ReadXmlTest {
    private static String xmlpath;

    public  ReadXmlTest(){
        xmlpath = System.getProperty("user.dir") + File.separator+"DataFile/TestTmp.xml";
    }

    public static void test() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(xmlpath));
        //获取根元素
        Element root = document.getRootElement();
        System.out.println("Root:"+root.getName());
        //获取所有自元素
        List<Element> childs = root.elements();
        System.out.println("child num:"+childs.size());
        //获取名字为指定名称的第一个子元素text和属性值
        System.out.println(root.element("hello").getText());
        System.out.println(root.element("hello").attributeValue("name"));
        //循环取值
        for(Element element : childs){
            //未知属性名的情况下
            //获取标签属性，声明Attribute好获取值
            List<Attribute> list = element.attributes();
            //判断是否有属性作处理
            if (list.size()>0){
                System.out.printf("Text:%s%n", element.getText());
                for(Attribute s : list){
                    System.out.printf("Attr_Vlaue:%s%n", s.getValue());
                }
            }else {
                System.out.println("Text no attr:"+element.getText());
            }
        }
    }

    public static void main(String[] args) throws DocumentException {
        ReadXmlTest readXmlTest = new ReadXmlTest();
        readXmlTest.test();
    }
}
