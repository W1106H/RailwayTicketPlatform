package cn.lanqiao.service.impl;

import cn.lanqiao.dao.TrainInforDao;
import cn.lanqiao.dao.impl.TrainInforDaoimpl;
import cn.lanqiao.entity.TrainInformation.TrainInfo;
import cn.lanqiao.service.TrainInforService;
import org.junit.Test;

public class TrainInforServiceimpl implements TrainInforService {
    private TrainInforDao trainInforDao=null;
    public TrainInforServiceimpl() {
        trainInforDao = new TrainInforDaoimpl();
    }

    @Override
    public Object[][] getAllTrainInfo() {
        Object[][] allTrainInfo = trainInforDao.getAllTrainInfo();
        return allTrainInfo;
    }

    @Override
    public Object[][] getAllTrainParkingInfo() {
        Object[][] allTrainPakingInfo = trainInforDao.getAllTrainPakingInfo();
        return allTrainPakingInfo;
    }

    @Override
    public Object[][] getRemainingTicketsByTrainNum(String trainNum) {
        Object[][] tickts = trainInforDao.serchRemainingticketsByTrainNum(trainNum);
        return tickts;
    }

    @Override
    public TrainInfo getTrainInfoBytrainNum(String trainNum) {
        TrainInfo trainInfo = trainInforDao.serchTrainInfoBytrainNum(trainNum);
        return trainInfo;
    }

    @Override
    public Object[][] getTrainsInfoByStationNameAndtrainType(String startStation, String endStation, String trainTpye) {
        Object[][] trains = trainInforDao.serchTrainInfoByStationNameAndtrainType(startStation, endStation,trainTpye);
        return trains;
    }

    @Override
    public Object[][] getDetailTrainParking(String trainNum, String startStation, String endStation) {
        Object[][] detailTrainParking = trainInforDao.getDetailTrainParking(trainNum, startStation, endStation);
        return detailTrainParking;
    }


}
