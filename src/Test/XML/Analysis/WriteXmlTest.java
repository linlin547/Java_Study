package Test.XML.Analysis;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * Created by mac-li on 16/4/29.
 */
public class WriteXmlTest {
    private Document doc;

    public WriteXmlTest() {
        this.doc = DocumentHelper.createDocument();
    }
    public void createDoc(){
        //增加root 节点
        Element books = doc.addElement("books");
        //增加child 元素
        Element book1 = books.addElement("book");
        Element title = books.addElement("title");
        Element author = books.addElement("author");
        //元素添加属性
        book1.addAttribute("id","101");
        book1.setText("example");
        //元素添加text内容
        title.setText("一本书");
        author.setText("mobike");
        //实例化输出格式对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置输出编码
        format.setEncoding("UTF-8");
        //写入目标文件
        File file = new File(System.getProperty("user.dir")+File.separator+"DataFile"+File.separator+"book.xml");
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
            writer.write(doc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WriteXmlTest writeXmlTest = new WriteXmlTest();
        writeXmlTest.createDoc();
    }
}
