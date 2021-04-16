/*
 * Created by JFormDesigner on Thu Apr 15 11:57:04 CST 2021
 */

package cn.lanqiao.ui;

import cn.lanqiao.entity.Peoples.User;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class SettingJDialog extends JDialog {
    public User currentUser = null;
    public SettingJDialog(User user) {
        this.currentUser = user;
        initComponents();
    }

    private void OutButtonActionPerformed(ActionEvent e) {
        // 退出登录
        System.exit(0);
    }

    private void PersonalInformationButtonActionPerformed(ActionEvent e) {
        // 个人信息
        if (currentUser == null) {
            return;
        }
        new PersonalInformation(currentUser).setVisible(true);
    }

    private void LogoutButtonActionPerformed(ActionEvent e) {
        // 注销
        System.exit(0);
    }

    private void AboutButtonActionPerformed(ActionEvent e) {
        // 关于
        JOptionPane.showMessageDialog(null, "我是你永远得不到的爸爸！");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        layeredPane1 = new JLayeredPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        OutButton = new JButton();
        PersonalInformationButton = new JButton();
        LogoutButton = new JButton();
        AboutButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== layeredPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setBackground(new Color(102, 102, 255));
                panel1.setLayout(null);

                //---- label1 ----
                label1.setText("\u8bbe\u7f6e");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
                label1.setBackground(Color.white);
                label1.setForeground(Color.white);
                panel1.add(label1);
                label1.setBounds(150, 10, 75, 25);
            }
            layeredPane1.add(panel1, JLayeredPane.DEFAULT_LAYER);
            panel1.setBounds(0, 0, 376, 50);

            //---- OutButton ----
            OutButton.setText("\u9000\u51fa\u767b\u5f55");
            OutButton.setFont(OutButton.getFont().deriveFont(OutButton.getFont().getStyle() | Font.BOLD));
            OutButton.setForeground(Color.white);
            OutButton.setBackground(new Color(102, 102, 255));
            OutButton.addActionListener(e -> OutButtonActionPerformed(e));
            layeredPane1.add(OutButton, JLayeredPane.DEFAULT_LAYER);
            OutButton.setBounds(30, 335, 305, 30);

            //---- PersonalInformationButton ----
            PersonalInformationButton.setText("\u4e2a\u4eba\u4fe1\u606f");
            PersonalInformationButton.setHorizontalAlignment(SwingConstants.LEFT);
            PersonalInformationButton.setFont(PersonalInformationButton.getFont().deriveFont(PersonalInformationButton.getFont().getStyle() | Font.BOLD));
            PersonalInformationButton.setBackground(Color.white);
            PersonalInformationButton.addActionListener(e -> PersonalInformationButtonActionPerformed(e));
            layeredPane1.add(PersonalInformationButton, JLayeredPane.DEFAULT_LAYER);
            PersonalInformationButton.setBounds(0, 70, 375, 30);

            //---- LogoutButton ----
            LogoutButton.setText("\u6ce8\u9500");
            LogoutButton.setFont(LogoutButton.getFont().deriveFont(LogoutButton.getFont().getStyle() | Font.BOLD));
            LogoutButton.setHorizontalAlignment(SwingConstants.LEFT);
            LogoutButton.setBackground(Color.white);
            LogoutButton.addActionListener(e -> LogoutButtonActionPerformed(e));
            layeredPane1.add(LogoutButton, JLayeredPane.DEFAULT_LAYER);
            LogoutButton.setBounds(0, 120, 375, 30);

            //---- AboutButton ----
            AboutButton.setText("\u5173\u4e8e");
            AboutButton.setHorizontalAlignment(SwingConstants.LEFT);
            AboutButton.setFont(AboutButton.getFont().deriveFont(AboutButton.getFont().getStyle() | Font.BOLD));
            AboutButton.setBackground(Color.white);
            AboutButton.addActionListener(e -> AboutButtonActionPerformed(e));
            layeredPane1.add(AboutButton, JLayeredPane.DEFAULT_LAYER);
            AboutButton.setBounds(0, 170, 375, 30);
        }
        contentPane.add(layeredPane1);
        layeredPane1.setBounds(0, 0, 375, 390);

        contentPane.setPreferredSize(new Dimension(375, 420));
        setSize(375, 420);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLayeredPane layeredPane1;
    private JPanel panel1;
    private JLabel label1;
    private JButton OutButton;
    private JButton PersonalInformationButton;
    private JButton LogoutButton;
    private JButton AboutButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
