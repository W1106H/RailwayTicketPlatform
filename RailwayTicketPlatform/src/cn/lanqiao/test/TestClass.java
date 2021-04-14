package cn.lanqiao.test;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.dao.impl.OrderDaoImpl;
import cn.lanqiao.entity.Peoples.Orders;
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

    /*@Test
    public void Order_getObject() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        Object[][] orderAlreadyPay = orderDao.getOrderAlreadyPay("1001");
        System.out.println(Arrays.toString(orderAlreadyPay));
    }*/

    @Test
    public void Order_getObjectCount() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int orderAlreadyPay_count = orderDao.getOrderAlreadyPay_Count("1001");
        System.out.println(orderAlreadyPay_count);
    }

    @Test
    public void Order_testGetOrder(){
        OrderDao orderDao = new OrderDaoImpl();
        Orders detailOrder = orderDao.getDetailOrder("5");
        System.out.println(detailOrder.toString());
    }
}

