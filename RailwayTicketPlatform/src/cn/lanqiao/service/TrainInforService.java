package cn.lanqiao.service;

import cn.lanqiao.entity.TrainInformation.TrainInfo;

import javax.naming.Name;

public interface TrainInforService {
    public Object[][] getAllTrainInfo();
    public Object[][] getAllTrainParkingInfo();
    public Object[][] getRemainingTicketsByTrainNum(String trainNum);
    public TrainInfo getTrainInfoBytrainNum(String trainNum);
    public Object[][] getTrainsInfoByStationNameAndtrainType(String startStation, String endStation,String trainTpye);
    public Object[][] getDetailTrainParking(String trainNum,String startStation,String endStation);
}

