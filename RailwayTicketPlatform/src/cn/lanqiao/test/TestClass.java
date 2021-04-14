package cn.lanqiao.test;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.dao.impl.OrderDaoImpl;
import cn.lanqiao.entity.Peoples.Orders;
import cn.lanqiao.util.JDBCUtil;
import org.junit.Test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

    @Test
    public void getTrainPassInfo_Count(){
        OrderDao orderDao = new OrderDaoImpl();
        int trainPassInfo_count = orderDao.getTrainPassInfo_Count("5");
        System.out.println(trainPassInfo_count);
    }

    @Test
    public void getTrainPassInfo(){
        OrderDao orderDao = new OrderDaoImpl();
        Object[][] trainPassInfo = orderDao.getTrainPassInfo("5");
        for(int i = 0;i < trainPassInfo.length;i++){
            for (Object o : trainPassInfo[i]) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void getTrainPassInfo_trainStartDate(){
        OrderDao orderDao = new OrderDaoImpl();
        Date trainPassInfo_trainStartDate = orderDao.getTrainPassInfo_trainStartDate("5");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(trainPassInfo_trainStartDate);
        System.out.println(format);
    }
}

