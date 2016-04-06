package Collection_example;

import java.util.*;


public class Hashmap_List {

    public static void main(String[] args) {

        //定义保存学生信息的List，元素类型为HashMap
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        Scanner input = new Scanner(System.in);

        System.out.println("请输入学生的信息,y表示继续，n表示退出");
        while("y".equals(input.next())) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            System.out.println("请输入学号");
            map.put("studentno", input.next());
            System.out.println("请输入姓名");
            map.put("name", input.next());
            System.out.println("请输入年龄");
            map.put("age", input.nextInt());
            list.add(map);
            System.out.println("请继续输入学生的信息,y表示继续，n表示退出");
        }

        System.out.println("输入的学生信息为:");
        System.out.println("学生数量为:" + list.size());

        Iterator<HashMap<String, Object>> it = list.iterator();
        int i = 1;
        while(it.hasNext()) {
            HashMap<String, Object> stuMap = it.next();
            System.out.print("第" + i + "个学生的信息为");
            System.out.println("学号:" + stuMap.get("studentno") + " ,姓名:" + stuMap.get("name") + " ,年龄:" + stuMap.get("age"));
        }
    }
}