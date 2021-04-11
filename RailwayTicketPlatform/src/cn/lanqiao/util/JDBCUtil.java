package cn.lanqiao.util;

import org.junit.Test;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection(){

//        务必导入ojdbc jar包，具体的ojdbc几根据连接的oracle版本确定
//        连oracle11g用ojdbc6.jar,连oracle19c用ojdbc8.jar
//        加载Oracle驱动
        String className = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        第二步：通过驱动管理器得到连接
        String url = "jdbc:oracle:thin:@192.168.1.31:1521:orcl";
        String user = "one";
        String pwd = "123";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /*关闭连接的对象*/
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
