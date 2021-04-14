package cn.lanqiao.dao;

import cn.lanqiao.entity.Peoples.Orders;

import java.util.Date;

public interface OrderDao {
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage);
    public int getOrderAlreadyPay_Count(String userPID);
    public boolean getOrderAlreadyPay_JudgeFlag();
    public boolean getOrderAlreadyPay_SetVisible(String orderNo);
    public Orders getDetailOrder(String orderNo);
    public Object[][] getTrainPassInfo(String orderNo);
    public int getTrainPassInfo_Count(String orderNo);
    public Date getTrainPassInfo_trainStartDate(String orderNo);
}
