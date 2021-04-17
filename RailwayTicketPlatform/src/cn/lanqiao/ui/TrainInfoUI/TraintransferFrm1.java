/*
 * Created by JFormDesigner on Fri Apr 16 10:26:29 GMT+08:00 2021
 */

package cn.lanqiao.ui.TrainInfoUI;

import java.awt.event.*;

import cn.lanqiao.dao.TrainInforDao;
import cn.lanqiao.dao.impl.TrainInforDaoimpl;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.TrainInforService;
import cn.lanqiao.service.impl.TrainInforServiceimpl;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    private User currentUser;

    public TraintransferFrm1(String startStation, String endStation, String year_month_day, int ticketType,User currentUser) {
        this.year_month_day = year_month_day;
        this.currentUser = currentUser;
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

    //订票
    private void btnOrderActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            int selectedRow = table1.getSelectedRow();
            String trainNum1 = table1.getValueAt(selectedRow, 1).toString();
            String trainNum2 = table1.getValueAt(selectedRow, 6).toString();
            String tranNum[] = new String[]{trainNum1, trainNum2};
            String startStation = table1.getValueAt(selectedRow, 0).toString();
            String trasferStation = table1.getValueAt(selectedRow, 5).toString();
            String endStation = table1.getValueAt(selectedRow, 9).toString();
            String sumPrice = table1.getValueAt(selectedRow, 11).toString();
            Date startTime1 = sdf.parse(year_month_day + " " + table1.getValueAt(selectedRow, 2).toString());
            Date endTime1 = sdf.parse(year_month_day + " " + table1.getValueAt(selectedRow, 3).toString());
            Date startTime2 = sdf.parse(year_month_day + " " + table1.getValueAt(selectedRow, 7).toString());
            Date endTime2 = sdf.parse(year_month_day + " " + table1.getValueAt(selectedRow, 8).toString());
            Date Time[] = new Date[]{startTime1, endTime1, startTime2, endTime2};
            TrainInforDao trainInforDao = new TrainInforDaoimpl();
            int stationOrder1 = Integer.valueOf(trainInforDao.getStationOrder(trainNum1, startStation));
            int stationOrder2 = Integer.valueOf(trainInforDao.getStationOrder(trainNum1, trasferStation));
            int stationOrder3 = Integer.valueOf(trainInforDao.getStationOrder(trainNum2, trasferStation));
            int stationOoder4 = Integer.valueOf(trainInforDao.getStationOrder(trainNum2, endStation));
            int price1 = trainInforDao.getOneTrainPrice(stationOrder1, stationOrder2);
            int price2 = trainInforDao.getOneTrainPrice(stationOrder3, stationOoder4);
            TrainInforService trainInforService = new TrainInforServiceimpl();
            Object[][] order1 = trainInforService.UserBuyBuyTickets(currentUser.getPId(), trainNum1, startStation,trasferStation);
            Object[][] order2 = trainInforService.UserBuyBuyTickets(currentUser.getPId(), trainNum2, trasferStation, endStation);

            CreateOrder createOrder = null;
            for (int i = 0; i <= 1; i++) {
                if (i == 0) {
                    createOrder = new CreateOrder( order1,year_month_day, ticketType,price1);
                    createOrder.setTitle("第一订单");
                    createOrder.setVisible(true);
                } else if (i == 1) {
                    createOrder = new CreateOrder(order2, year_month_day, ticketType,price2);
                    createOrder.setTitle("第二订单");
                    createOrder.setVisible(true);
                }

                //createOrder.setVisible(true);
            }

        } catch (ParseException e1) {
            e1.printStackTrace();
        }


    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btnOrder = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u4e2d\u8f6c\u4fe1\u606f");
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/mainLogo.png")).getImage());
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

        //---- btnOrder ----
        btnOrder.setText("\u8ba2\u7968");
        btnOrder.addActionListener(e -> btnOrderActionPerformed(e));
        contentPane.add(btnOrder);
        btnOrder.setBounds(new Rectangle(new Point(850, 215), btnOrder.getPreferredSize()));

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
    private JButton btnOrder;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
  /*  public static void main(String[] args) {
        TraintransferFrm1 traintransferFrm1 = new TraintransferFrm1();
        traintransferFrm1.setVisible(true);
    }*/
}
