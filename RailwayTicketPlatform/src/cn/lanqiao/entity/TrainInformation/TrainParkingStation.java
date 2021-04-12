package cn.lanqiao.entity.TrainInformation;

import java.util.Date;

public class TrainParkingStation {
    private String stationOrder;
    private String stationName;
    private String trainNum;
    private Date arriveTime;
    private Date startTime;
    private int price;


    public TrainParkingStation(String stationName, String stationOrder, String trainNum,  Date arriveTime, Date startTime, int price) {
        this.stationOrder = stationOrder;
        this.trainNum = trainNum;
        this.arriveTime = arriveTime;
        this.startTime = startTime;
        this.price = price;
        this.stationName=stationName;
    }

    public TrainParkingStation() {
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getStationOrder() {
        return stationOrder;
    }

    public void setStationOrder(String stationOrder) {
        this.stationOrder = stationOrder;
    }

    public String getTrainNo() {
        return trainNum;
    }

    public void setTrainNo(String trainNum) {
        this.trainNum = trainNum;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TrainParkingStation{" +
                "stationOrder='" + stationOrder + '\'' +
                ", stationName='" + stationName + '\'' +
                ", trainNum='" + trainNum + '\'' +
                ", arriveTime=" + arriveTime +
                ", startTime=" + startTime +
                ", price='" + price + '\'' +
                '}';
    }
}
