package cn.lanqiao.dao;

public interface OrderDao {
    public Object[][] getOrderAlreadyPay(String userPID);
    public int getOrderAlreadyPay_Count();
    public boolean getOrderAlreadyPay_JudgeFlag();
    public boolean getOrderAlreadyPay_SetVisible(String orderNo);
}
