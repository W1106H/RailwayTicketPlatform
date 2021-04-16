/*
 * Created by JFormDesigner on Fri Apr 16 10:26:29 GMT+08:00 2021
 */

package cn.lanqiao.ui.TrainInfoUI;

import java.awt.event.*;
import cn.lanqiao.service.TrainInforService;
import cn.lanqiao.service.impl.TrainInforServiceimpl;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class TraintransferFrm1 extends JFrame {
    private String startStation;
    private String endStation;
    private Object[][] transferInforObject=null;
    private String year_month_day;
    private int ticketType;

    public TraintransferFrm1(String startStation, String endStation, String year_month_day, int ticketType) {
        this.year_month_day = year_month_day;
        this.ticketType = ticketType;
        this.startStation = startStation;
        this.endStation = endStation;
        initComponents();
        initsetModel(startStation, endStation, false);
    }

    private void initsetModel(String startStationText,String endStationText,boolean decSortYesOrNo){
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(102, 153, 255));
        TrainInforService trainInforService = new TrainInforServiceimpl();
        transferInforObject = trainInforService.getTransferInfor(startStationText,endStationText,false);
        String[] head = new String[]{"出发站名","车次","开始时间","到达时间","换乘时间","换乘转站","车次","开始时间","到达时间","终点站","总时间","总价"};
        table1.setModel(new DefaultTableModel(transferInforObject,head));
        scrollPane1.setViewportView(table1);
    }

    public Object[][] getTransferInforObject() {
        return transferInforObject;
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btnbuy = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null
                }
            ));
            table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 945, 205);

        //---- btnbuy ----
        btnbuy.setText("\u8d2d\u7968");
        contentPane.add(btnbuy);
        btnbuy.setBounds(new Rectangle(new Point(850, 215), btnbuy.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(945, 280));
        pack();
        setLocationRelativeTo(getOwner());

        //---- label1 ----
        label1.setText("text");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btnbuy;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
  /*  public static void main(String[] args) {
        TraintransferFrm1 traintransferFrm1 = new TraintransferFrm1();
        traintransferFrm1.setVisible(true);
    }*/
}
