/*
 * Created by JFormDesigner on Wed Apr 14 15:49:07 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import cn.lanqiao.service.OrderService;
import cn.lanqiao.service.impl.OrderServiceImpl;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class Order_DetailTrainPass extends JDialog {
    String[] title = {"站名","到达","发车","停留"};

    public Order_DetailTrainPass(String orderNo,String trainNo,String startStation,String arriveStation) {
        //super(owner);
        initComponents();
        init(orderNo,trainNo,startStation,arriveStation);
    }

    private void init(String orderNo,String trainNo,String startStation,String arriveStation){
//        初始化表格内容
        OrderService orderService = new OrderServiceImpl();
        Object[][] trainPassInfo = orderService.getTrainPassInfo(orderNo);
        table1.setModel(new DefaultTableModel(
                trainPassInfo,
                title
        ));
//        初始化出发日期
        String trainStartDate = orderService.getTrainPassInfo_trainStartDate(orderNo);
        this.startDate.setText(trainStartDate);
//        初始化起始站到达站
        this.startStaion.setText(startStation);
        this.arriveStation.setText(arriveStation);
//        初始化列车号
        this.trainNo.setText(trainNo);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        trainNo = new JLabel();
        label2 = new JLabel();
        startDate = new JLabel();
        label3 = new JLabel();
        startStaion = new JLabel();
        label5 = new JLabel();
        arriveStation = new JLabel();

        //======== this ========
        setTitle("\u65f6\u523b\u8868");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                },
                new String[] {
                    null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 65, 400, 235);

        //---- trainNo ----
        trainNo.setText("D8481");
        trainNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        contentPane.add(trainNo);
        trainNo.setBounds(15, 20, 60, trainNo.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u53d1\u8f66\u65e5\u671f\uff1a");
        contentPane.add(label2);
        label2.setBounds(85, 10, 65, label2.getPreferredSize().height);

        //---- startDate ----
        startDate.setText("2021\u5e744\u670811\u65e5");
        contentPane.add(startDate);
        startDate.setBounds(155, 10, 105, 17);

        //---- label3 ----
        label3.setText("\u60a8\u7684\u8d77\u59cb\u7ad9\uff1a");
        contentPane.add(label3);
        label3.setBounds(85, 35, 75, label3.getPreferredSize().height);

        //---- startStaion ----
        startStaion.setText("\u6842\u6797\u5317\u7ad9");
        contentPane.add(startStaion);
        startStaion.setBounds(160, 35, 85, startStaion.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u7ec8\u5230\u7ad9\uff1a");
        contentPane.add(label5);
        label5.setBounds(250, 35, 50, label5.getPreferredSize().height);

        //---- arriveStation ----
        arriveStation.setText("\u5e7f\u5dde\u5357\u7ad9");
        contentPane.add(arriveStation);
        arriveStation.setBounds(305, 35, 105, arriveStation.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 305));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel trainNo;
    private JLabel label2;
    private JLabel startDate;
    private JLabel label3;
    private JLabel startStaion;
    private JLabel label5;
    private JLabel arriveStation;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
