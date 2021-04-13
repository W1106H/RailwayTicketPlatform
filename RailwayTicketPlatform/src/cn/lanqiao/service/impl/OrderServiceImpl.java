package cn.lanqiao.service.impl;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.dao.impl.OrderDaoImpl;
import cn.lanqiao.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = null;

    public OrderServiceImpl() {
        this.orderDao = new OrderDaoImpl();
    }

    @Override
    public Object[][] getOrderAlreadyPay(String userPID) {
        return orderDao.getOrderAlreadyPay(userPID);
    }

    @Override
    public boolean getOrderAlreadyPay_JudgeFlag() {
        return orderDao.getOrderAlreadyPay_JudgeFlag();
    }

    @Override
    public boolean getOrderAlreadyPay_SetVisible(String orderNo) {
        return orderDao.getOrderAlreadyPay_SetVisible(orderNo);
    }


}
