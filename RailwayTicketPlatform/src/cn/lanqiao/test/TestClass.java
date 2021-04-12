package cn.lanqiao.test;

import cn.lanqiao.dao.TrainInforDao;
import cn.lanqiao.dao.impl.TrainInforDaoimpl;
import cn.lanqiao.entity.TrainInformation.TrainInfo;
import cn.lanqiao.util.StringForData;
import org.junit.Test;


import java.sql.*;

public class TestClass {
    @Test
    public void getConnection(){
        String className = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@192.168.1.31:1521:orcl";
        String user = "one";
        String pwd = "123";
        Connection conn = null;
//        测试
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }

    @Test
    public void testTrainCount() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        System.out.println(trainInforDao.Traincount());
    }

    @Test
    public void testGetAllTrainInfo() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        Object[][] allTrainInfo = trainInforDao.getAllTrainInfo();
        for (int i = 0; i < trainInforDao.Traincount(); i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(allTrainInfo[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testParkingcount() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        System.out.println(trainInforDao.Parkingcount());
    }

    @Test
    public void testgetAllTrainPakingInfo() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        Object[][] allTrainInfo = trainInforDao.getAllTrainPakingInfo();
        for (int i = 0; i < trainInforDao.Parkingcount(); i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(allTrainInfo[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testSerchTrainInfo() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        TrainInfo trainInfo = trainInforDao.serchTrainInfoBytrainNum("D8481");
        System.out.println(trainInfo);
    }

    @Test
    //通过“HH：MM”得到目前DATA
    public void testStringForData() {
        StringForData stringForData = new StringForData();
        System.out.println(stringForData.slip("12:20"));


    }

    @Test
    public void testTraincountByStationName() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        System.out.println(trainInforDao.TraincountByStationName("桂林北站","百色站"));
    }

    @Test
    public void testserchTrainInfoByStationName() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        Object[][] allTrainInfo = trainInforDao.serchTrainInfoByStationName("桂林北站", "百色站");
        int s = trainInforDao.TraincountByStationName("桂林北站", "百色站");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(allTrainInfo[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testserchRemainingticketsByTrainNum() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        Object[][] seats = trainInforDao.serchRemainingticketsByTrainNum("D8461");
        int s = ((TrainInforDaoimpl) trainInforDao).getCarriage("D8461");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(seats[i][j]+" ");
            }
            System.out.println();
        }
    }

}

