# Java_Study
----
* 子类继承父类
  * 父类有无参构造函数，子类隐式调用
  * 父类即有有无参构造函数，也有无参构造函数，可选择初始化哪种
  * 父类只有有参构造函数，子类要显示调用父类的构造函数，且调用放在构造函数第一位；
    ```java
    class Son extends Person {
    String sondata;

    public Son(String name, char sex, int age,String sondata) {
        super(name, sex, age);//放在第一行
        this.sondata = sondata;//初始化子类自己的变量
    }
    ```
    
----
* 文件操作
  * 博客：http://blog.csdn.net/oypj2010/article/details/7660150
  * 讲义：https://mingfei.gitbooks.io/training-lecture/content/javase/exercise.html

----
* Java学习计划
  * 规划学习模块，学会查看API文档，使用java语言时的定位
  * 基本数据类型
    * int
    * boolean
    * String
    * float
    * byte
  * 集合
    * Iterator
      * hasNext()
      * next()
      * remove()
    * List --可重复元素
      * ArrayList －－在查询方面更快
      * LinkedList －－在添加和删除元素更快
      * Vector －－Vector使用synchronized方法（线程安全）性能上比ArrayList要差
    * Set --不可重复元素
      * HashSet --无序,高效
      * LinkedHashSet --按元素添加顺序排序
    * Map
      * HashMap --无序
      * LinkedHashMap --按元素添加顺序排序
    * 结构
        * Iterable
          ├Collection
          │├List
          ││├LinkedList
          ││├ArrayList
          ││└Vector
          ││　└Stack
          │└Set
          ││├HashSet
          │││├LinkedHashSet
          Map
          ├Hashtable
          ├HashMap
          └WeakHashMap
  * until
    * Arrays
      * asList
      * sort
      * equals
      * binarySearch
    * Collections
  * 读写文件
    * StringBuffer -常用
    * StringBuilder -常用
    * InputStream
    * OutputStream
    * FileReader -常用
    * FileWriter -常用
    * InputStreamReader -常用
    * OuputStreamWriter -常用
    * BufferedReader -常用
    * BufferedWriter -常用
  * 网络请求
    * Httpclient4.5 -常用(继承HttpUrlConnection)
    * HttpUrlConnection -(继承HttpUrlConnection)
    * UrlConnection
  * 数据存储格式
    * Yaml - 解析包(snakeYaml)
    * Json - 解析包(jedis)
  * 多线程
    * Runnable
    * Thread