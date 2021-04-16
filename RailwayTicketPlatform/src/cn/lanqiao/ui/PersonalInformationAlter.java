/*
 * Created by JFormDesigner on Thu Apr 15 14:25:07 CST 2021
 */

package cn.lanqiao.ui;

import java.awt.event.*;
import cn.lanqiao.entity.Peoples.User;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class PersonalInformationAlter extends JDialog {
    public User currentUser = null;
    public PersonalInformationAlter(User user) {
        this.currentUser = user;
        initComponents();
    }

    private void alterUidButtonActionPerformed(ActionEvent e) {
        // 修改密码
        if (currentUser == null) {
            return;
        }
        new AlterUPasswordJDialog(currentUser).setVisible(true);
    }

    private void alterUtelButtonActionPerformed(ActionEvent e) {
        // 修改电话号码
        if (currentUser == null) {
            return;
        }
        new AlterUserTelJDialog(currentUser).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        alterUidButton = new JButton();
        alterUtelButton = new JButton();

        //======== this ========
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("\u4fee\u6539\u4fe1\u606f");
        setBackground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 255));
            panel1.setLayout(null);

            //---- alterUidButton ----
            alterUidButton.setText("\u4fee\u6539\u5bc6\u7801");
            alterUidButton.setBackground(Color.white);
            alterUidButton.setFont(alterUidButton.getFont().deriveFont(alterUidButton.getFont().getStyle() | Font.BOLD));
            alterUidButton.addActionListener(e -> alterUidButtonActionPerformed(e));
            panel1.add(alterUidButton);
            alterUidButton.setBounds(60, 25, 110, 35);

            //---- alterUtelButton ----
            alterUtelButton.setText("\u4fee\u6539\u7535\u8bdd\u53f7\u7801");
            alterUtelButton.setBackground(Color.white);
            alterUtelButton.setFont(alterUtelButton.getFont().deriveFont(alterUtelButton.getFont().getStyle() | Font.BOLD));
            alterUtelButton.addActionListener(e -> alterUtelButtonActionPerformed(e));
            panel1.add(alterUtelButton);
            alterUtelButton.setBounds(60, 85, 110, 35);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 245, 160);

        contentPane.setPreferredSize(new Dimension(245, 190));
        setSize(245, 190);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton alterUidButton;
    private JButton alterUtelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
