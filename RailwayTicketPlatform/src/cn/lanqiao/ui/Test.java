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
        User user = null;
        LoginForm loginForm = new LoginForm();
        if (LoginForm.currentUser == null) {

            loginForm.setVisible(true);
        }
        // new PersonalForm(user).setVisible(true);
        //new SettingJDialog(user).setVisible(true);
        //new PersonalInformaion().setVisible(true);

        //new AddPassengerJDialog(user).setVisible(true);

        JTable jTable = null;
        //new PassengerJDialog(user).setVisible(true);
        //new AlterPTelJDialog(jTable,user).setVisible(true);
//new PersonalInformationAlter(user).setVisible(true);
       // new AlterUserTelJDialog(user).setVisible(true);
        //new AlterUPasswordJDialog(user).setVisible(true);
    }
}
