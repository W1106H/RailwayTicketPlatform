/*
 * Created by JFormDesigner on Wed Apr 14 20:59:51 CST 2021
 */

package cn.lanqiao.ui.TrainInfoUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class BuyTickeFrm extends JDialog {
    public BuyTickeFrm() {
        super();
        initComponents();
    }

    private void btnBuyTicketActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("lanqiao.com.message");
        txtStartStastionName = new JTextField();
        txtEndStationName = new JTextField();
        txtTrainNum = new JTextField();
        btnBuyTicket = new JButton();
        txtTransStationName = new JTextField();
        txtTransStationNum = new JTextField();
        textPane1 = new JTextPane();
        txtArriveTime = new JTextField();
        txtStartTime = new JTextField();
        button2 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        textField9 = new JTextField();

        //======== this ========
        setTitle(bundle.getString("BuyTickeFrm.this.title"));
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(txtStartStastionName);
        txtStartStastionName.setBounds(140, 20, 200, txtStartStastionName.getPreferredSize().height);
        contentPane.add(txtEndStationName);
        txtEndStationName.setBounds(140, 260, 200, txtEndStationName.getPreferredSize().height);
        contentPane.add(txtTrainNum);
        txtTrainNum.setBounds(140, 60, 200, txtTrainNum.getPreferredSize().height);

        //---- btnBuyTicket ----
        btnBuyTicket.setText(bundle.getString("BuyTickeFrm.btnBuyTicket.text"));
        btnBuyTicket.addActionListener(e -> btnBuyTicketActionPerformed(e));
        contentPane.add(btnBuyTicket);
        btnBuyTicket.setBounds(215, 375, 60, btnBuyTicket.getPreferredSize().height);
        contentPane.add(txtTransStationName);
        txtTransStationName.setBounds(140, 140, 200, txtTransStationName.getPreferredSize().height);
        contentPane.add(txtTransStationNum);
        txtTransStationNum.setBounds(140, 180, 200, txtTransStationNum.getPreferredSize().height);
        contentPane.add(textPane1);
        textPane1.setBounds(260, 80, 5, textPane1.getPreferredSize().height);
        contentPane.add(txtArriveTime);
        txtArriveTime.setBounds(140, 220, 200, txtArriveTime.getPreferredSize().height);
        contentPane.add(txtStartTime);
        txtStartTime.setBounds(140, 100, 200, txtStartTime.getPreferredSize().height);

        //---- button2 ----
        button2.setText(bundle.getString("BuyTickeFrm.button2.text"));
        contentPane.add(button2);
        button2.setBounds(135, 375, 60, button2.getPreferredSize().height);

        //---- label1 ----
        label1.setText(bundle.getString("BuyTickeFrm.label1.text"));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(75, 25), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText(bundle.getString("BuyTickeFrm.label2.text"));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(95, 65), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText(bundle.getString("BuyTickeFrm.label3.text"));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(87, 145), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText(bundle.getString("BuyTickeFrm.label4.text"));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(95, 185), label4.getPreferredSize()));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(60, 185), label5.getPreferredSize()));

        //---- label7 ----
        label7.setText(bundle.getString("BuyTickeFrm.label7.text"));
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(87, 265), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText(bundle.getString("BuyTickeFrm.label8.text"));
        contentPane.add(label8);
        label8.setBounds(75, 225, 56, label8.getPreferredSize().height);

        //---- label9 ----
        label9.setText(bundle.getString("BuyTickeFrm.label9.text"));
        contentPane.add(label9);
        label9.setBounds(95, 305, 34, label9.getPreferredSize().height);

        //---- label10 ----
        label10.setText(bundle.getString("BuyTickeFrm.label10.text"));
        contentPane.add(label10);
        label10.setBounds(new Rectangle(new Point(75, 105), label10.getPreferredSize()));
        contentPane.add(textField9);
        textField9.setBounds(140, 300, 200, textField9.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(500, 450));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField txtStartStastionName;
    private JTextField txtEndStationName;
    private JTextField txtTrainNum;
    private JButton btnBuyTicket;
    private JTextField txtTransStationName;
    private JTextField txtTransStationNum;
    private JTextPane textPane1;
    private JTextField txtArriveTime;
    private JTextField txtStartTime;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JTextField textField9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
