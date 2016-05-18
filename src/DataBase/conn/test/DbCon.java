package DataBase.conn.test;

import redis.clients.jedis.Jedis;

import java.sql.*;

public class DbCon {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /**
         * Mysql
         **/
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://127.0.0.1:3306?useUnicode=true&characterEncoding=gbk";
        // MySQL配置时的用户名
        String user = "001";
        // MySQL配置时的密码
        String password = "123";
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement stmt = conn.createStatement();

            //选择DB
            String usedb = "use DBname;";
            //执行sql
            String sql = "select * from MBK_USERS where MOBILENO <> '';";
            stmt.execute(usedb);
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                System.out.printf(resultSet.getString("username")+"-"+resultSet.getString("mobileno")+"\n");
            }
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /**
         * Postgresql
         * driver 下载地址：http://jdbc.postgresql.org/download.html
         **/
        try
        {
            Class.forName( " org.postgresql.Driver " ).newInstance();
            String urls = " jdbc:postgresql://localhost:5432/postgres " ;
            Connection con = DriverManager.getConnection(urls, " postgres " , " 1234 " );
            Statement st = con.createStatement();
            String sql = " select * from testtable " ;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                System.out.print(rs.getInt( 1 ));
                System.out.println(rs.getString( "name" ));
            }
            rs.close();
            st.close();
            con.close();


        }
        catch (Exception ee)
        {
            System.out.print(ee.getMessage());
        }
        /**
         * Redis
         **/
        String key = "";
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //set key-value
        jedis.set("key","value");
        //read key-value
        String data = jedis.get(key);
        System.out.println(data);
    }
}
