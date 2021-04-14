package cn.lanqiao.service.impl;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.dao.impl.OrderDaoImpl;
import cn.lanqiao.entity.Peoples.Orders;
import cn.lanqiao.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = null;

    public OrderServiceImpl() {
        this.orderDao = new OrderDaoImpl();
    }

    @Override
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage) {
        return orderDao.getOrderAlreadyPay(userPID,currentPage);
    }

    @Override
    public boolean getOrderAlreadyPay_JudgeFlag() {
        return orderDao.getOrderAlreadyPay_JudgeFlag();
    }

    @Override
    public boolean getOrderAlreadyPay_SetVisible(String orderNo) {
        return orderDao.getOrderAlreadyPay_SetVisible(orderNo);
    }

    @Override
    public int getOrderAlreadyPay_Count(String userPID) {
        return orderDao.getOrderAlreadyPay_Count(userPID);
    }

    @Override
    public Object[][] getTrainPassInfo(String orderNo) {
        return orderDao.getTrainPassInfo(orderNo);
    }

    @Override
    public Orders getDetailOrder(String orderNo) {
        return orderDao.getDetailOrder(orderNo);
    }

    @Override
    public String getTrainPassInfo_trainStartDate(String orderNo) {
        Date tsd = orderDao.getTrainPassInfo_trainStartDate(orderNo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(tsd);
        return dateString;
    }
}
