package cn.lanqiao.test;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.dao.PassengerDao;
import cn.lanqiao.dao.TrainInforDao;
import cn.lanqiao.dao.impl.OrderDaoImpl;
import cn.lanqiao.dao.impl.PassengerDaoImpl;
import cn.lanqiao.dao.impl.TrainInforDaoimpl;
import cn.lanqiao.entity.TrainInformation.TrainInfo;
import cn.lanqiao.entity.Peoples.Orders;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.OrderService;
import cn.lanqiao.util.JDBCUtil;
import cn.lanqiao.util.StringForData;
import org.junit.Test;

import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class TestClass {
    @Test
    public void getConnection() {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*@Test
    public void Order_getObject() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        Object[][] orderAlreadyPay = orderDao.getOrderAlreadyPay("1001");
        System.out.println(Arrays.toString(orderAlreadyPay));
    }*/

    @Test
    public void Order_getObjectCount() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int orderAlreadyPay_count = orderDao.getOrderAlreadyPay_Count("1001");
        System.out.println(orderAlreadyPay_count);
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
       Object[][] train = trainInforDao.serchTrainInfoBytrainNum("D8481");
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(train[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    //通过“HH：MM”得到目前DATA
    public void testStringForData() {
        StringForData stringForData = new StringForData();
        System.out.println(stringForData.slip("12:20"));


    }

    @Test
    public void testTraincountByStationNameAndtrainType() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        System.out.println(trainInforDao.TraincountByStationNameAndtrainType("桂林北站","柳州站","动车"));
    }

    @Test
    public void testserchTrainInfoByStationNameAndtrainType() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        Object[][] allTrainInfo = trainInforDao.serchTrainInfoByStationNameAndtrainType("桂林北站", "柳州站","动车");
        int s = trainInforDao.TraincountByStationNameAndtrainType("桂林北站", "柳州站","动车");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < 9; j++) {
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

    @Test
    public void testgetTrainPakingNum() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        System.out.println(trainInforDao.getTrainPakingNum("D8481", "桂林站", "来宾北站"));
    }

    @Test
    public void testgetDetailTrainParking() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        Object[][] allTrainInfo = trainInforDao.getDetailTrainParking("D8481", "桂林站", "来宾北站");

        for (int i = 0; i < trainInforDao.getTrainPakingNum("D8481", "桂林站", "来宾北站"); i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(allTrainInfo[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testTicketsOrder() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        Object[][] objects = trainInforDao.TicketsOrder("123", "D8481", "桂林北站", "柳州站");
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(objects[i][j]+" ");
            }
            System.out.println();
        }

    }

    @Test
    public void Order_testGetOrder(){
        OrderDao orderDao = new OrderDaoImpl();
        Orders detailOrder = orderDao.getDetailOrder("5");
        System.out.println(detailOrder.toString());
    }

    @Test
    public void test1() {
        PassengerDao passengerDao = new PassengerDaoImpl();
        Object[][] list = passengerDao.list(new User("18977330764", "450923199804165416", "莫启润", "男", "3034267233@qq.com", "广西玉林", "moqirun", "123", "f6c0e7da-a409-467d-a2c1-58d5e316a895"));
        for (Object[] objects : list) {
            System.out.println(objects);
        }
    }

    @Test
    public void testdelet() {
        String fileName = "user.data";
        String fileName1 = "D:\\gitproject\\RailwayTicketPlatform\\userWithAut.data";
        //修改
               /* if (AutcheckBox.isSelected()) {
                    fileName = "userWithAut.data";
                } */
        File file = new File(fileName);
        File file1=new File(fileName1);
        if(file.exists()){
            boolean isdelete = file.delete();
            System.out.println(isdelete);
        } else if (file1.exists()) {
            boolean isdelete = file1.delete();
            System.out.println(isdelete);
        }
    }

    @Test
    public void getTrainPassInfo_Count(){
        OrderDao orderDao = new OrderDaoImpl();
        int trainPassInfo_count = orderDao.getTrainPassInfo_Count("5");
        System.out.println(trainPassInfo_count);
    }

    @Test
    public void getTrainPassInfo(){
        OrderDao orderDao = new OrderDaoImpl();
        Object[][] trainPassInfo = orderDao.getTrainPassInfo("5");
        for(int i = 0;i < trainPassInfo.length;i++){
            for (Object o : trainPassInfo[i]) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }

    /*  @Test
      public void getTrainPassInfo_trainStartDate(){
          OrderDao orderDao = new OrderDaoImpl();
          Date trainPassInfo_trainStartDate = orderDao.getTrainPassInfo_trainStartDate("5");
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String format = sdf.format(trainPassInfo_trainStartDate);
          System.out.println(format);
      }*/
    @Test
    public void testgetTransferInfor() {
        TrainInforDao trainInforDao=new TrainInforDaoimpl();
        Object[][] transferInfor = trainInforDao.getTransferInfor("桂林站", "南宁站", false);
        for (int i = 0; i < transferInfor.length-1; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(transferInfor[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testOrderAdd(){
        OrderDao orderDao = new OrderDaoImpl();
        java.util.Date ad= new java.util.Date();
        orderDao.addOrder("622222200010252244","D2985","31","35",new java.util.Date(),new java.util.Date(),"1001",168,2);
        System.out.println("end");
    }

    @Test
    public void testgetStationOrder() {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        System.out.println(trainInforDao.getStationOrder("D8481", "贵港站"));
    }
}

