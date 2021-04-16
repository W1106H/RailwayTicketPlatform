/*
 * Created by JFormDesigner on Thu Apr 15 21:22:23 CST 2021
 */

package cn.lanqiao.ui;

import java.awt.event.*;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.PassengerService;
import cn.lanqiao.service.UserService;
import cn.lanqiao.service.impl.PassengerServiceImpl;
import cn.lanqiao.service.impl.UserServiceImpl;
import cn.lanqiao.util.TelMathches;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class AlterUserTelJDialog extends JDialog {
    public User currentUser = null;
    public AlterUserTelJDialog(User user) {
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
        String UTel = AlteruTelTextField.getText().trim();
        UserService userService = new UserServiceImpl();
        boolean uTelMatches = TelMathches.judgeLegal(UTel);
        if (uTelMatches) {
            int result = userService.updateUTel(UTel, currentUser.getUserId());
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "修改成功！");
                AlteruTelTextField.setText(null);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "该电话号码已被其他乘客绑定！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "电话号码输入格式错误！");
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        AlteruTelTextField = new JTextField();
        sureButton = new JButton();
        cancleButton = new JButton();

        //======== this ========
        setBackground(new Color(102, 102, 255));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 255));
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u8bf7\u8f93\u5165\u65b0\u7684\u7535\u8bdd\u53f7\u7801");
            label1.setBackground(Color.white);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
            label1.setForeground(Color.white);
            panel1.add(label1);
            label1.setBounds(30, 70, 180, 30);
            panel1.add(AlteruTelTextField);
            AlteruTelTextField.setBounds(25, 30, 200, AlteruTelTextField.getPreferredSize().height);

            //---- sureButton ----
            sureButton.setText("\u786e\u5b9a\u4fee\u6539");
            sureButton.setFont(sureButton.getFont().deriveFont(sureButton.getFont().getStyle() | Font.BOLD));
            sureButton.setBackground(Color.white);
            sureButton.addActionListener(e -> sureButtonActionPerformed(e));
            panel1.add(sureButton);
            sureButton.setBounds(130, 145, 105, 30);

            //---- cancleButton ----
            cancleButton.setText("\u53d6\u6d88");
            cancleButton.setBackground(Color.white);
            cancleButton.setFont(cancleButton.getFont().deriveFont(cancleButton.getFont().getStyle() | Font.BOLD));
            cancleButton.addActionListener(e -> cancleButtonActionPerformed(e));
            panel1.add(cancleButton);
            cancleButton.setBounds(20, 145, 85, 30);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 265, 190);

        contentPane.setPreferredSize(new Dimension(265, 220));
        setSize(265, 220);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField AlteruTelTextField;
    private JButton sureButton;
    private JButton cancleButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
