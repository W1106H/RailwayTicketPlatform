package cn.lanqiao.entity.TrainInformation;

import java.util.Date;

public class TrainInfo {
    private String trainNum;
    private String trainTypeName;
    private Date trainStartTime;
    private String trainStartStation;
    private Date trainEndTime;
    private String trainEndStation;
    private String trainRunTime;
    private int trainCarriages;
    private int trainPrice;
    private String trainRunType;

    public TrainInfo(String trainNum, String trainTypeName, Date trainStartTime, String trainStartStation, Date trainEndTime, String trainEndStation, String trainRunTime, int trainCarriages, int trainPrice, String trainRunType) {
        this.trainNum = trainNum;
        this.trainTypeName = trainTypeName;
        this.trainStartTime = trainStartTime;
        this.trainStartStation = trainStartStation;
        this.trainEndTime = trainEndTime;
        this.trainEndStation = trainEndStation;
        this.trainRunTime = trainRunTime;
        this.trainCarriages = trainCarriages;
        this.trainPrice = trainPrice;
        this.trainRunType = trainRunType;
    }

    public TrainInfo(String trainNum, String trainTypeName, Date trainStartTime, String trainStartStation, Date trainEndTime, String trainEndStation, String trainRunTime, int trainCarriages, int trainPrice) {
        this.trainNum = trainNum;
        this.trainTypeName = trainTypeName;
        this.trainStartTime = trainStartTime;
        this.trainStartStation = trainStartStation;
        this.trainEndTime = trainEndTime;
        this.trainEndStation = trainEndStation;
        this.trainRunTime = trainRunTime;
        this.trainCarriages = trainCarriages;
        this.trainPrice=trainPrice;
    }

    public TrainInfo() {
    }

    public int getTrainPrice() {
        return trainPrice;
    }

    public void setTrainPrice(int trainPrice) {
        this.trainPrice = trainPrice;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getTrainTypeName() {
        return trainTypeName;
    }

    public void setTrainTypeName(String trainTypeName) {
        this.trainTypeName = trainTypeName;
    }

    public Date getTrainStartTime() {
        return trainStartTime;
    }

    public void setTrainStartTime(Date trainStartTime) {
        this.trainStartTime = trainStartTime;
    }

    public String getTrainStartStation() {
        return trainStartStation;
    }

    public void setTrainStartStation(String trainStartStation) {
        this.trainStartStation = trainStartStation;
    }

    public Date getTrainEndTime() {
        return trainEndTime;
    }

    public void setTrainEndTime(Date trainEndTime) {
        this.trainEndTime = trainEndTime;
    }

    public String getTrainEndStation() {
        return trainEndStation;
    }

    public void setTrainEndStation(String trainEndStation) {
        this.trainEndStation = trainEndStation;
    }

    public String getTrainRunTime() {
        return trainRunTime;
    }

    public void setTrainRunTime(String trainRunTime) {
        this.trainRunTime = trainRunTime;
    }

    public int getTrainCarriages() {
        return trainCarriages;
    }

    public void setTrainCarriages(int trainCarriages) {
        this.trainCarriages = trainCarriages;
    }

    @Override
    public String toString() {
        return "TrainInfo{" +
                "trainNum='" + trainNum + '\'' +
                ", trainTypeName='" + trainTypeName + '\'' +
                ", trainStartTime=" + trainStartTime +
                ", trainStartStation='" + trainStartStation + '\'' +
                ", trainEndTime=" + trainEndTime +
                ", trainEndStation='" + trainEndStation + '\'' +
                ", trainRunTime='" + trainRunTime + '\'' +
                ", trainCarriages=" + trainCarriages +
                ", trainPrice=" + trainPrice +
                '}';
    }
}
