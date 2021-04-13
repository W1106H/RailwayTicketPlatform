package cn.lanqiao.dao.impl;

import cn.lanqiao.dao.UserDao;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author moqirun
 * @date 2021/4/12 17:51
 **/
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
    }

    @Override
    public User getUser(String uname) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from users where uname=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,uname);
            rs = ps.executeQuery();
            if (rs.next()) {
                String UTel = rs.getString("utel");
                String UserId = rs.getString("userid");
                String URealName = rs.getString("urealname");
                String UGender = rs.getString("ugender");
                String UEmail = rs.getString("uemail");
                String UAddress = rs.getString("uaddress");
                String UName = rs.getString("uname");
                String UPassword = rs.getString("upassword");
                String PId = rs.getString("pid");
                user = new User(UTel,UserId, URealName, UGender,UEmail, UAddress, UName, UPassword,PId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, ps, conn);
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection = JDBCUtil.getConnection();
            String sql="insert into users values (?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUTel());
            preparedStatement.setString(2,user.getUserId());
            preparedStatement.setString(3,user.getURealName());
            preparedStatement.setString(4,user.getUGender());
            preparedStatement.setString(5,user.getUEmail());
            preparedStatement.setString(6,user.getUAddress());
            preparedStatement.setString(7,user.getUName());
            preparedStatement.setString(8,user.getUPassword());
            preparedStatement.setString(9, user.getPId());
            return preparedStatement.executeUpdate();
        }catch (Exception e){}
        finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
        return 0;
    }

    @Override
    public int deleteUser(String userid) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection = JDBCUtil.getConnection();
            String sql="delete  from  users where userid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userid);
            return preparedStatement.executeUpdate();
        }catch (Exception e){}
        finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
        return 0;
    }

    public int updateUser(String utel, String userid) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection = JDBCUtil.getConnection();
            String sql="update users set utel=? where userid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,utel);
            preparedStatement.setString(2,userid);
            return preparedStatement.executeUpdate();
        }catch (Exception e){}
        finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
        return 0;
    }

}
