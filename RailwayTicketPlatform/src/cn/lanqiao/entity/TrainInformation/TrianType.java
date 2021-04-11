package cn.lanqiao.entity.TrainInformation;

public class TrianType {
    private int typeNum;
    private String trainTypeName;

    public TrianType() {
    }

    public TrianType(int typeNum, String trainTypeName) {
        this.typeNum = typeNum;
        this.trainTypeName = trainTypeName;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }

    public String getTrainTypeName() {
        return trainTypeName;
    }

    public void setTrainTypeName(String trainTypeName) {
        this.trainTypeName = trainTypeName;
    }

    @Override
    public String toString() {
        return "TrainType{" +
                "typeNum=" + typeNum +
                ", trainTypeName='" + trainTypeName + '\'' +
                '}';
    }
}
