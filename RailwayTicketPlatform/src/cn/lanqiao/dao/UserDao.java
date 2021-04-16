package cn.lanqiao.dao;

import cn.lanqiao.entity.Peoples.User;

/**
 * @author moqirun
 * @date 2021/4/12 17:48
 **/
public interface UserDao {
    public User getUser(String uname);

    public int addUser(User user);

    public int deleteUser(String utel);

    public int updateUPassword(String upassword, String userid);

    public int updateUTel(String utel, String userid);
}
