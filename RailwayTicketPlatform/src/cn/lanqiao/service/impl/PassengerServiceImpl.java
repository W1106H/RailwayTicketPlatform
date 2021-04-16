package cn.lanqiao.service.impl;

import cn.lanqiao.dao.PassengerDao;
import cn.lanqiao.dao.impl.PassengerDaoImpl;
import cn.lanqiao.entity.Peoples.Passenger;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.PassengerService;
import cn.lanqiao.util.EmailMatches;
import cn.lanqiao.util.IdMatches;
import cn.lanqiao.util.TelMathches;

/**
 * @author moqirun
 * @date 2021/4/15 14:51
 **/
public class PassengerServiceImpl implements PassengerService {
    private PassengerDao passengerDao = null;

    public PassengerServiceImpl() {
        passengerDao = new PassengerDaoImpl();
    }

    @Override
    public Passenger getPassenger(String passengerId) {

        Passenger passenger = passengerDao.getPassenger(passengerId);
        if(passenger!=null){
            return  passenger;
        }
        return null;
    }

    @Override
    public Object[][] getAllPassenger(User user) {
        return passengerDao.list(user);
    }

    @Override
    public int[] addPassenger(Passenger passenger) {
        int[] result = new int[5];
        boolean passengerIdMatches = IdMatches.judgeLegal(passenger.getPassengerId());
        boolean pTelMatches = TelMathches.judgeLegal(passenger.getPTel());
        if (passengerIdMatches&& pTelMatches) {
            Passenger isFindPassengerId = passengerDao.getPassenger(passenger.getPassengerId());
            Passenger isFindPTel = passengerDao.getPassenger(passenger.getPTel());
            if (isFindPassengerId!=null) {
                result[3] = 1;
            }
            if (isFindPTel!=null) {
                result[4] = 1;
            }
            result[2] = passengerDao.addPassenger(passenger);
        } else {
            if (!passengerIdMatches) {
                result[0] = 1;
            }
            if (pTelMatches) {
                result[1] = 1;
            }
        }
        return result;
    }

    @Override
    public int deletePassenger(String passengerId) {
        return passengerDao.deletePassenger(passengerId);
    }

    @Override
    public int updatePTel(String ptel,String passengerId) {
        return passengerDao.updatePassenger(ptel,passengerId);
    }

}
