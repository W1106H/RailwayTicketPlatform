package cn.lanqiao.service;

public interface OrderService {
    public Object[][] getOrderAlreadyPay(String userPID);
    public boolean getOrderAlreadyPay_JudgeFlag();
    public boolean getOrderAlreadyPay_SetVisible(String orderNo);
}
