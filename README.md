# Java_Study
----
* Idea
  * alt+ insert -->构造函数
  * ctrl+o --> 覆盖/重写
  
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
