package cn.lanqiao.entity.Peoples;

/**
 * @author moqirun
 * @date 2021/4/12 17:40
 **/
public class Passenger {
    private String PassengerId;
    private String PName;
    private String PTel;
    private String PId;
    private String PGender;


    public Passenger(String passengerId, String PName, String PTel, String PId,String PGender) {
        PassengerId = passengerId;
        this.PName = PName;
        this.PTel = PTel;
        this.PId = PId;
        this.PGender = PGender;
    }

    public String getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(String passengerId) {
        PassengerId = passengerId;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPTel() {
        return PTel;
    }

    public void setPTel(String PTel) {
        this.PTel = PTel;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public String getPGender() {
        return PGender;
    }

    public void setPGender(String PGender) {
        this.PGender = PGender;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "PassengerId='" + PassengerId + '\'' +
                ", PName='" + PName + '\'' +
                ", PTel='" + PTel + '\'' +
                ", PId='" + PId + '\'' +
                ", PGender='" + PGender + '\'' +
                '}';
    }
}
