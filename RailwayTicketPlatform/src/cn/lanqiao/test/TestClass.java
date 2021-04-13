package cn.lanqiao.test;

import cn.lanqiao.dao.impl.OrderDaoImpl;
import cn.lanqiao.util.JDBCUtil;
import org.junit.Test;

import java.sql.*;
import java.util.Arrays;

public class TestClass {
    @Test
    public void getConnection() {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Order_getObject() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        Object[][] orderAlreadyPay = orderDao.getOrderAlreadyPay("450000200010090022");
        System.out.println(Arrays.toString(orderAlreadyPay));
    }

    @Test
    public void Order_getObjectCount() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int orderAlreadyPay_count = orderDao.getOrderAlreadyPay_Count();
        System.out.println(orderAlreadyPay_count);
    }
}

