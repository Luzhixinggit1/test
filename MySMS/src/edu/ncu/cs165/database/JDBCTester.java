package edu.ncu.cs165.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JDBCTester{

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("成功加载驱动");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String url = "jdbc:mysql://localhost:3306/mydb?user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
            connection = DriverManager.getConnection(url);
            System.out.println("成功获取连接");

            statement = connection.createStatement();
            String sql = "select * from soccer";
            resultSet = statement.executeQuery(sql);

            resultSet.beforeFirst();
            System.out.printf("       Name         Match Played   Match Win    Match Loses  "
                    + " Match Draw    Goal Scored    Goal Agains    Points%n"
                    + "*-----------------*-------------*------------*--------------*--------------*-------------*"
                    + "------------*-------------*%n");
            while (resultSet.next()) {
                for(int i=1; i<=8; i++){
                    System.out.printf("%12s",resultSet.getString(i));
                }
                System.out.println();

            }
            System.out.println("成功操作数据库");
        } catch(Throwable t) {
            // TODO 处理异常
            t.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("成功关闭资源");
        }

    }

}