/*
 * Created by JFormDesigner on Thu Apr 15 16:12:38 CST 2021
 */

package cn.lanqiao.ui;

import java.awt.event.*;

import cn.lanqiao.dao.PassengerDao;
import cn.lanqiao.entity.Peoples.Passenger;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.PassengerService;
import cn.lanqiao.service.UserService;
import cn.lanqiao.service.impl.PassengerServiceImpl;
import cn.lanqiao.service.impl.UserServiceImpl;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class AddPassengerJDialog extends JDialog {
    public User currentUser = null;
    public AddPassengerJDialog(User user) {
        this.currentUser = user;
        initComponents();
    }

    private void AddPassengerButtonActionPerformed(ActionEvent e) {
        // 添加
        if (currentUser == null) {
            return;
        }

        String PId = currentUser.getPId();
        String PName = PnameTextField.getText();
        String PassengerId = PassengerIdTextField.getText();
        String PTel = PtelTextField.getText();
        String PGender =nanRadioButton.isSelected()? "男" : "女";

        PassengerService passengerService = new PassengerServiceImpl();
        Passenger passenger = new Passenger(PassengerId, PName, PTel, PId, PGender);
        int result[] = passengerService.addPassenger(passenger);
        if (result[2] > 0) {
            //对窗体相关组件数据初使化;
            JOptionPane.showMessageDialog(null, "添加成功！");
            PnameTextField.setText(null);
            PassengerIdTextField.setText(null);
            PtelTextField.setText(null);
            nanRadioButton.setSelected(false);
            nvRadioButton.setSelected(false);
            this.dispose();
        } else {
            if (result[0] == 1) {
                JOptionPane.showMessageDialog(null, "身份证号输入格式错误！！");
            }else if (result[1] == 1) {
                JOptionPane.showMessageDialog(null,"电话号码输入格式错误！");
            }else if (result[3] == 1) {
                JOptionPane.showMessageDialog(null,"该身份证号已在当前用户列表下！");
            } else if (result[4] == 1) {
                JOptionPane.showMessageDialog(null,"该电话号码已被其他乘客绑定！");
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
        PgenderLabel = new JLabel();
        PnameTextField = new JTextField();
        PassengerIdTextField = new JTextField();
        PtelTextField = new JTextField();
        AddPassengerButton = new JButton();
        nvRadioButton = new JRadioButton();
        nanRadioButton = new JRadioButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u59d3\u540d\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        contentPane.add(label1);
        label1.setBounds(20, 15, 80, 30);

        //---- label2 ----
        label2.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));
        contentPane.add(label2);
        label2.setBounds(20, 70, 80, 30);

        //---- label3 ----
        label3.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));
        contentPane.add(label3);
        label3.setBounds(20, 130, 80, 30);

        //---- PgenderLabel ----
        PgenderLabel.setText("\u6027\u522b\uff1a");
        PgenderLabel.setFont(PgenderLabel.getFont().deriveFont(PgenderLabel.getFont().getStyle() | Font.BOLD));
        contentPane.add(PgenderLabel);
        PgenderLabel.setBounds(20, 190, 80, 30);
        contentPane.add(PnameTextField);
        PnameTextField.setBounds(105, 15, 240, 30);
        contentPane.add(PassengerIdTextField);
        PassengerIdTextField.setBounds(105, 70, 240, 30);
        contentPane.add(PtelTextField);
        PtelTextField.setBounds(105, 130, 240, 30);

        //---- AddPassengerButton ----
        AddPassengerButton.setText("\u6dfb\u52a0");
        AddPassengerButton.setFont(AddPassengerButton.getFont().deriveFont(AddPassengerButton.getFont().getStyle() | Font.BOLD));
        AddPassengerButton.setBackground(new Color(102, 102, 255));
        AddPassengerButton.setForeground(Color.white);
        AddPassengerButton.addActionListener(e -> AddPassengerButtonActionPerformed(e));
        contentPane.add(AddPassengerButton);
        AddPassengerButton.setBounds(270, 240, 80, 30);

        //---- nvRadioButton ----
        nvRadioButton.setText("\u7537");
        nvRadioButton.setFont(nvRadioButton.getFont().deriveFont(nvRadioButton.getFont().getStyle() | Font.BOLD));
        contentPane.add(nvRadioButton);
        nvRadioButton.setBounds(110, 190, 60, 30);

        //---- nanRadioButton ----
        nanRadioButton.setText("\u5973");
        nanRadioButton.setFont(nanRadioButton.getFont().deriveFont(nanRadioButton.getFont().getStyle() | Font.BOLD));
        contentPane.add(nanRadioButton);
        nanRadioButton.setBounds(180, 190, 60, 30);

        contentPane.setPreferredSize(new Dimension(375, 320));
        setSize(375, 320);
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(nvRadioButton);
        buttonGroup1.add(nanRadioButton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel PgenderLabel;
    private JTextField PnameTextField;
    private JTextField PassengerIdTextField;
    private JTextField PtelTextField;
    private JButton AddPassengerButton;
    private JRadioButton nvRadioButton;
    private JRadioButton nanRadioButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
