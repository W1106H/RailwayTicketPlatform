package cn.lanqiao.dao.impl;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    private boolean orderAlreadyPayFlag = false;

    @Override
    public Object[][] getOrderAlreadyPay(String userPID) {
        Object[][] orderAlreadyPay = null;
//        第一步：获得连接
        Connection connection = JDBCUtil.getConnection();
        String sql = "select o.order_no,o.train_no,tps1.station_name as startStationName,tps2.station_name as arriveStationName,o.train_start_time,o.sumprice,p.pname " +
                "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                "where o.PID = " + userPID + " " +
                "    and o.visual = 'T' " +
                "    and o.train_no = tps1.train_num " +
                "    and o.train_no = tps2.train_num " +
                "    and o.pid = p.passengerid " +
                "    and o.station_start_no = tps1.station_order " +
                "    and o.station_end_no = tps2.station_order " +
                "    and tps1.train_num = tps2.train_num " +
                "    and o.train_start_time = tps1.start_time " +
                "    and o.train_end_time = tps2.arrive_time" +
                "    and o.order_state = 'T' ";
        PreparedStatement pr = null;
        ResultSet rs = null;
        orderAlreadyPay = new Object[this.getOrderAlreadyPay_Count()][];
        try {
            pr = connection.prepareStatement(sql);
            rs = pr.executeQuery();
            int i = 0;  //数组下标
            while(rs.next()){
                String orderNo = rs.getString("order_no");
                String trainNo = rs.getString("train_no");
                String startStationName = rs.getString("startStationName");
                String arriveStationName = rs.getString("arriveStationName");
                java.sql.Date startTime = rs.getDate("train_start_time");
                double sumPrice = rs.getDouble("sumprice");
                String pname = rs.getString("pname");
                orderAlreadyPay[i] = new Object[]{orderNo,trainNo,startStationName,arriveStationName,startTime,sumPrice,pname};
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

    @Override
    public int getOrderAlreadyPay_Count() {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int number = 0;
        try {
            String sql = "select count(*) " +
                    "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                    "where o.train_no = tps1.train_num " +
                    "    and o.train_no = tps2.train_num " +
                    "    and o.pid = p.passengerid " +
                    "    and o.station_start_no = tps1.station_order " +
                    "    and o.station_end_no = tps2.station_order " +
                    "    and tps1.train_num = tps2.train_num " +
                    "    and o.train_start_time = tps1.start_time " +
                    "    and o.train_end_time = tps2.arrive_time" +
                    "    and o.order_state = 'T' ";
            ps = connection.prepareStatement(sql);
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

    public void setOrderAlreadyPayFlag(boolean orderAlreadyPayFlag) {
        this.orderAlreadyPayFlag = orderAlreadyPayFlag;
    }

    public boolean isOrderAlreadyPayFlag() {
        return orderAlreadyPayFlag;
    }
}
