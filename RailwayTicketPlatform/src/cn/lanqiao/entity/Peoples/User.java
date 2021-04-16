package cn.lanqiao.entity.Peoples;

import java.io.Serializable;

/**
 * @author moqirun
 * @date 2021/4/12 17:34
 **/
public class User implements Serializable  {
    private static final long serialVersionUID = -6306566448717931119L;
    private String UTel;
    private String UserId;
    private String URealName;
    private String UGender;
    private String UEmail;
    private String UAddress;
    private String UName;
    private String UPassword;
    private String PId;

    public User(String UTel, String userId, String URealName, String UGender,String UEmail, String UAddress, String UName, String UPassword, String PId) {
        this.UTel = UTel;
        UserId = userId;
        this.URealName = URealName;
        this.UGender = UGender;
        this.UEmail = UEmail;
        this.UAddress = UAddress;
        this.UName = UName;
        this.UPassword = UPassword;
        this.PId = PId;
    }


    public String getUTel() {
        return UTel;
    }

    public void setUTel(String UTel) {
        this.UTel = UTel;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UId) {
        this.UserId = UId;
    }

    public String getURealName() {
        return URealName;
    }

    public void setURealName(String URealName) {
        this.URealName = URealName;
    }

    public String getUEmail() {
        return UEmail;
    }

    public void setUEmail(String UEmail) {
        this.UEmail = UEmail;
    }

    public String getUAddress() {
        return UAddress;
    }

    public void setUAddress(String UAddress) {
        this.UAddress = UAddress;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public String getUGender() {
        return UGender;
    }

    public void setUGender(String UGender) {
        this.UGender = UGender;
    }

    @Override
    public String toString() {
        return "User{" +
                "UTel='" + UTel + '\'' +
                ", UserId='" + UserId + '\'' +
                ", URealName='" + URealName + '\'' +
                ", UGender='" + UGender + '\'' +
                ", UEmail='" + UEmail + '\'' +
                ", UAddress='" + UAddress + '\'' +
                ", UName='" + UName + '\'' +
                ", UPassword='" + UPassword + '\'' +
                ", PId='" + PId + '\'' +
                '}';
    }
}
