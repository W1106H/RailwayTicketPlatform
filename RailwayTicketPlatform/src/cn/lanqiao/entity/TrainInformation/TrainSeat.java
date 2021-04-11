package cn.lanqiao.entity.TrainInformation;

public class TrainSeat {
    private String trainNum;
    private String carriageNum;//车厢号
    private String seatType;
    private int seatCount;

    public TrainSeat() {

    }

    public TrainSeat(String trainNum, String carriageNum, String seatType, int seatCount) {
        this.trainNum = trainNum;
        this.carriageNum = carriageNum;
        this.seatType = seatType;
        this.seatCount = seatCount;
    }

    public String getTrainNo() {
        return trainNum;
    }

    public void setTrainNo(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getCarriageNum() {
        return carriageNum;
    }

    public void setCarriageNo(String carriageNum) {
        this.carriageNum = carriageNum;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "trainNo='" + trainNum + '\'' +
                ", carriageNo='" + carriageNum + '\'' +
                ", seatType='" + seatType + '\'' +
                ", seatCount='" + seatCount + '\'' +
                '}';
    }
}
