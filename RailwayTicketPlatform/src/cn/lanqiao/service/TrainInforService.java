package cn.lanqiao.service;

import cn.lanqiao.entity.TrainInformation.TrainInfo;

import javax.naming.Name;
import java.util.Objects;

public interface TrainInforService {
    public Object[][] getAllTrainInfo();
    public Object[][] getAllTrainParkingInfo();
    public Object[][] getRemainingTicketsByTrainNum(String trainNum);
    public Object[][] getTrainInfoBytrainNum(String trainNum);
    public Object[][] getTrainsInfoByStationNameAndtrainType(String startStation, String endStation,String trainTpye);
    public Object[][] getDetailTrainParking(String trainNum,String startStation,String endStation);
    public Object[][] UserBuyBuyTickets( String orders_creator, String trainNum,String startStation, String endStation);
    public void refundTicket(String trainNum, String startStationNum, String endStationNum);
    public void  updataTicket(String trainNum, String startStationNum, String endStationNum);
    public Object[][] getTransferInfor(String sartStation, String endStation,boolean decSortYesOrNo);
}

