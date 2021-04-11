package cn.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public Connection getConnection(){

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
}
