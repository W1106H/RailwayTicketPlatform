package cn.lanqiao.dao;

import cn.lanqiao.entity.TrainInformation.TrainInfo;

public interface TrainInforDao {
    public Object[][] getAllTrainInfo();
    public int Traincount();
    public int Parkingcount();
    public Object[][] getAllTrainPakingInfo();
    public TrainInfo serchTrainInfoBytrainNum(String trainNum);
    public Object[][] serchTrainInfoByStationName(String startStation, String endStation);
    public int TraincountByStationName(String startStation, String endStationg);
    public Object[][] serchRemainingticketsByTrainNum(String trainNum);

}
