package cn.lanqiao.dao.impl;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.entity.Peoples.Orders;
import cn.lanqiao.util.JDBCUtil;
import cn.lanqiao.util.StringForData;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class OrderDaoImpl implements OrderDao {
    private boolean orderAlreadyPayFlag = false;
    private boolean OrderNotPayFlag=false;
    private boolean historicalOrdersFlag=false;
    private boolean orderNotTravelFlag=false;

    @Override
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage2) {
        Object[][] orderAlreadyPay = null;
//        第一步：获得连接
        Connection connection = JDBCUtil.getConnection();
        int startIndex=(currentPage2-1) *5 + 1;
        int endIndex=currentPage2*5;
        String sql = "select * " +
                "from " +
                "    (select table1.*,ROWNUM rn " +
                "    from " +
                "        (select o.order_no,o.train_no,tps1.station_name as startStationName,tps2.station_name as arriveStationName,o.train_start_time,o.sumprice,p.pname " +
                "        from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                "        where o.order_creator = ? " +
                "            and o.visual = 'T' " +
                "            and o.train_no = tps1.train_num " +
                "            and o.train_no = tps2.train_num " +
                "            and o.station_start_no = tps1.station_order " +
                "            and o.station_end_no = tps2.station_order " +
                "            and tps1.train_num = tps2.train_num " +
                "            and o.order_state = 'T' " +
                "            and o.PID = p.passengerID" +
                "            and o.TRAIN_START_TIME < sysdate " +
                "        ORDER BY train_start_time DESC) table1) table2 " +
                "where rn between ? and ?";
        PreparedStatement pr = null;
        ResultSet rs = null;
        orderAlreadyPay = new Object[this.getOrderAlreadyPay_Count(userPID)][];
        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1,userPID);
            pr.setInt(2,startIndex);
            pr.setInt(3,endIndex);
            rs = pr.executeQuery();
            int i = 0;  //数组下标
            while(rs.next()){
                String orderNo = rs.getString("order_no");
                String trainNo = rs.getString("train_no");
                String startStationName = rs.getString("startStationName");
                String arriveStationName = rs.getString("arriveStationName");
                java.sql.Date startDate = rs.getDate("train_start_time");
                java.sql.Time startTime = rs.getTime("train_start_time");
                double sumPrice = rs.getDouble("sumprice");
                String pname = rs.getString("pname");
                String startDateAndTime = new String(startDate + " " + startTime);
                orderAlreadyPay[i] = new Object[]{orderNo,trainNo,startStationName,arriveStationName,startDateAndTime,sumPrice,pname};
                setOrderAlreadyPayFlag(true);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,pr,connection);
        }
        return orderAlreadyPay;
    }

