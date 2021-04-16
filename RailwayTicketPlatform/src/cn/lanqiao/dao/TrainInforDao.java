package cn.lanqiao.dao;

import cn.lanqiao.entity.TrainInformation.TrainInfo;

import java.util.List;
import java.util.Objects;

public interface TrainInforDao {
    public Object[][] getAllTrainInfo();
    public Object[][] getAllTrainPakingInfo();
    public Object[][] serchTrainInfoBytrainNum(String trainNum);
    public Object[][] serchTrainInfoByStationNameAndtrainType(String startStation, String endStation,String trainType);
    public Object[][] serchRemainingticketsByTrainNum(String trainNum);
    public int TraincountByStationNameAndtrainType(String startStation, String endStationg,String trainType);
    public int Traincount();
    public int Parkingcount();
    public Object[][] getDetailTrainParking(String trainNum,String startStation,String endStation);
    public int getTrainPakingNum(String trainNum, String startStation, String endStation);
    public Object[][] TicketsOrder( String orders_creator, String trainNum,String startStation, String endStation);
    public void refundTicket(String orderNo,String trainNum, String startStationNum, String endStationNum);
    public void updataTicket(String trainNum, String startStationNum, String endStationNum);
    public Object[][] getTransferInfor(String startStation, String endStation,boolean decSortYesOrNo);
    public int getTransferTotalPrice(int startStationOrder1, int endStationOrder1,int startStationOrder2,int endStationOrder2);
}

