package cn.lanqiao.service;

import cn.lanqiao.entity.Peoples.Passenger;
import cn.lanqiao.entity.Peoples.User;

/**
 * @author moqirun
 * @date 2021/4/15 14:46
 **/
public interface PassengerService {
    public Passenger getPassenger(String passengerId);
    public Object[][] getAllPassenger(User user);
    public int[] addPassenger(Passenger passenger);
    public int deletePassenger(String passengerId);
    public int updatePTel(String ptel,String passengerId);
}