//    获得未支付的表格信息
    @Override
    public Object[][] getOrderNotPay(String userPID, int currentPage2) {
        Object[][] orderNotPay = null;
//        第一步：获得连接
        Connection connection = JDBCUtil.getConnection();
        int startIndex=(currentPage2-1) *5 + 1;
        int endIndex=currentPage2*5;
        String sql = "select * " +
                "from " +
                "    (select table1.*,ROWNUM rn " +
                "    from " +
                "        (select o.order_no,o.train_no,tps1.station_name as startStationName,tps2.station_name as arriveStationName,o.train_start_time,o.sumprice,p.pname " +
                "        from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                "        where o.order_creator = ? " +
                "            and o.visual = 'T' " +
                "            and o.train_no = tps1.train_num " +
                "            and o.train_no = tps2.train_num " +
                "            and o.station_start_no = tps1.station_order " +
                "            and o.station_end_no = tps2.station_order " +
                "            and tps1.train_num = tps2.train_num " +
                "            and o.order_state = 'F' " +
                "            and o.PID = p.passengerID " +
                "        ORDER BY train_start_time DESC) table1) table2 " +
                "where rn between ? and ? ";
        PreparedStatement pr = null;
        ResultSet rs = null;
        orderNotPay = new Object[this.getOrderNotPay_Count(userPID)][];
        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1,userPID);
            pr.setInt(2,startIndex);
            pr.setInt(3,endIndex);
            rs = pr.executeQuery();
            int i = 0;  //数组下标
            while(rs.next()){
                String orderNo = rs.getString("order_no");
                String trainNo = rs.getString("train_no");
                String startStationName = rs.getString("startStationName");
                String arriveStationName = rs.getString("arriveStationName");
                java.sql.Date startDate = rs.getDate("train_start_time");
                java.sql.Time startTime = rs.getTime("train_start_time");
                double sumPrice = rs.getDouble("sumprice");
                String pname = rs.getString("pname");
                String startDateAndTime = new String(startDate + " " + startTime);
                orderNotPay[i] = new Object[]{orderNo,trainNo,startStationName,arriveStationName,startDateAndTime,sumPrice,pname};
                setOrderNotPayFlag(true);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,pr,connection);
        }
        return orderNotPay;
    }

    @Override
    public int getOrderAlreadyPay_Count(String userPID) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int number = 0;
        try {
            String sql = "select count(*) " +
                    "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                    "where o.order_creator =? " +
                    "    and o.visual = 'T' " +
                    "    and o.train_no = tps1.train_num " +
                    "    and o.train_no = tps2.train_num " +
                    "    and o.station_start_no = tps1.station_order " +
                    "    and o.station_end_no = tps2.station_order " +
                    "    and tps1.train_num = tps2.train_num " +
                    "    and o.order_state = 'T' " +
                    "    and o.PID = p.passengerId " +
                    "ORDER BY train_start_time DESC " ;
            ps = connection.prepareStatement(sql);
            ps.setString(1,userPID);
            rs = ps.executeQuery();
            if(rs.next()){
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return number;
    }

    @Override
    public int getOrderNotPay_Count(String userPID) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int number = 0;
        try {
            String sql = "select count(*) " +
                    "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                    "where o.order_creator = ? " +
                    "    and o.visual = 'T' " +
                    "    and o.train_no = tps1.train_num " +
                    "    and o.train_no = tps2.train_num " +
                    "    and o.station_start_no = tps1.station_order " +
                    "    and o.station_end_no = tps2.station_order " +
                    "    and tps1.train_num = tps2.train_num " +
                    "    and o.order_state = 'F' " +
                    "    and o.PID = p.passengerId " +
                    "ORDER BY train_start_time DESC " ;
            ps = connection.prepareStatement(sql);
            ps.setString(1,userPID);
            rs = ps.executeQuery();
            if(rs.next()){
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return number;
    }

    @Override
    public boolean getOrderAlreadyPay_JudgeFlag() {
        return isOrderAlreadyPayFlag();
    }

    @Override
    public boolean getOrderNotPay_JudgeFlag() {
        return isOrderNotPayFlag();
    }

    @Override
    public boolean getOrderAlreadyPay_SetVisible(String orderNo) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update orders set visual = 'F' where order_No = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,orderNo);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
    }

    @Override
    public Orders getDetailOrder(String orderNo) {
        Orders orders = null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select o.order_no,o.PID,o.train_no,o.train_start_time,o.train_end_time,tps1.station_name as start_station,tps2.station_name as arrive_station,o.carriage_no,o.seat_no,s.seat_type,ot.type,o.order_state,o.sumprice,p.pname,o.order_create_time " +
                    "from orders o,order_type ot,train_parking_station tps1,train_parking_station tps2,seat s,passengers p " +
                    "where o.order_no = ? " +
                    "    and o.train_no = tps1.train_num " +
                    "    and o.train_no = tps2.train_num " +
                    "    and o.station_start_no = tps1.station_order " +
                    "    and o.station_end_no = tps2.station_order " +
                    "    and o.order_type = ot.id " +
                    "    and o.train_no = s.train_num " +
                    "    and o.carriage_no = s.carriage_num " +
                    "    and o.pid = p.passengerId";
            ps = connection.prepareStatement(sql);
            ps.setString(1,orderNo);
            rs = ps.executeQuery();
            if(rs.next()){
                String order_no = rs.getString("order_no");
                String PID = rs.getString("PID");
                String train_no = rs.getString("train_no");
                Date train_start_Date = rs.getDate("train_start_time");
                Date train_end_Date = rs.getDate("train_end_time");
                String start_station = rs.getString("start_station");
                String arrive_station = rs.getString("arrive_station");
                String carriage_no = rs.getString("carriage_no");
                String seat_no = rs.getString("seat_no");
                String seat_type = rs.getString("seat_type");
                String order_type = rs.getString("type");
                String order_state = rs.getString("order_state");
                double sumprice = rs.getDouble("sumprice");
                java.sql.Time train_start_time = rs.getTime("train_start_time");
                java.sql.Time train_end_time = rs.getTime("train_end_time");
                String passengerName = rs.getString("pname");
                Date order_create_time = rs.getDate("order_create_time");
                java.sql.Time order_createDetailTime = rs.getTime("order_create_time");
                orders = new Orders(order_no,PID,train_no,train_start_Date,train_end_Date,start_station,arrive_station,carriage_no,seat_no,seat_type,order_state,sumprice,order_type,train_start_time,train_end_time,passengerName,order_create_time,order_createDetailTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return orders;
    }

    @Override
    public Object[][] getTrainPassInfo(String orderNo) {
        Object[][] trainPassInfo = null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int number = this.getTrainPassInfo_Count(orderNo);
        trainPassInfo = new Object[number][];
        try {
            String sql = "select tps.* " +
                    "from orders o,train_parking_station tps " +
                    "where o.order_no = ? " +
                    "    and o.train_no = tps.train_num ";
            ps = connection.prepareStatement(sql);
            ps.setString(1,orderNo);
            rs = ps.executeQuery();
            int i = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            while (rs.next()) {
                String station_name = rs.getString("station_name");
                Time arrive_Time = rs.getTime("arrive_Time");
                Time start_Time = rs.getTime("start_Time");
                String arriveTime = sdf.format(arrive_Time);
                String startTime = sdf.format(start_Time);
                if (i == 0) {
                    trainPassInfo[i] = new Object[]{station_name, "--", startTime, "--"};
                } else if (i == number - 1) {
                    trainPassInfo[i] = new Object[]{station_name, arriveTime, "--", "--"};
                } else {
                    int timeSub = StringForData.getTimeSub(arrive_Time, start_Time);
                    trainPassInfo[i] = new Object[]{station_name, arriveTime, startTime, timeSub + "分钟"};
                }
                i++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return trainPassInfo;
    }

    public Object[][] getHistoricalOrders(String userPID,int currentPage) {
        Object[][] historicalOrders = null;
//        第一步：获得连接
        Connection connection = JDBCUtil.getConnection();
        int startIndex=(currentPage-1) *5 + 1;
        int endIndex=currentPage*5;
        String sql = "select * " +
                "from " +
                "    (select table1.*,ROWNUM rn " +
                "    from" +
                "        (select o.order_no,o.train_no,tps1.station_name as startStationName,tps2.station_name as arriveStationName,o.train_start_time,o.sumprice,p.pname " +
                "        from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                "        where o.order_creator = ? " +
                "            and o.visual = 'T' " +
                "            and o.train_no = tps1.train_num " +
                "            and o.train_no = tps2.train_num " +
                "            and o.station_start_no = tps1.station_order " +
                "            and o.station_end_no = tps2.station_order " +
                "            and tps1.train_num = tps2.train_num " +
                "            and o.PID = p.passengerID " +
                "        ORDER BY order_Create_Time DESC) table1) table2 " +
                "where rn between ? and ? ";
        PreparedStatement pr = null;
        ResultSet rs = null;
        historicalOrders = new Object[this.getHistoricalOrders_Count(userPID)][];
        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1,userPID);
            pr.setInt(2,startIndex);
            pr.setInt(3,endIndex);
            rs = pr.executeQuery();
            int i = 0;  //数组下标
            while(rs.next()){
                String orderNo = rs.getString("order_no");
                String trainNo = rs.getString("train_no");
                String startStationName = rs.getString("startStationName");
                String arriveStationName = rs.getString("arriveStationName");
                java.sql.Date startDate = rs.getDate("train_start_time");
                java.sql.Time startTime = rs.getTime("train_start_time");
                double sumPrice = rs.getDouble("sumprice");
                String pname = rs.getString("pname");
                String startDateAndTime = new String(startDate + " " + startTime);
                historicalOrders[i] = new Object[]{orderNo,trainNo,startStationName,arriveStationName,startDateAndTime,sumPrice,pname};
                setOrderNotPayFlag(true);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,pr,connection);
        }
        return historicalOrders;
    }

    @Override
    public int getTrainPassInfo_Count(String orderNo) {
        int number = 0;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "select count(*) " +
                    "from orders o,train_parking_station tps " +
                    "where o.order_no = ? " +
                    "    and o.train_no = tps.train_num ";
            ps = connection.prepareStatement(sql);
            ps.setString(1,orderNo);
            rs = ps.executeQuery();
            if(rs.next()){
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return number;
    }

    @Override
    public Orders getOrderByOrderNo(String orderNo) {
        Orders orders = null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * " +
                    "from orders o,order_type ot,train_parking_station tps1,train_parking_station tps2,seat s,passengers p " +
                    "where o.order_no = ? " ;
            ps = connection.prepareStatement(sql);
            ps.setString(1,orderNo);
            rs = ps.executeQuery();
            if(rs.next()){
                String order_no = rs.getString("order_no");
                String PID = rs.getString("PID");
                String train_no = rs.getString("train_no");
                Date train_start_Date = rs.getDate("train_start_time");
                Date train_end_Date = rs.getDate("train_end_time");
                String start_station = rs.getString("station_start_no");
                String arrive_station = rs.getString("station_end_no");
                String carriage_no = rs.getString("carriage_no");
                String seat_no = rs.getString("seat_no");
                String order_creator = rs.getString("order_creator");
                String order_state = rs.getString("order_state");
                Timestamp order_create_Time = rs.getTimestamp("Order_Create_Time");
               /* Date order_create_Time = rs.getDate("Order_Create_Time");*/
                double sumprice = rs.getDouble("sumprice");
                String order_type = rs.getString("Order_Type");
                String visual = rs.getString("Visual");
                orders = new Orders(order_no,PID,train_no,train_start_Date,train_end_Date,start_station,arrive_station,carriage_no,seat_no,order_creator,order_state,order_create_Time,sumprice,visual,order_type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return orders;
    }

    @Override
    public int getHistoricalOrders_Count(String userPID) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int number = 0;
        try {
            String sql = "select count(*) " +
                    "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                    "        where o.order_creator = ? " +
                    "            and o.visual = 'T' " +
                    "            and o.train_no = tps1.train_num " +
                    "            and o.train_no = tps2.train_num " +
                    "            and o.station_start_no = tps1.station_order " +
                    "            and o.station_end_no = tps2.station_order " +
                    "            and tps1.train_num = tps2.train_num " +
                    "            and o.PID = p.passengerID " +
                    "        ORDER BY train_start_time DESC " ;
            ps = connection.prepareStatement(sql);
            ps.setString(1,userPID);
            rs = ps.executeQuery();
            if(rs.next()){
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return number;
    }

    @Override
    public java.util.Date getTrainPassInfo_trainStartDate(String orderNo) {
        java.util.Date date = null;
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select train_start_time from orders where order_no = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, orderNo);
            rs = ps.executeQuery();
            if (rs.next()) {
                date = rs.getDate("train_start_time");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, con);
        }
        return date;
    }

    public boolean getHistoricalOrders_JudgeFlag() {
        return isHistoricalOrdersFlag();
    }

    @Override
    public Object[][] getOrderNotTravel(String userPID, int currentPage) {
        Object[][] orderNotTravel = null;
//        第一步：获得连接
        Connection connection = JDBCUtil.getConnection();
        int startIndex=(currentPage-1) *5 + 1;
        int endIndex=currentPage*5;
        String sql = "select * " +
                "from " +
                "    (select table1.*,ROWNUM rn " +
                "    from " +
                "        (select o.order_no,o.train_no,tps1.station_name as startStationName,tps2.station_name as arriveStationName,o.train_start_time,o.sumprice,p.pname " +
                "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                "where o.order_creator = ? " +
                "and o.PID = p.passengerid " +
                "and o.visual = 'T' " +
                "and o.train_no = tps1.train_num " +
                "and o.train_no = tps2.train_num " +
                "and o.station_start_no = tps1.station_order " +
                "and o.station_end_no = tps2.station_order " +
                "and o.train_start_time > sysdate " +
                "ORDER BY o.train_start_time DESC) table1) table2 " +
                "where rn between ? and ? ";
        PreparedStatement pr = null;
        ResultSet rs = null;
        orderNotTravel = new Object[this.getOrderNotTravel_Count(userPID)][];
        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1,userPID);
            pr.setInt(2,startIndex);
            pr.setInt(3,endIndex);
            rs = pr.executeQuery();
            int i = 0;  //数组下标
            while(rs.next()){
                String orderNo = rs.getString("order_no");
                String trainNo = rs.getString("train_no");
                String startStationName = rs.getString("startStationName");
                String arriveStationName = rs.getString("arriveStationName");
                java.sql.Date startDate = rs.getDate("train_start_time");
                java.sql.Time startTime = rs.getTime("train_start_time");
                double sumPrice = rs.getDouble("sumprice");
                String pname = rs.getString("pname");
                String startDateAndTime = new String(startDate + " " + startTime);
                orderNotTravel[i] = new Object[]{orderNo,trainNo,startStationName,arriveStationName,startDateAndTime,sumPrice,pname};
                setOrderNotTravelFlag(true);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,pr,connection);
        }
        return orderNotTravel;
    }

    @Override
    public int getOrderNotTravel_Count(String userPID) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int number = 0;
        try {
            String sql = "select count(*)" +
                    "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                    "where o.order_creator = ? " +
                    "and o.PID = p.passengerid " +
                    "and o.visual = 'T' " +
                    "and o.train_no = tps1.train_num " +
                    "and o.train_no = tps2.train_num " +
                    "and o.station_start_no = tps1.station_order " +
                    "and o.station_end_no = tps2.station_order " +
                    "and o.train_start_time > sysdate " +
                    "ORDER BY o.train_start_time DESC";
            ps = connection.prepareStatement(sql);
            ps.setString(1,userPID);
            rs = ps.executeQuery();
            if(rs.next()){
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return number;
    }

    @Override
    public Object[][] getPersonalTicket(String userPID) {
        Object[][] personalTicketArray = null;
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        personalTicketArray = new Object[this.getPersonalTicket_Count(userPID)][];
        try {
            String sql = "select o.order_no,o.train_no,tps1.station_name as startStation,tps2.station_name as arriveStation,o.train_start_time,o.sumprice,p.pname " +
                    "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                    "where o.PID = ? " +
                    "    and o.PID = p.passengerID " +
                    "    and o.train_no = tps1.train_num " +
                    "    and o.train_no = tps2.train_num " +
                    "    and o.station_start_no = tps1.station_order " +
                    "    and o.station_end_no = tps2.station_order " +
                    "    and o.order_state = 'T' " +
                    "    and o.visual = 'T' " +
                    "order by o.train_start_time DESC ";
            ps = con.prepareStatement(sql);
            ps.setString(1,userPID);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()){
                String orderNo = rs.getString("order_no");
                String trainNo = rs.getString("train_no");
                String startStation = rs.getString("startStation");
                String arriveStation = rs.getString("arriveStation");
                String trainStartTime = rs.getString("train_start_time");
                String sumPrice = rs.getString("sumprice");
                String personalName = rs.getString("pname");
                personalTicketArray[i] = new Object[]{orderNo,trainNo,startStation,arriveStation,trainStartTime,sumPrice,personalName};
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalTicketArray;
    }

    @Override
    public int getPersonalTicket_Count(String userPID) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int number = 0;
        try {
            String sql = "select count(*) " +
                    "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                    "where o.pid = ? " +
                    "    and o.PID = p.passengerID " +
                    "    and o.train_no = tps1.train_num " +
                    "    and o.train_no = tps2.train_num " +
                    "    and o.station_start_no = tps1.station_order " +
                    "    and o.station_end_no = tps2.station_order " +
                    "    and o.order_state = 'T' " +
                    "order by o.train_start_time DESC ";
            ps = connection.prepareStatement(sql);
            ps.setString(1,userPID);
            rs = ps.executeQuery();
            if(rs.next()){
                number = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return number;
    }

    @Override
    public int addOrder(String PID, String train_no, String start_station_no, String arrive_station_no, java.util.Date startTime ,java.util.Date arriveTime, String order_creator, double sumprice, int orderType) {
        int flag = 0;
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        try{
//            获得订单创建时间
            //java.util.Date nowDate = new java.util.Date();
           //Date order_create_date = new Date(nowDate.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sdate = sdf.format(new java.util.Date());
            java.util.Date date = null;
            try {
                date = sdf.parse(sdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Timestamp order_create_date = new java.sql.Timestamp(date.getTime());
           // java.sql.Date date1 = (java.sql.Date)order_create_date;

//            插入订单至订单表中
            UUID uuid = UUID.randomUUID();
            String order_no = uuid.toString();
            String sql="insert into orders values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, order_no);
            ps.setString(2, PID);
            ps.setString(3, train_no);
            ps.setDate(4,new Date(startTime.getTime()));
            ps.setDate(5,new Date(arriveTime.getTime()));
            ps.setString(6,start_station_no);
            ps.setString(7,arrive_station_no);
            ps.setString(8,String.valueOf((int)(Math.random()*10 + 1)));
            ps.setString(9,String.valueOf((int)(Math.random()*11 + 1)));
            ps.setString(10,order_creator);
            ps.setString(11,"F");
            //ps.setDate(12,order_create_date);
            ps.setTimestamp(12,order_create_date);
            ps.setDouble(13,sumprice);
            ps.setString(14,"T");
            ps.setInt(15,orderType);
            flag = ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    @Override
    public Boolean updateOrderState(String orderNO) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update orders set order_state = 'T' where order_no = ?";
        PreparedStatement preparedStatement = null;
        int issuccess=0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,orderNO);
            issuccess= preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, preparedStatement, connection);
        }
        if(issuccess>0){
            return true;// "修改支付状态成功！"
        }else{
            return false;//"修改支付状态失败！"
        }

    }

    @Override
    public int addOrderIncludeUuid(String UUID, String PID, String train_no, String start_station_no, String arrive_station_no, java.util.Date startTime, java.util.Date arriveTime, String order_creator, double sumprice, int orderType) {
        int flag = 0;
        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        try{
//            获得订单创建时间
            //java.util.Date nowDate = new java.util.Date();
            //Date order_create_date = new Date(nowDate.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sdate = sdf.format(new java.util.Date());
            java.util.Date date = null;
            try {
                date = sdf.parse(sdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Timestamp order_create_date = new java.sql.Timestamp(date.getTime());
            // java.sql.Date date1 = (java.sql.Date)order_create_date;

//            插入订单至订单表中
            String sql="insert into orders values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, UUID);
            ps.setString(2, PID);
            ps.setString(3, train_no);
            ps.setDate(4,new Date(startTime.getTime()));
            ps.setDate(5,new Date(arriveTime.getTime()));
            ps.setString(6,start_station_no);
            ps.setString(7,arrive_station_no);
            ps.setString(8,String.valueOf((int)(Math.random()*10 + 1)));
            ps.setString(9,String.valueOf((int)(Math.random()*11 + 1)));
            ps.setString(10,order_creator);
            ps.setString(11,"F");
            //ps.setDate(12,order_create_date);
            ps.setTimestamp(12,order_create_date);
            ps.setDouble(13,sumprice);
            ps.setString(14,"T");
            ps.setInt(15,orderType);
            flag = ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    @Override
    public String getPassengerName(String PID) {
        Connection connection = JDBCUtil.getConnection();
        String returnValue = null;
        String sql = "select pName from passengers where passengerid=?";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int issuccess=0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,PID);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                returnValue = rs.getString("pName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, preparedStatement, connection);
        }
        return returnValue;
    }

    public void setOrderAlreadyPayFlag(boolean orderAlreadyPayFlag) {
        this.orderAlreadyPayFlag = orderAlreadyPayFlag;
    }
    public void setOrderNotPayFlag(boolean orderNotPayFlag) {
        this.OrderNotPayFlag = orderNotPayFlag;
    }

    public boolean isOrderAlreadyPayFlag() {
        return orderAlreadyPayFlag;
    }
    public boolean isOrderNotPayFlag(){
        return OrderNotPayFlag;
    }

    public void setHistoricalOrdersFlag(boolean historicalOrdersFlag){
        this.historicalOrdersFlag=historicalOrdersFlag;
    }

    public boolean isHistoricalOrdersFlag(){
        return historicalOrdersFlag;
    }
    public void setOrderNotTravelFlag(boolean orderNotTravelFlag){
        this.orderNotTravelFlag=orderNotTravelFlag;
    }
}