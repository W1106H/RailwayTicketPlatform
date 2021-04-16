/*
 * Created by JFormDesigner on Thu Apr 15 21:53:50 CST 2021
 */

package cn.lanqiao.ui;

import java.awt.event.*;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.UserService;
import cn.lanqiao.service.impl.UserServiceImpl;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class AlterUPasswordJDialog extends JDialog {
    public User currentUser = null;
    public AlterUPasswordJDialog(User user) {
        this.currentUser = user;
        initComponents();
    }

    private void cancleButtonActionPerformed(ActionEvent e) {
        // 取消
        this.dispose();
    }

    private void sureButtonActionPerformed(ActionEvent e) {
        // 确定修改
        if (currentUser == null) {
            return;
        }
        String OriginalUPassword = OrginorTextField.getText().trim();
        String NewPassword = NewPwdTextField.getText().trim();
        if (OriginalUPassword.equals("")) {
            JOptionPane.showMessageDialog(null, "请输入原密码！");
            return;
        }
        if (NewPassword .equals("")) {
            JOptionPane.showMessageDialog(null, "请输入新密码！");
            return;
        }
        UserService userService = new UserServiceImpl();
        if (OriginalUPassword.equals(currentUser.getUPassword())) {
            int result = userService.updateUPassword(NewPassword, currentUser.getUserId());
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "修改成功！");
                OrginorTextField.setText(null);
                NewPwdTextField.setText(null);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "原密码输入错误！请从新输入！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        OrginorTextField = new JTextField();
        NewPwdTextField = new JTextField();
        sureButton = new JButton();
        cancleButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 255));
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u539f\u5bc6\u7801\uff1a");
            label1.setForeground(Color.white);
            panel1.add(label1);
            label1.setBounds(5, 35, 65, 30);

            //---- label2 ----
            label2.setText("\u65b0\u5bc6\u7801\uff1a");
            label2.setForeground(Color.white);
            panel1.add(label2);
            label2.setBounds(5, 90, 65, 30);
            panel1.add(OrginorTextField);
            OrginorTextField.setBounds(80, 35, 170, 30);
            panel1.add(NewPwdTextField);
            NewPwdTextField.setBounds(80, 90, 170, 30);

            //---- sureButton ----
            sureButton.setText("\u786e\u8ba4");
            sureButton.setFont(sureButton.getFont().deriveFont(sureButton.getFont().getStyle() | Font.BOLD));
            sureButton.setBackground(Color.white);
            sureButton.addActionListener(e -> sureButtonActionPerformed(e));
            panel1.add(sureButton);
            sureButton.setBounds(170, 190, 80, 30);

            //---- cancleButton ----
            cancleButton.setText("\u53d6\u6d88");
            cancleButton.setFont(cancleButton.getFont().deriveFont(cancleButton.getFont().getStyle() | Font.BOLD));
            cancleButton.setBackground(Color.white);
            cancleButton.addActionListener(e -> cancleButtonActionPerformed(e));
            panel1.add(cancleButton);
            cancleButton.setBounds(75, 190, 80, 30);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 285, 235);

        contentPane.setPreferredSize(new Dimension(285, 265));
        setSize(285, 265);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField OrginorTextField;
    private JTextField NewPwdTextField;
    private JButton sureButton;
    private JButton cancleButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
