package Collection_example;

import java.util.*;

/**
 * Arrays的asList()方法 可以将数组转为List,8种基本数据类型不行
 * List的toArray()返回Object数组;
 * List的toArray(T[] a)返回包含此列表中所有元素的数组
 */
public class Switchto_Map_List_Set_Arrays {
    private static void testArray2List() {
        //数组-->List
        String[] ss = {"JJ","KK"};
        List<String> list1 = Arrays.asList(ss);
        List<String> list2 = Arrays.asList("AAA","BBB");
        System.out.println(list1);
        System.out.println(list2);
    }
    private static void testList2Array() {
        //List-->数组
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        list.add("CC");
        Object[] objects = list.toArray();//返回Object数组
        System.out.println("objects:"+Arrays.toString(objects));
        String[] arr = new String[list.size()];
        list.toArray(arr);//将转化后的数组放入已经创建好的对象arr中
        System.out.println("strings1:"+Arrays.toString(arr));
    }
    private static void testList2Set() {
        //List-->Set
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("EFG");
        Set<String> listSet = new HashSet<>(list);
        System.out.println(listSet);
    }
    private static void testSet2List() {
        //Set --> List
        Set<String> set = new HashSet<>();
        set.add("AA");
        set.add("BB");
        set.add("CC");
        List<String> setList = new ArrayList<>(set);
        System.out.println(setList);
    }
    private static void testArray2Set() {
        //数组-->Set:
        //思路：数组->List－>Set
        String[] arr = {"AA","BB","DD","CC","BB"};
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        System.out.println(set);
    }
    private static void testSet2Array() {
        //Set-->数组
        Set<String> set = new HashSet<>();
        set.add("AA");
        set.add("BB");
        set.add("CC");
        String[] arr = new String[set.size()];
        set.toArray(arr);//将转化后的数组放入已经创建好的对象arr中
        System.out.println(Arrays.toString(arr));
    }
    private static void testMap2Set() {
        //Map-->Set
        Map<String, String> map = new HashMap<>();
        map.put("A", "ABC");
        map.put("K", "KK");
        map.put("L", "LV");
        // 将Map 的键转化为Set
        Set<String> mapKeySet = map.keySet();
        System.out.println("mapKeySet:"+mapKeySet);
        // 将Map 的值转化为Set
        Set<String> mapValuesSet = new HashSet<>(map.values());
        System.out.println("mapValuesSet:"+mapValuesSet);
    }
    private static void testMap2List() {
        //Map-->List
        Map<String, String> map = new HashMap<>();
        map.put("A", "ABC");
        map.put("K", "KK");
        map.put("L", "LV");
        // 将Map Key 转化为List
        //思路：Set－>List
        List<String> mapKeyList = new ArrayList<>(map.keySet());
        System.out.println("mapKeyList:"+mapKeyList);
        // 将Map Key 转化为List
        //思路：Set－>List
        List<String> mapValuesList = new ArrayList<>(map.values());
        System.out.println("mapValuesList:"+mapValuesList);
    }
    public static void main(String args[]){
        testList2Set();

    }
}
