/*
 * Created by JFormDesigner on Wed Apr 14 23:37:44 CST 2021
 */

package cn.lanqiao.ui;

import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.UserService;
import cn.lanqiao.service.impl.UserServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.util.UUID;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class AddUserJDialog extends JDialog {
    public AddUserJDialog() {
        //super(owner);
        initComponents();
    }

    private void RegisterButtonActionPerformed(ActionEvent e) {
        // 注册
        String PId = UUID.randomUUID().toString();
        String UName = unameTextField.getText();
        String UPassword = passwordTextField.getText();
        String UserId = useridTextField.getText();
        String UReallName = ureallnameTextField.getText();
        String UGender=nanRadioButton.isSelected()? "男" : "女";
        String UAddress = uaddressTextField.getText();
        String UEmail = uemailTextField.getText();
        String UTel = utelTextField.getText();


        UserService userService = new UserServiceImpl();
        User user = new User(UTel, UserId, UReallName, UGender, UEmail, UAddress, UName, UPassword, PId);
        int result[] = userService.addUser(user);
        if (result[3] > 0) {
            //对窗体相关组件数据初使化;
            JOptionPane.showMessageDialog(null, "注册成功！");
            unameTextField.setText(null);
            passwordTextField.setText(null);
            useridTextField.setText(null);
            ureallnameTextField.setText(null);
            uaddressTextField.setText(null);
            uemailTextField.setText(null);
            utelTextField.setText(null);
            nanRadioButton.setSelected(false);
            nvRadioButton.setSelected(false);
            this.dispose();
        } else {
            if (result[0] == 1) {
                JOptionPane.showMessageDialog(null, "身份证号输入格式错误！！");
            }else if (result[1] == 1) {
                JOptionPane.showMessageDialog(null,"邮箱输入格式错误！");
            }else if (result[2] == 1) {
                JOptionPane.showMessageDialog(null,"电话号码输入格式错误！");
            } else if (result[4] == 1) {
                JOptionPane.showMessageDialog(null,"该身份证号已被注册！");
            } else if (result[5] == 1) {
                JOptionPane.showMessageDialog(null,"该电话号码已被注册！");
            } else if(result[6] == 1){
                JOptionPane.showMessageDialog(null,"该用户名已被使用！请使用另外的用户名注册！");
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        unameTextField = new JTextField();
        passwordTextField = new JTextField();
        useridTextField = new JTextField();
        ureallnameTextField = new JTextField();
        uemailTextField = new JTextField();
        uaddressTextField = new JTextField();
        utelTextField = new JTextField();
        nanRadioButton = new JRadioButton();
        nvRadioButton = new JRadioButton();
        RegisterButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        contentPane.add(label1);
        label1.setBounds(20, 15, 50, 30);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));
        contentPane.add(label2);
        label2.setBounds(20, 55, 50, 30);

        //---- label3 ----
        label3.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));
        contentPane.add(label3);
        label3.setBounds(20, 95, 80, 30);

        //---- label4 ----
        label4.setText("\u6027\u522b\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD));
        contentPane.add(label4);
        label4.setBounds(20, 135, 50, 30);

        //---- label5 ----
        label5.setText("\u771f\u5b9e\u59d3\u540d\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD));
        contentPane.add(label5);
        label5.setBounds(20, 175, 80, 30);

        //---- label6 ----
        label6.setText("\u90ae\u7bb1\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD));
        contentPane.add(label6);
        label6.setBounds(20, 215, 50, 30);

        //---- label7 ----
        label7.setText("\u5730\u5740\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD));
        contentPane.add(label7);
        label7.setBounds(20, 255, 50, 30);

        //---- label8 ----
        label8.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD));
        contentPane.add(label8);
        label8.setBounds(20, 295, 80, 30);

        //---- unameTextField ----
        unameTextField.setNextFocusableComponent(nvRadioButton);
        contentPane.add(unameTextField);
        unameTextField.setBounds(105, 15, 210, unameTextField.getPreferredSize().height);
        contentPane.add(passwordTextField);
        passwordTextField.setBounds(105, 55, 210, passwordTextField.getPreferredSize().height);
        contentPane.add(useridTextField);
        useridTextField.setBounds(105, 95, 210, useridTextField.getPreferredSize().height);
        contentPane.add(ureallnameTextField);
        ureallnameTextField.setBounds(105, 175, 210, ureallnameTextField.getPreferredSize().height);
        contentPane.add(uemailTextField);
        uemailTextField.setBounds(105, 215, 210, uemailTextField.getPreferredSize().height);
        contentPane.add(uaddressTextField);
        uaddressTextField.setBounds(105, 255, 210, uaddressTextField.getPreferredSize().height);
        contentPane.add(utelTextField);
        utelTextField.setBounds(105, 295, 210, utelTextField.getPreferredSize().height);

        //---- nanRadioButton ----
        nanRadioButton.setText("\u7537");
        nanRadioButton.setSelected(true);
        nanRadioButton.setFont(nanRadioButton.getFont().deriveFont(nanRadioButton.getFont().getStyle() | Font.BOLD));
        nanRadioButton.setNextFocusableComponent(null);
        contentPane.add(nanRadioButton);
        nanRadioButton.setBounds(110, 140, 45, nanRadioButton.getPreferredSize().height);

        //---- nvRadioButton ----
        nvRadioButton.setText("\u5973");
        nvRadioButton.setFont(nvRadioButton.getFont().deriveFont(nvRadioButton.getFont().getStyle() | Font.BOLD));
        nvRadioButton.setNextFocusableComponent(null);
        contentPane.add(nvRadioButton);
        nvRadioButton.setBounds(195, 140, 45, nvRadioButton.getPreferredSize().height);

        //---- RegisterButton ----
        RegisterButton.setText("\u6ce8\u518c");
        RegisterButton.setBackground(Color.blue);
        RegisterButton.setForeground(Color.white);
        RegisterButton.addActionListener(e -> RegisterButtonActionPerformed(e));
        contentPane.add(RegisterButton);
        RegisterButton.setBounds(235, 330, 80, 30);

        contentPane.setPreferredSize(new Dimension(345, 400));
        setSize(345, 400);
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(nanRadioButton);
        buttonGroup1.add(nvRadioButton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField unameTextField;
    private JTextField passwordTextField;
    private JTextField useridTextField;
    private JTextField ureallnameTextField;
    private JTextField uemailTextField;
    private JTextField uaddressTextField;
    private JTextField utelTextField;
    private JRadioButton nanRadioButton;
    private JRadioButton nvRadioButton;
    private JButton RegisterButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
