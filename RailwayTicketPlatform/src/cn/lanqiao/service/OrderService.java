package cn.lanqiao.service;

import cn.lanqiao.entity.Peoples.Orders;

public interface OrderService {
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage);
    public Object[][] getOrderNotPay(String userPID,int currentPage2);
    public boolean getOrderAlreadyPay_JudgeFlag();
    public boolean getOrderNotPay_JudgeFlag();
    public boolean getOrderAlreadyPay_SetVisible(String orderNo);
    public Orders getDetailOrder(String orderNo);
    public int getOrderAlreadyPay_Count(String userPID);
    public int getOrderNotPay_Count(String userPID);
    public Object[][] getHistoricalOrders(String userPID,int currentPage);
    public int getHistoricalOrders_Count(String userPID);
    public boolean getHistoricalOrders_JudgeFlag();
    public Object[][] getOrderNotTravel(String userPID,int currentPage);
    public int getOrderNotTravel_Count(String userPID);
    public String getTrainPassInfo_trainStartDate(String userPID);
    public Object[][] getTrainPassInfo(String orderNo);
    public Orders getOrderByOrderNo(String orderNo);
}
