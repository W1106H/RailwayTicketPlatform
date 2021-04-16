package cn.lanqiao.entity.Peoples;

import java.sql.Time;
import java.util.Date;

public class Orders {
    String order_No;
    String pid;
    String train_No;
    Date train_Start_Date;
    Date train_End_Date;
    String station_Start_No;
    String station_End_NO;
    String carriage_No;
    String seat_No;
    String seat_Type;   //这个属性在数据库表中是不存在的……座位类型，一等座二等座等
    String order_Creator;
    String order_state;
    Date order_Create_Time;
    double sumPrice;
    String visual;
    String order_Type;  //订单的类型，学生票？成人票？
    Time train_start_Time;
    Time train_end_Time;
    String passengerName;
    Time order_createDetailTime;

    public Orders(String order_No, String pid, String train_No, Date train_Start_Date, Date train_End_Date, String station_Start_No, String station_End_NO, String carriage_No, String seat_No, String seat_Type, String order_state, double sumPrice, String order_Type,Time train_start_Time,Time train_end_Time,String passengerName,Date order_Create_Time,Time order_createDetailTime) {
        this.order_No = order_No;
        this.pid = pid;
        this.train_No = train_No;
        this.train_Start_Date = train_Start_Date;
        this.train_End_Date = train_End_Date;
        this.station_Start_No = station_Start_No;
        this.station_End_NO = station_End_NO;
        this.carriage_No = carriage_No;
        this.seat_No = seat_No;
        this.seat_Type = seat_Type;
        this.order_state = order_state;
        this.sumPrice = sumPrice;
        this.order_Type = order_Type;
        this.train_start_Time = train_start_Time;
        this.train_end_Time = train_end_Time;
        this.passengerName = passengerName;
        this.order_Create_Time = order_Create_Time;
        this.order_createDetailTime = order_createDetailTime;
    }

    public Orders(String order_No, String pid, String train_No, Date train_Start_Date, Date train_End_Date, String station_Start_No, String station_End_NO, String carriage_No, String seat_No, String order_Creator, String order_state, Date order_Create_Time, double sumPrice, String visual, String order_Type) {
        this.order_No = order_No;
        this.pid = pid;
        this.train_No = train_No;
        this.train_Start_Date = train_Start_Date;
        this.train_End_Date = train_End_Date;
        this.station_Start_No = station_Start_No;
        this.station_End_NO = station_End_NO;
        this.carriage_No = carriage_No;
        this.seat_No = seat_No;
        this.order_Creator = order_Creator;
        this.order_state = order_state;
        this.order_Create_Time = order_Create_Time;
        this.sumPrice = sumPrice;
        this.visual = visual;
        this.order_Type = order_Type;
    }



    @Override
    public String toString() {
        return "Orders{" +
                "order_No='" + order_No + '\'' +
                ", pid='" + pid + '\'' +
                ", train_No='" + train_No + '\'' +
                ", train_Start_Date=" + train_Start_Date +
                ", train_End_Date=" + train_End_Date +
                ", station_Start_No='" + station_Start_No + '\'' +
                ", station_End_NO='" + station_End_NO + '\'' +
                ", carriage_No='" + carriage_No + '\'' +
                ", seat_No='" + seat_No + '\'' +
                ", seat_Type='" + seat_Type + '\'' +
                ", order_Creator='" + order_Creator + '\'' +
                ", order_state='" + order_state + '\'' +
                ", order_Create_Time=" + order_Create_Time +
                ", sumPrice=" + sumPrice +
                ", Visual=" + visual +
                ", order_Type='" + order_Type + '\'' +
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

    public Date getTrain_Start_Date() {
        return train_Start_Date;
    }

    public void setTrain_Start_Date(Date train_Start_Date) {
        this.train_Start_Date = train_Start_Date;
    }

    public Date getTrain_End_Date() {
        return train_End_Date;
    }

    public void setTrain_End_Date(Date train_End_Date) {
        this.train_End_Date = train_End_Date;
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

    public String getSeat_Type() {
        return seat_Type;
    }

    public void setSeat_Type(String seat_Type) {
        this.seat_Type = seat_Type;
    }

    public String getOrder_Creator() {
        return order_Creator;
    }

    public void setOrder_Creator(String order_Creator) {
        this.order_Creator = order_Creator;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
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

    public String getVisual() {
        return visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getOrder_Type() {
        return order_Type;
    }

    public void setOrder_Type(String order_Type) {
        this.order_Type = order_Type;
    }

    public Time getTrain_start_Time() {
        return train_start_Time;
    }

    public Time getTrain_end_Time() {
        return train_end_Time;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Time getOrder_createDetailTime() {
        return order_createDetailTime;
    }

    public void setOrder_createDetailTime(Time order_createDetailTime) {
        this.order_createDetailTime = order_createDetailTime;
    }
}
