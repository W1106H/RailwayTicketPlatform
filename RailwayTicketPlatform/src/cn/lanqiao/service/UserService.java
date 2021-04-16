package cn.lanqiao.service;

import cn.lanqiao.entity.Peoples.User;

/**
 * @author moqirun
 * @date 2021/4/14 20:13
 **/
public interface UserService {
    public User login(String uname, String upassword);

    public int[] addUser(User user);

    public int deleteUserByUserId(String userid);

    public int updateUTel(String utel, String userid);

    public int updateUPassword(String password, String userid);

}
