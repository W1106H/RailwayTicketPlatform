package cn.lanqiao.entity.Peoples;

import java.util.Date;

public class Orders {
    String order_No;
    String pid;
    String train_No;
    Date train_Start_Time;
    Date train_End_Time;
    String station_Start_No;
    String station_End_NO;
    String carriage_No;
    String seat_No;
    String order_Creator;
    char order_state;
    Date order_Create_Time;
    double sumPrice;
    boolean Visual;

    public Orders(String order_No, String pid, String train_No, Date train_Start_Time, Date train_End_Time, String station_Start_No, String station_End_NO, String carriage_No, String seat_No, String order_Creator, char order_state, Date order_Create_Time, double sumPrice, boolean visual) {
        this.order_No = order_No;
        this.pid = pid;
        this.train_No = train_No;
        this.train_Start_Time = train_Start_Time;
        this.train_End_Time = train_End_Time;
        this.station_Start_No = station_Start_No;
        this.station_End_NO = station_End_NO;
        this.carriage_No = carriage_No;
        this.seat_No = seat_No;
        this.order_Creator = order_Creator;
        this.order_state = order_state;
        this.order_Create_Time = order_Create_Time;
        this.sumPrice = sumPrice;
        Visual = visual;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_No='" + order_No + '\'' +
                ", pid='" + pid + '\'' +
                ", train_No='" + train_No + '\'' +
                ", train_Start_Time=" + train_Start_Time +
                ", train_End_Time=" + train_End_Time +
                ", station_Start_No='" + station_Start_No + '\'' +
                ", station_End_NO='" + station_End_NO + '\'' +
                ", carriage_No='" + carriage_No + '\'' +
                ", seat_No='" + seat_No + '\'' +
                ", order_Creator='" + order_Creator + '\'' +
                ", order_state=" + order_state +
                ", order_Create_Time=" + order_Create_Time +
                ", sumPrice=" + sumPrice +
                ", Visual=" + Visual +
                '}';
    }

    public String getOrder_No() {
        return order_No;
    }

    public void setOrder_No(String order_No) {
        this.order_No = order_No;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTrain_No() {
        return train_No;
    }

    public void setTrain_No(String train_No) {
        this.train_No = train_No;
    }

    public Date getTrain_Start_Time() {
        return train_Start_Time;
    }

    public void setTrain_Start_Time(Date train_Start_Time) {
        this.train_Start_Time = train_Start_Time;
    }

    public Date getTrain_End_Time() {
        return train_End_Time;
    }

    public void setTrain_End_Time(Date train_End_Time) {
        this.train_End_Time = train_End_Time;
    }

    public String getStation_Start_No() {
        return station_Start_No;
    }

    public void setStation_Start_No(String station_Start_No) {
        this.station_Start_No = station_Start_No;
    }

    public String getStation_End_NO() {
        return station_End_NO;
    }

    public void setStation_End_NO(String station_End_NO) {
        this.station_End_NO = station_End_NO;
    }

    public String getCarriage_No() {
        return carriage_No;
    }

    public void setCarriage_No(String carriage_No) {
        this.carriage_No = carriage_No;
    }

    public String getSeat_No() {
        return seat_No;
    }

    public void setSeat_No(String seat_No) {
        this.seat_No = seat_No;
    }

    public String getOrder_Creator() {
        return order_Creator;
    }

    public void setOrder_Creator(String order_Creator) {
        this.order_Creator = order_Creator;
    }

    public char getOrder_state() {
        return order_state;
    }

    public void setOrder_state(char order_state) {
        this.order_state = order_state;
    }

    public Date getOrder_Create_Time() {
        return order_Create_Time;
    }

    public void setOrder_Create_Time(Date order_Create_Time) {
        this.order_Create_Time = order_Create_Time;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public boolean isVisual() {
        return Visual;
    }

    public void setVisual(boolean visual) {
        Visual = visual;
    }
}
