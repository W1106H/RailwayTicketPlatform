package cn.lanqiao.ui;

import cn.lanqiao.entity.Peoples.User;

import javax.swing.*;
import java.text.NumberFormat;

/**
 * @author moqirun
 * @date 2021/4/14 21:02
 **/
public class Test {
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        if (LoginForm.currentUser == null) {
            loginForm.setVisible(true);
        }
    }
}
