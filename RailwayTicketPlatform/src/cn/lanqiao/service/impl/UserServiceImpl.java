package cn.lanqiao.service.impl;

import cn.lanqiao.dao.impl.UserDaoImpl;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.UserService;
import cn.lanqiao.util.TelMathches;
import cn.lanqiao.util.EmailMatches;
import cn.lanqiao.util.IdMatches;

/**
 * @author moqirun
 * @date 2021/4/14 20:15
 **/
public class UserServiceImpl implements UserService {
    private cn.lanqiao.dao.UserDao userDao = null;
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String uname, String upassword) {
        User currentUser = userDao.getUser(uname);
        if(currentUser!=null){
            if(currentUser.getUPassword().equals(upassword)){
                return  currentUser;
            }
        }
        return null;
    }

    @Override
    public int[] addUser(User user) {
        int[] result = new int[7];
        boolean userIdMatches = IdMatches.judgeLegal(user.getUserId());
        boolean uEmailMatches = EmailMatches.judgeLegal(user.getUEmail());
        boolean uTelMatches = TelMathches.judgeLegal(user.getUTel());
        if (userIdMatches && uEmailMatches && uTelMatches) {
            User isFindUserId = userDao.getUser(user.getUserId());
            User isFindUName = userDao.getUser(user.getUName());
            User isFindUTel = userDao.getUser(user.getUTel());
            if (isFindUserId!=null) {
                result[4] = 1;
            }
            if (isFindUName!=null) {
                result[5] = 1;
            }
            if (isFindUTel!=null) {
                result[6] = 1;
            }
            result[3] = userDao.addUser(user);
        } else {
            if (!userIdMatches) {
                result[0] = 1;
            }
            if (!uEmailMatches) {
                result[1]=1;
            }
            if (uTelMatches) {
                result[2] = 1;
            }
        }
        return result;
    }

    @Override
    public int deleteUserByUserId(String userid) {
        return userDao.deleteUser(userid);
    }

    @Override
    public int updateUTel(String utel, String userid) {
        return userDao.updateUTel(utel, userid);
    }

    @Override
    public int updateUPassword(String password, String userid) {
        return userDao.updateUPassword(password,userid);
    }
}
