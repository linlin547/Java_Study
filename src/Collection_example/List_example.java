package Collection_example;

import java.util.ArrayList;
import java.util.Iterator;

public class List_example {
    public static void List_add(){
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("java");
        a1.add("php");//List集合中的元素可以重复
        a1.add(".net");
        System.out.println("原集合："+a1);
        System.out.println("原集合长度："+a1.size());
        a1.add(1, "Flash");
        a1.add(0, "ps");
        System.out.println("添加2项后："+a1);

        ArrayList<String> a2 = new ArrayList<>();
        a2.add("javascript");
        a2.add("3dMax");
        a2.add("IBM");

        a1.addAll(0, a2);
        System.out.println("拼接list后："+a1);
        a1.remove(0);
        System.out.println("删除索引为0的元素后："+a1);
        a1.set(2,"psh");
        System.out.println("修改索引为2的元素后："+a1);
        System.out.println("获取索引为2的元素："+a1.get(2));
        System.out.println("获取索引为1-3的元素："+a1.subList(1,4));
        //遍历方式1
        System.out.println("第一种方式遍历");
        for(Object s:a1){
            String sx = (String)s;
            System.out.println(sx);
        }
        //遍历方式2
        Iterator<String> is = a1.iterator();
        System.out.println("第二种方式遍历");
        while (is.hasNext()){
            Object o = is.next();
            System.out.println(o);
        }
    }
    public static void main(String args[]){

        List_add();
    }

}
