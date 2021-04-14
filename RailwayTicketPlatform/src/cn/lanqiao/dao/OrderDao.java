package cn.lanqiao.dao;

import cn.lanqiao.entity.Peoples.Orders;

public interface OrderDao {
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage);
    public int getOrderAlreadyPay_Count(String userPID);
    public boolean getOrderAlreadyPay_JudgeFlag();
    public boolean getOrderAlreadyPay_SetVisible(String orderNo);
    public Orders getDetailOrder(String orderNo);
}
