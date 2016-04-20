package AnalysisYaml;

import net.sf.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Created by mac-li on 16/4/20.
 */
public class AnaYaml {
    private static String confirmUrl;
//    private static String YamlPath = "/Users/mac-li/Documents/Java_project/Java_Study/DataFile/Testyaml.yaml";
    private static String YamlPath;
    private static String Yamlpathfile = "DataFile/Testyaml.yaml";
    public AnaYaml() throws IOException {
        //获取class文件路径
//        URL xmlpath = this.getClass().getClassLoader().getResource("");
//        System.out.println(xmlpath);
        //第二种：获取项目路径
        // 参数为空
        String courseFile = new File("").getCanonicalPath();
        YamlPath = courseFile+File.separator+Yamlpathfile;
        System.out.println(courseFile);
        System.out.println(YamlPath);

    }

    public  Map<String, Object> getYaml() throws IOException {
        
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(YamlPath);
        Map<String, Object> map = (Map<String, Object>) yaml.load(inputStream);
        inputStream.close();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String strx = iterator.next();
            if (map.get(strx) instanceof Map) {
                for (String str : ((Map<String, Object>) map.get(strx)).keySet()) {
                    System.out.printf("key:%s value:%s%n", str, ((Map<String, Object>) map.get(strx)).get(str));
                }
            }else {
                System.out.println(1);
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException {

        new AnaYaml().getYaml();

    }
}
