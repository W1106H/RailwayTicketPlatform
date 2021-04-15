package cn.lanqiao.service.impl;

import cn.lanqiao.dao.TrainInforDao;
import cn.lanqiao.dao.impl.TrainInforDaoimpl;
import cn.lanqiao.entity.TrainInformation.TrainInfo;
import cn.lanqiao.service.TrainInforService;
import org.junit.Test;

public class TrainInforServiceimpl implements TrainInforService {

    public Object[][] getTransferInfor(String startStation, String endStation,boolean decSortYesOrNo){
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        Object[][] transferInfor =null;
        if(decSortYesOrNo){
            trainInforDao.getTransferInfor(startStation, endStation,true);

        }else{
            transferInfor = trainInforDao.getTransferInfor(startStation, endStation,false);
        }
        return transferInfor;
    }

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
    public Object[][] getTrainInfoBytrainNum(String trainNum) {
        Object[][] train = trainInforDao.serchTrainInfoBytrainNum(trainNum);
        return train;
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

    @Override
    public Object[][] UserBuyBuyTickets(String PID, String orders_creator, String trainNum, String startStation, String endStation) {
        Object[][] order = trainInforDao.TicketsOrder(PID, orders_creator, trainNum, startStation, endStation);
        return order;
    }

    @Override
    public void refundTicket(String trainNum, String startStationNum, String endStationNum) {
        trainInforDao.refundTicket(trainNum, startStationNum, endStationNum);
    }

    @Override
    public void updataTicket(String trainNum, String startStationNum, String endStationNum) {
        trainInforDao.updataTicket(trainNum, startStationNum, endStationNum);
    }


}
