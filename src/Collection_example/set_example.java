package Collection_example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * HashSet
 * 不允许出现重复元素
 * 不保证顺序
 */
/**
 * TreeSet
 * 不允许出现重复元素
 * 自动排序
 */
public class set_example {
    public static void has_set()
    {
        HashSet h=new HashSet();
        h.add("1st");
        h.add("2nd");
        h.add("2nd");            //重复元素，未被添加
        System.out.println("开始：size="+h.size());
        Iterator it=h.iterator();
        while(it.hasNext())
        {
            Object o=it.next();
            System.out.println(o);
        }
        System.out.println("判断是否为空"+h.isEmpty());
        System.out.println("判断是否包含对象\"1st\""+h.contains("1st"));
        h.remove("2nd");
        System.out.println("移除元素后：size="+h.size());
        h.clear();
        System.out.println("清空元素后长度："+h.size());
    }
    public static void tree_set(){
        TreeSet ts=new TreeSet();
        ts.add("orange");
        ts.add("apple");
        ts.add("banana");
        ts.add("grape");
        //首元素
        System.out.println(ts.first());
        //尾元素
        System.out.println(ts.last());
        Iterator it=ts.iterator();
        while(it.hasNext())
        {
            String fruit=(String)it.next();
            System.out.println(fruit);
        }
    }
    public static void main(String args[]){
        tree_set();
    }
}
