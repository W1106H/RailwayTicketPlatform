package cn.lanqiao.dao;

public interface OrderDao {
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage);
    public int getOrderAlreadyPay_Count(String userPID);
    public boolean getOrderAlreadyPay_JudgeFlag();
    public boolean getOrderAlreadyPay_SetVisible(String orderNo);
}
