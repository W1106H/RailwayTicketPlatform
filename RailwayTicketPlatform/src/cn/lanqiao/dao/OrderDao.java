package cn.lanqiao.dao;

import cn.lanqiao.entity.Peoples.Orders;

public interface OrderDao {
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage);
    public Object[][] getOrderNotPay(String userPID,int currentPage2);
    public int getOrderAlreadyPay_Count(String userPID);
    public int getOrderNotPay_Count(String userPID);
    public boolean getOrderAlreadyPay_JudgeFlag();
    public boolean getOrderNotPay_JudgeFlag();
    public boolean getOrderAlreadyPay_SetVisible(String orderNo);
    public Orders getDetailOrder(String orderNo);
    public Object[][] getHistoricalOrders(String userPID,int currentPage);
    public int getHistoricalOrders_Count(String userPID);
    public boolean getHistoricalOrders_JudgeFlag();
    public Object[][] getOrderNotTravel(String userPID,int currentPage);
    public int getOrderNotTravel_Count(String userPID);
    public java.util.Date getTrainPassInfo_trainStartDate(String orderNo);
    public Object[][] getTrainPassInfo(String orderNo);
    public int getTrainPassInfo_Count(String orderNo);
    public Orders getOrderByOrderNo(String orderNo);
    //public void addOrder(String PID,String train_no,)
    public Object[][] getPersonalTicket(String userPID);
    public int getPersonalTicket_Count(String userPID);
}
