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
    public Object[][] getOrderNotPay(String userPID, int currentPage2) {
        return orderDao.getOrderNotPay(userPID,currentPage2);
    }

    @Override
    public boolean getOrderAlreadyPay_JudgeFlag() {
        return orderDao.getOrderAlreadyPay_JudgeFlag();
    }

    @Override
    public boolean getOrderNotPay_JudgeFlag() {
        return orderDao.getOrderNotPay_JudgeFlag();
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
    public Orders getOrderByOrderNo(String orderNo) {
        return orderDao.getOrderByOrderNo(orderNo);
    }

    @Override
    public String getTrainPassInfo_trainStartDate(String orderNo) {
        Date tsd = orderDao.getTrainPassInfo_trainStartDate(orderNo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(tsd);
        return dateString;
    }

    @Override
    public Orders getDetailOrder(String orderNo) {
        return orderDao.getDetailOrder(orderNo);
    }

    @Override
    public int getOrderNotPay_Count(String userPID) {
        return orderDao.getOrderNotPay_Count(userPID);
    }

    @Override
    public Object[][] getHistoricalOrders(String userPID,int currentPage) {
        return orderDao.getHistoricalOrders(userPID,currentPage);
    }

    @Override
    public int getHistoricalOrders_Count(String userPID) {
        return orderDao.getHistoricalOrders_Count(userPID);
    }

    @Override
    public boolean getHistoricalOrders_JudgeFlag() {
        return orderDao.getHistoricalOrders_JudgeFlag();
    }

    @Override
    public Object[][] getOrderNotTravel(String userPID, int currentPage) {
        return orderDao.getOrderNotTravel(userPID,currentPage);
    }

    @Override
    public int getOrderNotTravel_Count(String userPID) {
        return orderDao.getOrderNotTravel_Count(userPID);
    }

    @Override
    public Object[][] getPersonalTicket(String userPID) {
        return orderDao.getPersonalTicket(userPID);
    }

    @Override
    public boolean addOrder(String PID, String train_no, String start_station_no, String arrive_station_no, Date startTime, Date arriveTime, String order_creator, double sumprice, int orderType) {
        int flag = orderDao.addOrder(PID,train_no,start_station_no,arrive_station_no,startTime,arriveTime,order_creator,sumprice,orderType);
        if(flag > 0) return true;
        else return false;
    }
}
