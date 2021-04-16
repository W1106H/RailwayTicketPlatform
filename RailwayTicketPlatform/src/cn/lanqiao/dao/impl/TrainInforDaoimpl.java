package cn.lanqiao.dao.impl;

import cn.lanqiao.dao.TrainInforDao;
import cn.lanqiao.entity.TrainInformation.TrainInfo;
import cn.lanqiao.util.JDBCUtil;
import cn.lanqiao.util.StringForData;
import org.junit.Test;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrainInforDaoimpl implements TrainInforDao {

    /*计算中转总价格*/
    @Override
    public int getTransferTotalPrice(int startStationOrder1, int endStationOrder1,int startStationOrder2,int endStationOrder2) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql="select sum(price) as total_price from train_parking_station where (station_order > ? and station_order<= ?) or (station_order > ? and station_order<=?)";
        int price = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,String.valueOf(startStationOrder1));
            preparedStatement.setString(2,String.valueOf(endStationOrder1));
            preparedStatement.setString(3,String.valueOf(startStationOrder2));
            preparedStatement.setString(4,String.valueOf(endStationOrder2));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                price = resultSet.getInt("total_price");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return price;
    }

    @Override
    /*查询中转列车信息*/
    public Object[][] getTransferInfor(String startStation, String endStation,boolean decSortYesOrNo) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[][] object = new Object[50][];
        int i=0;
        int price=0;
        String sql ="";
        try {
            if(decSortYesOrNo){
                sql ="select  A.station_name  station_name1, A.train_num train_num1 ," +
                        "        to_char(A.start_time,'yyyy-MM-dd') as start_date,to_char(A.start_time,'hh24:mi')  start_time1 ," +
                        "        to_char(B.arrive_time,'hh24:mi') arrive_time1," +
                        "        B.station_name station_name2," +
                        "        D.train_num train_num2, D.station_name as station_name3,to_char(C.start_time,'hh24:mi') start_time2," +
                        "        to_char(D.arrive_time,'yyyy-MM-dd') as arrive_Date ,to_char(D.arrive_time,'hh24:mi') arrive_time2," +
                        "        A.station_order start_station_order1,B.station_order end_station_order1,  " +
                        "        c.station_order start_station_order2,D.station_order end_station_order2  " +
                        "        from  train_parking_station A, train_parking_station B, " +
                        "              train_parking_station C ,train_parking_station D " +
                        "        where A.station_name =? and D.station_name =?" +
                        "            and B.station_name = C.station_name " +
                        "             and A.train_num = B.train_num  and C.train_num = D.train_num and B.train_num <> C.train_num \n" +
                        "             and B.arrive_time < C.arrive_time " +
                        "             and A.station_order < B.station_order and C.station_order < D.station_order"+
                        "             order by A.start_time desc";
            }else{
                sql ="select  A.station_name  station_name1, A.train_num train_num1 ," +
                        "        to_char(A.start_time,'yyyy-MM-dd') as start_date,to_char(A.start_time,'hh24:mi')  start_time1 ," +
                        "        to_char(B.arrive_time,'hh24:mi') arrive_time1," +
                        "        B.station_name station_name2," +
                        "        D.train_num train_num2, D.station_name as station_name3,to_char(C.start_time,'hh24:mi') start_time2," +
                        "        to_char(D.arrive_time,'yyyy-MM-dd') as arrive_Date ,to_char(D.arrive_time,'hh24:mi') arrive_time2," +
                        "        A.station_order start_station_order1,B.station_order end_station_order1,  " +
                        "        c.station_order start_station_order2,D.station_order end_station_order2  " +
                        "        from  train_parking_station A, train_parking_station B, " +
                        "              train_parking_station C ,train_parking_station D " +
                        "        where A.station_name =? and D.station_name =?" +
                        "            and B.station_name = C.station_name " +
                        "             and A.train_num = B.train_num  and C.train_num = D.train_num and B.train_num <> C.train_num \n" +
                        "             and B.arrive_time < C.arrive_time " +
                        "             and A.station_order < B.station_order and C.station_order < D.station_order"+
                        "             order by A.start_time asc";
            }

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,startStation);
            preparedStatement.setString(2,endStation);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String stationName= resultSet.getString("station_name1");
                String trainNum = resultSet.getString("train_num1");
                String startTime = resultSet.getString(  "start_time1");
                String arriveTime = resultSet.getString("arrive_time1");
                String startDate = resultSet.getString(  "start_date");
                String midleStationName = resultSet.getString("station_name2");
                String trainNum2 = resultSet.getString("train_num2");
                String startTime2 = resultSet.getString(  "start_time2");
                String arriveDate = resultSet.getString(  "arrive_date");
                String arriveTime2 = resultSet.getString("arrive_time2");
                String endstationName2= resultSet.getString("station_name3");
                int  startStationOrder1 = Integer.parseInt(resultSet.getString("start_station_order1"));
                int endStationOrder1 = Integer.parseInt(resultSet.getString("end_station_order1"));
                int startStationOrder2 = Integer.parseInt(resultSet.getString("start_station_order2"));
                int endStationOrder2 = Integer.parseInt(resultSet.getString("end_station_order2"));

                price=getTransferTotalPrice(startStationOrder1,endStationOrder1,startStationOrder2,endStationOrder2);

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                java.util.Date date1 = sdf.parse(arriveTime);
                java.util.Date date2 = sdf.parse(startTime2);
                java.util.Date date3 = sdf.parse(startTime);
                java.util.Date date4 = sdf.parse(arriveTime2);
                StringBuffer time1 = new StringBuffer();
                StringBuffer time2= new StringBuffer();
                long temp1 = (date2.getTime() - date1.getTime()) / 1000;
                long temp2 = (date4.getTime() - date3.getTime()) / 1000;
                long hours1 = temp1 % (24 * 3600) / 3600;
                long hours2 = temp2 % (24 * 3600) / 3600;
                if (hours1 < 10) {
                    time1.append("0" + hours1 + ":");
                }
                if (hours1 >= 10) {
                    time1.append(hours1 + ":");
                }
                long mins1 = temp1 % 3600 / 60;
                if (mins1 < 10) {
                    time1.append("0" + mins1);
                }
                if (mins1 >= 10) {
                    time1.append(mins1);
                }
                String transferTime = time1.toString();

                if (hours2 < 10) {
                    time2.append("0" + hours2 + ":");
                }
                if (hours2 >= 10) {
                    time2.append(hours2 + ":");
                }
                long mins2 = temp2 % 3600 / 60;
                if (mins2 < 10) {
                    time2.append("0" + mins2);
                }
                if (mins2 >= 10) {
                    time2.append(mins2);
                }
                String runTime = time2.toString();
                object[i] = new Object[]{ stationName, trainNum,startTime, arriveTime, transferTime,midleStationName, trainNum2,startTime2, arriveTime2,endstationName2,runTime,price };
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return object;
    }
    @Override
    //列车信息表
    public Object[][] getAllTrainInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[][] trains = new Object[this.Traincount()][];
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT NUM_OF_CARRIAGE,train_num,train_type,train_start_station,train_end_station,train_start_time,train_end_time,to_char(TRAIN_START_TIME,'hh24:mi') as startTime ,to_char(train_end_time,'hh24:mi') as endTime FROM train_info");
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                String trainNum = resultSet.getString("TRAIN_NUM");
                String trainType = resultSet.getString("TRAIN_TYPE");
                String trainStartTime = resultSet.getString("startTime");
                String trainEndTime = resultSet.getString("endTime");
                String trainStartStation = resultSet.getString("TRAIN_START_STATION");
                String trainEndStation = resultSet.getString("TRAIN_END_STATION");
                int carriageNum = resultSet.getInt("NUM_OF_CARRIAGE");
                //计算运行时间
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                java.util.Date date2 = sdf.parse(trainEndTime);
                java.util.Date date1 = sdf.parse(trainStartTime);
                StringBuffer time = new StringBuffer();
                long temp = (date2.getTime() - date1.getTime()) / 1000;
                long hours = temp % (24 * 3600) / 3600;
                if (hours < 10) {
                    time.append("0" + hours + ":");
                }
                if (hours >= 10) {
                    time.append(hours + ":");
                }
                long mins = temp % 3600 / 60;
                if (mins < 10) {
                    time.append("0" + mins);
                }
                if (mins >= 10) {
                    time.append(mins);
                }
                String runTime = time.toString();
                trains[i] = new Object[]{trainNum, trainType, trainStartTime, trainEndTime, trainStartStation, trainEndStation, runTime, carriageNum};
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return trains;
    }

    @Override
    public int Traincount() {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int num = 0;
        try {
            preparedStatement = connection.prepareStatement("select count(*) from train_info");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                num = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return num;
    }

    @Override
    public int Parkingcount() {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int num = 0;
        try {
            preparedStatement = connection.prepareStatement("select count(*) from TRAIN_PARKING_STATION");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                num = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return num;
    }

    @Override
    public Object[][] getDetailTrainParking(String trainNum, String startStation, String endStation) {
        String sql="select s.train_num,s.station_name as startStation,e.station_name as endStation,\n" +
                "to_char(s.start_time,'hh24:mi') as startTime,to_char(e.arrive_time,'hh24:mi') as endTime,s.remaining_tickets as tickets\n" +
                "from train_parking_station s,train_parking_station e \n" +
                "where s.train_num=? and E.STATION_ORDEr=s.station_order+1  and \n" +
                "s.station_order >=(select p1.station_order from train_parking_station p1 where p1.station_name=? and p1.train_num=s.train_num )\n" +
                "and s.station_order <(select p2.station_order from train_parking_station p2 where p2.station_name=? and p2.train_num=s.train_num )";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[][] trains = new Object[this.getTrainPakingNum(trainNum,startStation,endStation)][];
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, trainNum);
            preparedStatement.setString(2, startStation);
            preparedStatement.setString(3, endStation);
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                //String trainNum = resultSet.getString("TRAIN_NUM");
                String trainStartTime = resultSet.getString("startTime");
                String trainEndTime = resultSet.getString("endTime");
                String startStation1 = resultSet.getString("startStation");
                String endStation1 = resultSet.getString("endStation");
                int tickets = resultSet.getInt("tickets");
                //计算运行时间
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                java.util.Date date2 = sdf.parse(trainStartTime);
                java.util.Date date1 = sdf.parse(trainEndTime);
                StringBuffer time = new StringBuffer();
                long temp = (date1.getTime() - date2.getTime()) / 1000;
                long hours = temp % (24 * 3600) / 3600;
                if (hours < 10) {
                    time.append("0" + hours + ":");
                }
                if (hours >= 10) {
                    time.append(hours + ":");
                }
                long mins = temp % 3600 / 60;
                if (mins < 10) {
                    time.append("0" + mins);
                }
                if (mins >= 10) {
                    time.append(mins);
                }
                String runTime = time.toString();
                trains[i] = new Object[]{trainNum,startStation1,endStation1, trainStartTime,trainEndTime, time,tickets};
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return trains;
    }

    @Override
    //列车时刻表
    public Object[][] getAllTrainPakingInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[][] trains = new Object[this.Parkingcount()][];
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement("select price,train_num,station_order,station_name,to_char(arrive_time,'hh24:mi') as arriveTime ,to_char(start_time,'hh24:mi') as startTime from train_parking_station");
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                String trainNum = resultSet.getString("TRAIN_NUM");
                String trainStartTime = resultSet.getString("startTime");
                String trainArriveTime = resultSet.getString("arriveTime");
                String stationName = resultSet.getString("station_name");
                String stationOrder = resultSet.getString("station_order");
                int price = resultSet.getInt("price");
                //计算运行时间
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                java.util.Date date2 = sdf.parse(trainStartTime);
                java.util.Date date1 = sdf.parse(trainArriveTime);
                StringBuffer time = new StringBuffer();
                long temp = (date2.getTime() - date1.getTime()) / 1000;
                long hours = temp % (24 * 3600) / 3600;
                if (hours < 10) {
                    time.append("0" + hours + ":");
                }
                if (hours >= 10) {
                    time.append(hours + ":");
                }
                long mins = temp % 3600 / 60;
                if (mins < 10) {
                    time.append("0" + mins);
                }
                if (mins >= 10) {
                    time.append(mins);
                }
                String runTime = time.toString();
                trains[i] = new Object[]{stationOrder, stationName, trainNum, trainArriveTime, trainStartTime, time, price};
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return trains;
    }

    @Override
    //查询某列车信息
    public Object[][] serchTrainInfoBytrainNum(String trainNum1) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        TrainInfo trainInfo = null;
        Object[][] train = new Object[1][];
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT train_price,train_num,train_type,train_start_station,train_end_station,train_start_time,train_end_time,num_of_carriage,to_char(TRAIN_START_TIME,'hh24:mi') as startTime ,to_char(train_end_time,'hh24:mi') as endTime FROM train_info where train_num=?");
            preparedStatement.setString(1, trainNum1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String trainNum = resultSet.getString("TRAIN_NUM");
                String trainTypeName = resultSet.getString("TRAIN_TYPE");
                String trainStartTime = resultSet.getString("startTime");
                String trainEndTime = resultSet.getString("endTime");
                String trainStartStation = resultSet.getString("TRAIN_START_STATION");
                String trainEndStation = resultSet.getString("TRAIN_END_STATION");
                int trainCarriages = resultSet.getInt("NUM_OF_CARRIAGE");
                int trainPrice = resultSet.getInt("train_price");
                //计算运行时间
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                //将字符串转换成Date类型
                java.util.Date date2 = sdf.parse(trainEndTime);
                java.util.Date date1 = sdf.parse(trainStartTime);
                StringBuffer time = new StringBuffer();
                long temp = (date2.getTime() - date1.getTime()) / 1000;
                long hours = temp % (24 * 3600) / 3600;
                if (hours < 10) {
                    time.append("0" + hours + ":");
                }
                if (hours >= 10) {
                    time.append(hours + ":");
                }
                long mins = temp % 3600 / 60;
                if (mins < 10) {
                    time.append("0" + mins);
                }
                if (mins >= 10) {
                    time.append(mins);
                }
                train[0] = new Object[]{trainNum,trainTypeName,trainStartTime,trainEndTime,trainStartStation,trainEndStation,time,trainCarriages};

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return train;
    }

    @Override
    public Object[][] serchTrainInfoByStationNameAndtrainType(String startStation, String endStation, String trainType) {
        String sql="select s.station_name as startStation , e.station_name as endStation ,e.price,e.train_num,s.REMAINING_TICKETS,\n" +
                "s.station_order sStationOrder,e.station_order  eStationOrder,tf.train_type,\n" +
                "to_char(s.start_time,'HH24:mi') as startTime, to_char(e.arrive_time,'HH24:mi') as arriveTime from \n" +
                "train_parking_station s,train_parking_station e,train_info tf\n" +
                "where s.train_num=e.train_num and e.station_order>s.station_order and s.station_name=? and e.station_name=? and tf.train_num=s.train_num\n" +
                "and tf.train_type=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[][] trains = new Object[this.TraincountByStationNameAndtrainType(startStation, endStation,trainType)][];
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, startStation);
            preparedStatement.setString(2, endStation);
            preparedStatement.setString(3,trainType);
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                String trainNum = resultSet.getString("TRAIN_NUM");
                String traintype = resultSet.getString("TRAIN_TYPE");
                String trainStartTime = resultSet.getString("startTime");
                String trainEndTime = resultSet.getString("arriveTime");
                String trainStartStation = resultSet.getString("startstation");
                String trainEndStation = resultSet.getString("endstation");
                int price = resultSet.getInt("price");
                int ticket = resultSet.getInt("REMAINING_TICKETS");
                //计算运行时间
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                java.util.Date date2 = sdf.parse(trainEndTime);
                java.util.Date date1 = sdf.parse(trainStartTime);
                StringBuffer time = new StringBuffer();
                long temp = (date2.getTime() - date1.getTime()) / 1000;
                long hours = temp % (24 * 3600) / 3600;
                if (hours < 10) {
                    time.append("0" + hours + ":");
                }
                if (hours >= 10) {
                    time.append(hours + ":");
                }
                long mins = temp % 3600 / 60;
                if (mins < 10) {
                    time.append("0" + mins);
                }
                if (mins >= 10) {
                    time.append(mins);
                }
                String runTime = time.toString();
                trains[i] = new Object[]{trainNum, traintype, trainStartTime, trainEndTime, trainStartStation, trainEndStation, runTime, price,ticket};
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return trains;
    }

    @Override
    public Object[][] serchRemainingticketsByTrainNum(String trainNum) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int carriage=this.getCarriage(trainNum);
        Object[][] seats =new Object[carriage][];
        int i = 0;
        try {
            preparedStatement = connection.prepareStatement("select * from seat where train_num=? order by carriage_num asc ");
            preparedStatement.setString(1,trainNum);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String train_Num = resultSet.getString("train_num");
                int carriageNum = resultSet.getInt("carriage_num");
                String seatType = resultSet.getString("seat_type");
                int seatCount = resultSet.getInt("seat_count");
                seats[i] = new Object[]{train_Num,carriageNum, seatType, seatCount};
                i++;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return seats;
    }

    @Override
    public int TraincountByStationNameAndtrainType(String startStation, String endStationg, String trainType) {
        String sql = "select count(*) from (select s.station_name as startStation , e.station_name as endStation ,e.price,e.train_num,\n" +
                "s.station_order sStationOrder,e.station_order  eStationOrder,tf.train_type,\n" +
                "to_char(s.start_time,'HH24:mi') as startTime, to_char(e.arrive_time,'HH24:mi') as arriveTime from \n" +
                "train_parking_station s,train_parking_station e,train_info tf\n" +
                "where s.train_num=e.train_num and e.station_order>s.station_order and s.station_name=?  and e.station_name=?  and tf.train_num=s.train_num\n" +
                "and tf.train_type=?) ";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int num = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, startStation);
            preparedStatement.setString(2, endStationg);
            preparedStatement.setString(3,trainType);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                num = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return num;
    }

    //根据列车名，站名得到列车经停站信息行数
    @Override
    public int getTrainPakingNum(String trainNum, String startStation, String endStation) {
        int num=0;
        String sql="select count(*) from (select s.train_num,s.station_name as startStation,e.station_name as endStation,\n" +
                "to_char(s.start_time,'hh24:mi') as startTime,to_char(e.arrive_time,'hh24:mi') as endTime\n" +
                "from train_parking_station s,train_parking_station e \n" +
                "where s.train_num=? and E.STATION_ORDEr=s.station_order+1  and \n" +
                "s.station_order >=(select p1.station_order from train_parking_station p1 where p1.station_name=?  and p1.train_num=s.train_num )\n" +
                "and s.station_order <(select p2.station_order from train_parking_station p2 where p2.station_name=?  and p2.train_num=s.train_num ))";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, trainNum);
            preparedStatement.setString(2, startStation);
            preparedStatement.setString(3,endStation);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                num = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return num;
    }
    //得到订单信息
    @Override
    public Object[][] TicketsOrder( String orders_creator, String trainNum,String startStation, String endStation) {
        String sql ="select s.station_name as startStation , e.station_name as endStation ,e.price,e.train_num,\n" +
                "s.station_order Station_start_no,e.station_order  Station_end_no,\n" +
                "to_char(s.start_time,'HH24:mi') as startTime, to_char(e.arrive_time,'HH24:mi') as endTime from \n" +
                "train_parking_station s,train_parking_station e\n" +
                "where s.train_num=?  and s.train_num=e.train_num and e.station_order>s.station_order and s.station_name=?  and e.station_name=? ";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        Connection connection1=null;
        ResultSet resultSet = null;

        Object[][] orders = new Object[1][];
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, trainNum);
            preparedStatement.setString(2, startStation);
            preparedStatement.setString(3, endStation);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String trainNo = resultSet.getString("train_Num");
                String train_start_time = resultSet.getString("startTime");
                String train_end_time = resultSet.getString("endTime");
                String station_start_no = resultSet.getString("Station_start_no");
                String station_end_no = resultSet.getString("station_end_no");
                orders[0] = new Object[]{trainNo, train_start_time, train_end_time, station_start_no, station_end_no, orders_creator};
            }
            /*sql="UPDATE train_parking_station set remaining_tickets=remaining_tickets-1 where station_order<=? and  station_order>=?  and train_num=?";
            connection1 = JDBCUtil.getConnection();
             preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1, station_end_no);
            preparedStatement1.setString(2, station_start_no);
            preparedStatement1.setString(3,trainNo);
            preparedStatement1.execute();*/

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return orders;
    }
    //退票
    @Override
    public void refundTicket(String orderNo,String trainNum, String startStationNum, String endStationNum) {
        String sql="UPDATE train_parking_station set remaining_tickets=remaining_tickets+1 where station_order<=? and  station_order>=?  and train_num=?";
        String sql2="DELETE orders where order_no= ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, startStationNum);
            preparedStatement.setString(2, endStationNum);
            preparedStatement.setString(3, trainNum);
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1,orderNo);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(null, preparedStatement, connection);
        }
    }

    @Override
    public void updataTicket(String trainNum, String startStationNum, String endStationNum) {
        String sql="UPDATE train_parking_station set remaining_tickets=remaining_tickets-1 where station_order<=? and  station_order>=?  and train_num=?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, startStationNum);
            preparedStatement.setString(2, endStationNum);
            preparedStatement.setString(3, trainNum);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(null, preparedStatement, connection);
        }
    }

    //得到列车车厢数
    public int getCarriage(String trainNum) {
        int carriage=0;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select NUM_OF_CARRIAGE from train_info where train_num=?");
            preparedStatement.setString(1, trainNum);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                carriage = resultSet.getInt("num_of_carriage");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return carriage;
    }


}
