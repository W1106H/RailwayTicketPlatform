/*
 * Created by JFormDesigner on Tue Apr 13 19:20:40 CST 2021
 */

package cn.lanqiao.ui.TrainInfoUI;

import cn.lanqiao.service.TrainInforService;
import cn.lanqiao.service.impl.TrainInforServiceimpl;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class TraintransferFrm extends JFrame {
    public TraintransferFrm() {
        initComponents();
    }

    //中转查询
    private void initsetModel(String startStationText,String endStationText){
        TrainInforService trainInforService = new TrainInforServiceimpl();
        Object[][] transferInforObject = trainInforService.getTransferInfor(startStationText,endStationText,false);
        String[] head = new String[]{"出发站名","车次","开始时间","开始日期","到达时间","换乘时间","换乘转站","车次","开始时间","到达日期","到达时间","终点站","总时间","总价"};
        TransferTable.setModel(new DefaultTableModel(transferInforObject,head));
    }
    //搜索
    private void btnTransferSearchActionPerformed(ActionEvent e) {
        // 实现搜索
        String startStationText = textStartStation.getText();
        String endStationText = textEndStation.getText();
        initsetModel(startStationText,endStationText);
        TrainInforService trainInforService = new TrainInforServiceimpl();
        Object[][] transferInforObject = trainInforService.getTransferInfor(startStationText,endStationText,false);
        String[] head = new String[]{"出发站名","车次","开始时间","开始日期","到达时间","换乘时间","换乘转站","车次","开始时间","到达日期","到达时间","终点站","总时间","总价"};
        TransferTable.setModel(new DefaultTableModel(transferInforObject,head));
        TransferTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane1.setViewportView(TransferTable);
    }
    //购票
    private void btnBuyTicketActionPerformed(ActionEvent e) {
        JDialog buyTicket = new BuyTickeFrm();

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("lanqiao.com.message");
        textStartStation = new JTextField();
        textEndStation = new JTextField();
        btnTransferSearch = new JButton();
        scrollPane1 = new JScrollPane();
        TransferTable = new JTable();
        btnTimeSortAsc = new JButton();
        btnTimeSortDesc = new JButton();
        btnBuyTicket = new JButton();
        btnFindStationInfor = new JButton();

        //======== this ========
        setTitle(bundle.getString("TraintransferFrm.this.title"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- textStartStation ----
        textStartStation.setText(bundle.getString("TraintransferFrm.textStartStation.text"));
        contentPane.add(textStartStation);
        textStartStation.setBounds(60, 15, 165, textStartStation.getPreferredSize().height);

        //---- textEndStation ----
        textEndStation.setText(bundle.getString("TraintransferFrm.textEndStation.text"));
        contentPane.add(textEndStation);
        textEndStation.setBounds(240, 15, 165, textEndStation.getPreferredSize().height);

        //---- btnTransferSearch ----
        btnTransferSearch.setText(bundle.getString("TraintransferFrm.btnTransferSearch.text"));
        btnTransferSearch.addActionListener(e -> btnTransferSearchActionPerformed(e));
        contentPane.add(btnTransferSearch);
        btnTransferSearch.setBounds(new Rectangle(new Point(425, 15), btnTransferSearch.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- TransferTable ----
            TrainInforService trainInforService = new TrainInforServiceimpl();
            Object[][] transferInforObject = trainInforService.getTransferInfor(textStartStation.getText(),textEndStation.getText(),false);
            String[] head = new String[]{"出发站名","车次","开始时间","开始日期","到达时间","换乘时间","换乘转站","车次","开始时间","到达日期","到达时间","终点站","总时间","总价"};
            TransferTable.setModel(new DefaultTableModel(transferInforObject,head));
            scrollPane1.setViewportView(TransferTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 50, 815, 315);

        //---- btnTimeSortAsc ----
        btnTimeSortAsc.setText(bundle.getString("TraintransferFrm.btnTimeSortAsc.text"));
        contentPane.add(btnTimeSortAsc);
        btnTimeSortAsc.setBounds(new Rectangle(new Point(155, 475), btnTimeSortAsc.getPreferredSize()));

        //---- btnTimeSortDesc ----
        btnTimeSortDesc.setText(bundle.getString("TraintransferFrm.btnTimeSortDesc.text"));
        contentPane.add(btnTimeSortDesc);
        btnTimeSortDesc.setBounds(290, 475, 130, btnTimeSortDesc.getPreferredSize().height);

        //---- btnBuyTicket ----
        btnBuyTicket.setText(bundle.getString("TraintransferFrm.btnBuyTicket.text"));
        btnBuyTicket.addActionListener(e -> btnBuyTicketActionPerformed(e));
        contentPane.add(btnBuyTicket);
        btnBuyTicket.setBounds(new Rectangle(new Point(445, 475), btnBuyTicket.getPreferredSize()));

        //---- btnFindStationInfor ----
        btnFindStationInfor.setText(bundle.getString("TraintransferFrm.btnFindStationInfor.text"));
        contentPane.add(btnFindStationInfor);
        btnFindStationInfor.setBounds(new Rectangle(new Point(545, 475), btnFindStationInfor.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(845, 540));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textStartStation;
    private JTextField textEndStation;
    private JButton btnTransferSearch;
    private JScrollPane scrollPane1;
    private JTable TransferTable;
    private JButton btnTimeSortAsc;
    private JButton btnTimeSortDesc;
    private JButton btnBuyTicket;
    private JButton btnFindStationInfor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
