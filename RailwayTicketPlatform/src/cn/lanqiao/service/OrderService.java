package cn.lanqiao.service;

import cn.lanqiao.entity.Peoples.Orders;

public interface OrderService {
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage);
    public boolean getOrderAlreadyPay_JudgeFlag();
    public boolean getOrderAlreadyPay_SetVisible(String orderNo);
    public Orders getDetailOrder(String orderNo);
    public int getOrderAlreadyPay_Count(String userPID);
}
