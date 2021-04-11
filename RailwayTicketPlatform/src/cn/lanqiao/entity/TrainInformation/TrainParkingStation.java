package cn.lanqiao.entity.TrainInformation;

import java.sql.Date;

public class TrainParkingStation {
    private String stationOrder;
    private String trainNum;
    private String trainName;
    private Date arriveTime;
    private Date startTime;
    private String price;

    public TrainParkingStation(String stationOrder, String trainNum, String trainName, Date arriveTime, Date startTime, String price) {
        this.stationOrder = stationOrder;
        this.trainNum = trainNum;
        this.trainName = trainName;
        this.arriveTime = arriveTime;
        this.startTime = startTime;
        this.price = price;
    }

    public TrainParkingStation() {
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

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ParkingStation{" +
                "stationOrder='" + stationOrder + '\'' +
                ", trainNo='" + trainNum + '\'' +
                ", trainName='" + trainName + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
