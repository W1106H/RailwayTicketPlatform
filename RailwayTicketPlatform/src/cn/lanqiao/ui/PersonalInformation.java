/*
 * Created by JFormDesigner on Thu Apr 15 12:19:37 CST 2021
 */

package cn.lanqiao.ui;

import java.awt.event.*;
import cn.lanqiao.entity.Peoples.User;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class PersonalInformation extends JDialog {
    public User currentUser = null;
    public PersonalInformation(User user) {
        this.currentUser = user;
        initComponents();
    }

    private void PersonalAlterButtonActionPerformed(ActionEvent e) {
        // 修改个人信息，这里只允许修改密码和电话号码
        if (currentUser == null) {
            return;
        }
        new PersonalInformationAlter(currentUser).setVisible(true);
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
        upasswordTextField = new JTextField();
        useridTextField = new JTextField();
        ugenderTextField = new JTextField();
        ureallnameTextField = new JTextField();
        uaddressTextField = new JTextField();
        umailTextField = new JTextField();
        utelTextField = new JTextField();
        PersonalAlterButton = new JButton();
        panel1 = new JPanel();
        label9 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        contentPane.add(label1);
        label1.setBounds(15, 65, 80, 30);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));
        contentPane.add(label2);
        label2.setBounds(15, 105, 80, 30);

        //---- label3 ----
        label3.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));
        contentPane.add(label3);
        label3.setBounds(15, 145, 80, 30);

        //---- label4 ----
        label4.setText("\u6027\u522b\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD));
        contentPane.add(label4);
        label4.setBounds(15, 185, 80, 30);

        //---- label5 ----
        label5.setText("\u771f\u5b9e\u59d3\u540d\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD));
        contentPane.add(label5);
        label5.setBounds(15, 225, 80, 30);

        //---- label6 ----
        label6.setText("\u5730\u5740\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD));
        contentPane.add(label6);
        label6.setBounds(15, 265, 80, 30);

        //---- label7 ----
        label7.setText("\u90ae\u7bb1\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD));
        contentPane.add(label7);
        label7.setBounds(15, 305, 80, 30);

        //---- label8 ----
        label8.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD));
        contentPane.add(label8);
        label8.setBounds(10, 345, 80, 30);

        //---- unameTextField ----
        unameTextField.setEditable(false);
        contentPane.add(unameTextField);
        unameTextField.setBounds(110, 65, 225, 30);

        //---- upasswordTextField ----
        upasswordTextField.setEditable(false);
        contentPane.add(upasswordTextField);
        upasswordTextField.setBounds(110, 105, 225, 30);

        //---- useridTextField ----
        useridTextField.setEditable(false);
        contentPane.add(useridTextField);
        useridTextField.setBounds(110, 145, 225, 30);

        //---- ugenderTextField ----
        ugenderTextField.setEditable(false);
        contentPane.add(ugenderTextField);
        ugenderTextField.setBounds(110, 185, 225, 30);

        //---- ureallnameTextField ----
        ureallnameTextField.setEditable(false);
        contentPane.add(ureallnameTextField);
        ureallnameTextField.setBounds(110, 225, 225, 30);

        //---- uaddressTextField ----
        uaddressTextField.setEditable(false);
        contentPane.add(uaddressTextField);
        uaddressTextField.setBounds(110, 265, 225, 30);

        //---- umailTextField ----
        umailTextField.setEditable(false);
        contentPane.add(umailTextField);
        umailTextField.setBounds(110, 305, 225, 30);

        //---- utelTextField ----
        utelTextField.setEditable(false);
        contentPane.add(utelTextField);
        utelTextField.setBounds(110, 345, 225, 30);

        //---- PersonalAlterButton ----
        PersonalAlterButton.setText("\u4fee\u6539");
        PersonalAlterButton.setFont(PersonalAlterButton.getFont().deriveFont(PersonalAlterButton.getFont().getStyle() | Font.BOLD));
        PersonalAlterButton.setForeground(Color.white);
        PersonalAlterButton.setBackground(new Color(102, 102, 255));
        PersonalAlterButton.addActionListener(e -> PersonalAlterButtonActionPerformed(e));
        contentPane.add(PersonalAlterButton);
        PersonalAlterButton.setBounds(255, 385, 80, 30);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 255));
            panel1.setLayout(null);

            //---- label9 ----
            label9.setText("\u4e2a\u4eba\u8d44\u6599");
            label9.setForeground(Color.white);
            label9.setHorizontalAlignment(SwingConstants.CENTER);
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD));
            panel1.add(label9);
            label9.setBounds(135, 15, 85, 30);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 354, 60);

        contentPane.setPreferredSize(new Dimension(355, 455));
        setSize(355, 455);
        setLocationRelativeTo(getOwner());
        init();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    //初始化个信息
    private void init() {
        unameTextField.setText(currentUser.getUName());
        upasswordTextField.setText(currentUser.getUPassword());
        useridTextField.setText(currentUser.getUserId());
        ureallnameTextField.setText(currentUser.getURealName());
        ugenderTextField.setText(currentUser.getUGender());
        uaddressTextField.setText(currentUser.getUGender());
        umailTextField.setText(currentUser.getUEmail());
        utelTextField.setText(currentUser.getUTel());
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
    private JTextField upasswordTextField;
    private JTextField useridTextField;
    private JTextField ugenderTextField;
    private JTextField ureallnameTextField;
    private JTextField uaddressTextField;
    private JTextField umailTextField;
    private JTextField utelTextField;
    private JButton PersonalAlterButton;
    private JPanel panel1;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
