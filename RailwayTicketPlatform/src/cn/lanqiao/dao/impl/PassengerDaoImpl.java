package cn.lanqiao.dao.impl;

import cn.lanqiao.dao.PassengerDao;
import cn.lanqiao.entity.Peoples.Passenger;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author moqirun
 * @date 2021/4/12 19:04
 **/
public class PassengerDaoImpl implements PassengerDao {
    @Override
    public Passenger getPassenger(String passengerid) {
        Passenger passenger = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from passengrs where passenger=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,passengerid);
            rs = ps.executeQuery();
            if (rs.next()) {
                String PassengerId = rs.getString("passengerid");
                String PName = rs.getString("pname");
                String PTel = rs.getString("ptel");
                String PId = rs.getString("pid");
                String PGender = rs.getString("pgender");
                passenger = new Passenger(PassengerId, PName, PTel, PId, PGender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return passenger;
    }

    @Override
    public int addPassenger(Passenger passenger) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection = JDBCUtil.getConnection();
            String sql="insert into passengers values (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passenger.getPassengerId());
            preparedStatement.setString(2, passenger.getPName());
            preparedStatement.setString(3, passenger.getPTel());
            preparedStatement.setString(4,passenger.getPGender());
            preparedStatement.setString(5,passenger.getPId());
            return preparedStatement.executeUpdate();
        }catch (Exception e){}
        finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
        return 0;
    }

    @Override
    public int deletePassenger(String passengerid) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection = JDBCUtil.getConnection();
            String sql="delete  from  passengers where passengerid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passengerid);
            return preparedStatement.executeUpdate();
        }catch (Exception e){}
        finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
        return 0;
    }

    public int count() {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        int number = 0;
        try {
            ps = connection.prepareStatement("select  count(*) from passengers where pid=?");
            rs = ps.executeQuery();
            if(rs.next()){
                number = rs.getInt(1);
            }

        }catch (Exception e){
        }finally {JDBCUtil.close(rs,ps,connection);}
        return number;
    }

    public Object[][] list() {
        Object[][] passengers = null;
        Connection connection = JDBCUtil.getConnection();
        String sql="select * from passengers where pid=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        passengers = new Object[this.count()][];
        try{
            preparedStatement =connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int i=0;
            while (resultSet.next()){
                String PassengerId = resultSet.getString("passengerid");
                String PName = resultSet.getString("pname");
                String PTel = resultSet.getString("ptel");
                String PGender = resultSet.getString("pgender");
                String PId = resultSet.getString("pid");
                passengers[i] = new Object[]{PassengerId,PName,PTel,PGender,PId};
                i++;
            }

        }catch (Exception e){}
        finally { JDBCUtil.close(resultSet,preparedStatement,connection);}
        return passengers;
    }

    public int updatePassenger(String ptel, String passengerid) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection = JDBCUtil.getConnection();
            String sql="update passengers set ptel=? where passengerid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,ptel);
            preparedStatement.setString(2,passengerid);
            return preparedStatement.executeUpdate();
        }catch (Exception e){}
        finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
        return 0;
    }
}
