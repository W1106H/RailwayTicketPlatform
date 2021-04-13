package cn.lanqiao.dao;

import cn.lanqiao.entity.Peoples.Passenger;
import cn.lanqiao.entity.Peoples.User;

/**
 * @author moqirun
 * @date 2021/4/12 18:28
 **/
public interface PassengerDao {
    public Passenger getPassenger(String passengerid);

    public int addPassenger(Passenger passenger);

    public int deletePassenger(String passengerid);

    public int updatePassenger(String ptel, String passengerid);
}
