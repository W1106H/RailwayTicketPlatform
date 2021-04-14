package cn.lanqiao.dao.impl;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.entity.Peoples.Orders;
import cn.lanqiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class OrderDaoImpl implements OrderDao {
    private boolean orderAlreadyPayFlag = false;

    @Override
    public Object[][] getOrderAlreadyPay(String userPID,int currentPage) {
        Object[][] orderAlreadyPay = null;
//        第一步：获得连接
        Connection connection = JDBCUtil.getConnection();
        int startIndex=(currentPage-1) *2 + 1;
        int endIndex=currentPage*2;
        String sql = "select * " +
                "from " +
                "    (select table1.*,ROWNUM rn " +
                "    from\n" +
                "        (select o.order_no,o.train_no,tps1.station_name as startStationName,tps2.station_name as arriveStationName,o.train_start_time,o.sumprice,p.pname " +
                "        from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                "        where o.order_creator = '1001' " +
                "            and o.visual = 'T' " +
                "            and o.train_no = tps1.train_num " +
                "            and o.train_no = tps2.train_num " +
                "            and o.station_start_no = tps1.station_order " +
                "            and o.station_end_no = tps2.station_order " +
                "            and tps1.train_num = tps2.train_num " +
                "            and o.train_start_time = tps1.start_time " +
                "            and o.train_end_time = tps2.arrive_time " +
                "            and o.order_state = 'T' " +
                "            and o.PID = p.passengerID " +
                "        ORDER BY train_start_time DESC) table1) table2 " +
                "where rn between "+startIndex+" and "+endIndex;
        PreparedStatement pr = null;
        ResultSet rs = null;
        orderAlreadyPay = new Object[this.getOrderAlreadyPay_Count(userPID)][];
        try {
            pr = connection.prepareStatement(sql);
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

    @Override
    public int getOrderAlreadyPay_Count(String userPID) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int number = 0;
        try {
            String sql = "select count(*) " +
                    "from orders o,passengers p,train_parking_station tps1,train_parking_station tps2 " +
                    "where o.order_creator = " + userPID + " " +
                    "    and o.visual = 'T' " +
                    "    and o.train_no = tps1.train_num " +
                    "    and o.train_no = tps2.train_num " +
                    "    and o.station_start_no = tps1.station_order " +
                    "    and o.station_end_no = tps2.station_order " +
                    "    and tps1.train_num = tps2.train_num " +
                    "    and o.train_start_time = tps1.start_time " +
                    "    and o.train_end_time = tps2.arrive_time" +
                    "    and o.order_state = 'T' " +
                    "    and o.PID = p.passengerId " +
                    "ORDER BY train_start_time DESC " ;
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

    @Override
    public Orders getDetailOrder(String orderNo) {
        Orders orders = null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select o.order_no,o.PID,o.train_no,o.train_start_time,o.train_end_time,tps1.station_name as start_station,tps2.station_name as arrive_station,o.carriage_no,o.seat_no,s.seat_type,ot.type,o.order_state,o.sumprice,p.pname " +
                    "from orders o,order_type ot,train_parking_station tps1,train_parking_station tps2,seat s,passengers p " +
                    "where o.order_no = " + orderNo + " " +
                    "    and o.train_no = tps1.train_num " +
                    "    and o.train_no = tps2.train_num " +
                    "    and o.station_start_no = tps1.station_order " +
                    "    and o.station_end_no = tps2.station_order " +
                    "    and o.train_start_time = tps1.start_Time " +
                    "    and o.train_end_time = tps2.arrive_Time " +
                    "    and o.order_type = ot.id " +
                    "    and o.train_no = s.train_num " +
                    "    and o.carriage_no = s.carriage_num " +
                    "    and o.pid = p.passengerId";
            ps = connection.prepareStatement(sql);
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
                orders = new Orders(order_no,PID,train_no,train_start_Date,train_end_Date,start_station,arrive_station,carriage_no,seat_no,seat_type,order_state,sumprice,order_type,train_start_time,train_end_time,passengerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,connection);
        }
        return orders;
    }

    public void setOrderAlreadyPayFlag(boolean orderAlreadyPayFlag) {
        this.orderAlreadyPayFlag = orderAlreadyPayFlag;
    }

    public boolean isOrderAlreadyPayFlag() {
        return orderAlreadyPayFlag;
    }
}
