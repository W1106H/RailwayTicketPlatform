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
    public TrainInfo serchTrainInfoBytrainNum(String trainNum1) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        TrainInfo trainInfo = null;
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
                String runTime = time.toString();
                //将时分字符串转换成Data类型
                Date startTime = StringForData.slip(trainStartTime);
                Date endTime = StringForData.slip(trainEndTime);
                trainInfo = new TrainInfo(trainNum, trainTypeName, startTime, trainStartStation, endTime, trainEndStation, runTime, trainCarriages, trainPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return trainInfo;
    }

    @Override
    //修改

    public Object[][] serchTrainInfoByStationName(String startStation, String endStation) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[][] trains = new Object[this.TraincountByStationName(startStation, endStation)][];
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT train_price,train_num,train_type,train_start_station,train_end_station,train_start_time,train_end_time,to_char(TRAIN_START_TIME,'hh24:mi') as startTime ,to_char(train_end_time,'hh24:mi') as endTime FROM train_info where train_start_station=? and train_end_station=?");
            preparedStatement.setString(1, startStation);
            preparedStatement.setString(2, endStation);
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                String trainNum = resultSet.getString("TRAIN_NUM");
                String trainType = resultSet.getString("TRAIN_TYPE");
                String trainStartTime = resultSet.getString("startTime");
                String trainEndTime = resultSet.getString("endTime");
                String trainStartStation = resultSet.getString("TRAIN_START_STATION");
                String trainEndStation = resultSet.getString("TRAIN_END_STATION");
                int price = resultSet.getInt("train_price");
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
                trains[i] = new Object[]{trainNum, trainType, trainStartTime, trainEndTime, trainStartStation, trainEndStation, runTime, price};
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
    public int TraincountByStationName(String startStation, String endStationg) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int num = 0;
        try {
            preparedStatement = connection.prepareStatement("select count(*) from train_info where train_start_station=? and train_end_station=?");
            preparedStatement.setString(1, startStation);
            preparedStatement.setString(2, endStationg);
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
    public Object[][] serchRemainingticketsByTrainNum(String trainNum) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int carriage=this.getCarriage(trainNum);
        Object[][] seats =new Object[carriage][];
        int i = 0;
        try {
            preparedStatement = connection.prepareStatement("select * from seat where train_num=? ");
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
