package cn.lanqiao.dao;

import cn.lanqiao.entity.TrainInformation.TrainInfo;

import java.util.Objects;

public interface TrainInforDao {
    public Object[][] getAllTrainInfo();
    public Object[][] getAllTrainPakingInfo();
    public TrainInfo serchTrainInfoBytrainNum(String trainNum);
    public Object[][] serchTrainInfoByStationNameAndtrainType(String startStation, String endStation,String trainType);
    public Object[][] serchRemainingticketsByTrainNum(String trainNum);
    public int TraincountByStationNameAndtrainType(String startStation, String endStationg,String trainType);
    public int Traincount();
    public int Parkingcount();
    public Object[][] getDetailTrainParking(String trainNum,String startStation,String endStation);
    public int getTrainPakingNum(String trainNum, String startStation, String endStation);


}
