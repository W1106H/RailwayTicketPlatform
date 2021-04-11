package cn.lanqiao.test;

import org.junit.Test;

import java.sql.*;

public class TestClass {
    @Test
    public void getConnection(){
        String className = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@192.168.1.31:1521:orcl";
        String user = "one";
        String pwd = "123";
        Connection conn = null;
//        测试
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }
}

