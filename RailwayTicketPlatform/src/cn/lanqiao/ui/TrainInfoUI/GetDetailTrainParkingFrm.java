/*
 * Created by JFormDesigner on Wed Apr 14 11:17:34 GMT+08:00 2021
 */

package cn.lanqiao.ui.TrainInfoUI;

import java.awt.event.*;

import cn.lanqiao.dao.TrainInforDao;
import cn.lanqiao.dao.impl.TrainInforDaoimpl;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.TrainInforService;
import cn.lanqiao.service.impl.TrainInforServiceimpl;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class GetDetailTrainParkingFrm extends JFrame {
    private TrainInforService trainInforService=new TrainInforServiceimpl();
    private String[] header = new String[]{"列车名", "出发站", "终点站", "发车时间", "到达时间", "用时","余票"};
    private String trainNum;
    private String startStation;
    private String endStation;
    private String year_month_day;
    private int ticketType;
    private User currentUser;
    private Object[][] detailTrainParking;

    public Object[][] getDetailTrainParking() {
        return detailTrainParking;
    }

    public GetDetailTrainParkingFrm(String trainNum, String startStation, String endStation, String year_month_day, int ticketType,User currentUser) {
        initComponents();
        this.currentUser=currentUser;
        this.trainNum=trainNum;
        this.startStation=startStation;
        this.endStation = endStation;
        this.year_month_day=year_month_day;
        this.ticketType=ticketType;
        init();
    }

    public void init() {
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(102, 153, 255));
        detailTrainParking = trainInforService.getDetailTrainParking(trainNum, startStation, endStation);
        //当数据超过下面的宽度和高度即可拉
        table1.setPreferredScrollableViewportSize(new Dimension( 550, 150));
        //创建下拉条
        JScrollPane scrollPane = new JScrollPane(table1);
        //设置列大小不可拖动
        table1.getTableHeader().setResizingAllowed(false);
        //设置表头不可拖动
        table1.getTableHeader().setReorderingAllowed(false);
        //不显示水平线和垂直线
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        //拿到所有列车信息
        this.table1.setModel(new DefaultTableModel(detailTrainParking,header));
        //必须加上下面语句猜能显示
        scrollPane1.setViewportView(table1);
    }

    private void btnreservationActionPerformed(ActionEvent e) {
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        int[] selectedRows = table1.getSelectedRows();
        String trainNum=null;
        String startStation=null;
        String endStation=null;
        Object[][] order=null;
        int price = 0;
        int startOrder;
        int endOrder;
        if (selectedRows.length == 2) {
            int startRow = selectedRows[0];
            int endRow = selectedRows[1];
            trainNum= table1.getValueAt(startRow,0).toString();
            startStation = table1.getValueAt(startRow, 1).toString();
            endStation = table1.getValueAt(endRow, 2).toString();
            order = trainInforService.UserBuyBuyTickets( currentUser.getPId(), trainNum, startStation, endStation);
            startOrder = Integer.valueOf(trainInforDao.getStationOrder(trainNum, startStation));
            endOrder = Integer.valueOf(trainInforDao.getStationOrder(trainNum, endStation));
            price=trainInforDao.getOneTrainPrice(startOrder,endOrder);
        } else if (selectedRows.length == 1) {
            trainNum= table1.getValueAt(selectedRows[0],0).toString();
            startStation = table1.getValueAt(selectedRows[0], 1).toString();
            endStation = table1.getValueAt(selectedRows[0], 2).toString();
            order = trainInforService.UserBuyBuyTickets( currentUser.getPId(), trainNum, startStation, endStation);
            startOrder = Integer.valueOf(trainInforDao.getStationOrder(trainNum, startStation));
            endOrder = Integer.valueOf(trainInforDao.getStationOrder(trainNum, endStation));
            price=trainInforDao.getOneTrainPrice(startOrder,endOrder);
        }
        else {
            JOptionPane.showMessageDialog(null,"请选择两行或一行");
        }
        //还差参数
        CreateOrder createOrder = new CreateOrder(order, year_month_day, ticketType,price);
        createOrder.setVisible(true);
    /*    for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(order[i][j]+" ");
            }
            System.out.println();
        }*/
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btnreservation = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u7ecf\u505c\u7ad9\u4fe1\u606f");
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
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 550, 150);

        //---- btnreservation ----
        btnreservation.setText("\u8ba2\u7968");
        btnreservation.addActionListener(e -> btnreservationActionPerformed(e));
        contentPane.add(btnreservation);
        btnreservation.setBounds(new Rectangle(new Point(450, 165), btnreservation.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u8ba2\u7968\u6309\u4f4fCTRL\u9009\u62e9\u4e24\u884c\u6216\u9009\u62e9\u4e00\u884c");
        contentPane.add(label1);
        label1.setBounds(10, 160, 195, 30);

        contentPane.setPreferredSize(new Dimension(550, 235));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btnreservation;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
