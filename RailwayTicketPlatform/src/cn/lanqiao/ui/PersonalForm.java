/*
 * Created by JFormDesigner on Thu Apr 15 10:04:24 CST 2021
 */

package cn.lanqiao.ui;

import cn.lanqiao.entity.Peoples.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class PersonalForm extends JFrame {
    public User currentUser = null;

    public PersonalForm(User currentUser) {
        this.currentUser=currentUser;
        initComponents();
    }

    private void passengerButtonActionPerformed(ActionEvent e) {
        // 乘车人
        if (currentUser == null) {
            return;
        }
        new PassengerJDialog(currentUser).setVisible(true);
    }

    private void myOrderButtonActionPerformed(ActionEvent e) {
        // 我的订单
        if (currentUser == null) {
            return;
        }
        //new 订单窗口
    }

    private void settingButtonActionPerformed(ActionEvent e) {
        //设置
        if (currentUser == null) {
            return;
        }
        new SettingJDialog(currentUser).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        layeredPane1 = new JLayeredPane();
        panel1 = new JPanel();
        Namelabel = new JLabel();
        panel2 = new JPanel();
        passengerButton = new JButton();
        myOrderButton = new JButton();
        settingButton = new JButton();
        panel3 = new JPanel();
        label3 = new JLabel();

        //======== this ========
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/userImg.jpg")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== layeredPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setBackground(new Color(102, 102, 255));
                panel1.setLayout(null);

                //---- Namelabel ----
                Namelabel.setBackground(Color.white);
                Namelabel.setFont(Namelabel.getFont().deriveFont(Namelabel.getFont().getStyle() | Font.BOLD));
                Namelabel.setForeground(Color.white);
                Namelabel.setText(currentUser.getUName().trim());
                panel1.add(Namelabel);
                Namelabel.setBounds(145, 10, 110, 25);
            }
            layeredPane1.add(panel1, JLayeredPane.DEFAULT_LAYER);
            panel1.setBounds(0, 0, 400, 50);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(102, 102, 255));
                panel2.setLayout(null);

                //---- passengerButton ----
                passengerButton.setText("\u4e58\u8f66\u4eba");
                passengerButton.setBackground(Color.white);
                passengerButton.setFont(passengerButton.getFont().deriveFont(passengerButton.getFont().getStyle() | Font.BOLD));
                passengerButton.addActionListener(e -> passengerButtonActionPerformed(e));
                panel2.add(passengerButton);
                passengerButton.setBounds(10, 20, 80, 30);

                //---- myOrderButton ----
                myOrderButton.setText("\u6211\u7684\u8ba2\u5355");
                myOrderButton.setBackground(Color.white);
                myOrderButton.setFont(myOrderButton.getFont().deriveFont(myOrderButton.getFont().getStyle() | Font.BOLD));
                myOrderButton.addActionListener(e -> myOrderButtonActionPerformed(e));
                panel2.add(myOrderButton);
                myOrderButton.setBounds(150, 20, 90, 30);

                //---- settingButton ----
                settingButton.setText("\u8bbe\u7f6e");
                settingButton.setBackground(Color.white);
                settingButton.setFont(settingButton.getFont().deriveFont(settingButton.getFont().getStyle() | Font.BOLD));
                settingButton.addActionListener(e -> settingButtonActionPerformed(e));
                panel2.add(settingButton);
                settingButton.setBounds(300, 20, 80, 30);
            }
            layeredPane1.add(panel2, JLayeredPane.DEFAULT_LAYER);
            panel2.setBounds(0, 330, 400, 88);

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //---- label3 ----
                new PersonalFormThread(label3).start();
                label3.setBackground(Color.white);
                panel3.add(label3);
                label3.setBounds(0, 0, 400, 280);
            }
            layeredPane1.add(panel3, JLayeredPane.DEFAULT_LAYER);
            panel3.setBounds(0, 50, 400, 280);
        }
        contentPane.add(layeredPane1);
        layeredPane1.setBounds(0, 0, 400, 418);

        contentPane.setPreferredSize(new Dimension(400, 445));
        setSize(400, 445);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLayeredPane layeredPane1;
    private JPanel panel1;
    private JLabel Namelabel;
    private JPanel panel2;
    private JButton passengerButton;
    private JButton myOrderButton;
    private JButton settingButton;
    private JPanel panel3;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

class PersonalFormThread extends Thread {
    private JLabel jLabel;
    private ImageIcon[] icons=new ImageIcon[4];

    public PersonalFormThread(JLabel jLabel) {
        for (int i = 0; i < 4; i++) {
            icons[i] = new ImageIcon(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/"+(i+1)+".jpeg")).getImage().getScaledInstance(400,280,Image.SCALE_DEFAULT));
        }
        this.jLabel = jLabel;
    }

    @Override
    public void run() {
        while (true) {
            for (int i =0;i<4 ; i++) {
                jLabel.setIcon(icons[i%4]);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}