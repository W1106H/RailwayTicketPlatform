/*
 * Created by JFormDesigner on Thu Apr 15 12:06:34 GMT+08:00 2021
 */

package cn.lanqiao.ui.TrainInfoUI;

import java.awt.event.*;

import cn.lanqiao.dao.TrainInforDao;
import cn.lanqiao.dao.impl.TrainInforDaoimpl;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.TrainInforService;
import cn.lanqiao.service.impl.TrainInforServiceimpl;
import cn.lanqiao.ui.AllPassenger;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class serTrainInfoByStation1 extends JFrame {
    private String[] header = new String[]{"列车名", "列车种类", "发车时间", "到达时间", "起始站", "终点站", "运行时间", "价格","余票"};
    Object[][] trainsInfoByStationName=null;
    private String startStation;
    private String endStation ;
    private String trainType;
    private String year_month_day;
    private int ticketType;
    private User currentUser;
    private TrainInforService trainInforService = new TrainInforServiceimpl();
    public serTrainInfoByStation1(String startStation, String endStation,String trainType,String year_month_day,int ticketType,User currentUser) {
        this.startStation=startStation;
        this.currentUser=currentUser;
        this.endStation = endStation;
        this.trainType=trainType;
        this.year_month_day=year_month_day;
        this.ticketType = ticketType;
        initComponents();
        init();
    }
    public void init() {
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(102, 153, 255));
        //当数据超过下面的宽度和高度即可拉
        table1.setPreferredScrollableViewportSize(new Dimension( 745, 195));
        //创建下拉条
        JScrollPane scrollPane = new JScrollPane(table1);
        //设置列大小不可拖动
        table1.getTableHeader().setResizingAllowed(false);
        //设置表头不可拖动
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        trainsInfoByStationName = trainInforService.getTrainsInfoByStationNameAndtrainType(startStation,endStation,trainType);
        this.table1.setModel(new DefaultTableModel(trainsInfoByStationName,header));
        //必须加上下面语句才能显示
        scrollPane1.setViewportView(table1);
    }
    public Object[][] getTrainsInfoByStationName() {
        return trainsInfoByStationName;
    }

    private void btndatailActionPerformed(ActionEvent e) {
        int selectedRow = table1.getSelectedRow();
        String trainNum=table1.getValueAt(selectedRow,0).toString();
        String startStation=table1.getValueAt(selectedRow,4).toString();
        String endStation=table1.getValueAt(selectedRow,5).toString();
        GetDetailTrainParkingFrm getDetailTrainParkingFrm = new GetDetailTrainParkingFrm(trainNum, startStation, endStation,year_month_day,ticketType,currentUser);
        getDetailTrainParkingFrm.setVisible(true);
    }
        //定票
    private void btnOrderActionPerformed(ActionEvent e) {
        // TODO add your code here
        TrainInforDao trainInforDao = new TrainInforDaoimpl();
        int selectedRow = table1.getSelectedRow();
        String trainNum = table1.getValueAt(selectedRow, 0).toString();
        String startStation = table1.getValueAt(selectedRow, 4).toString();
        String endStation = table1.getValueAt(selectedRow, 5).toString();
        Object[][] order = trainInforService.UserBuyBuyTickets(currentUser.getPId(), trainNum, startStation, endStation);
        int startOrder = Integer.valueOf(trainInforDao.getStationOrder(trainNum, startStation));
        int  endOrder = Integer.valueOf(trainInforDao.getStationOrder(trainNum, endStation));
        int price=trainInforDao.getOneTrainPrice(startOrder,endOrder);
        AllPassenger allPassenger = new AllPassenger(currentUser, order, year_month_day, ticketType, price);
        allPassenger.setVisible(true);
    }

    //中转查询
    private void btntransferActionPerformed(ActionEvent e) {
        // TODO add your code here
        int selectedRow = table1.getSelectedRow();
        String startStation=table1.getValueAt(selectedRow,4).toString();
        String endStation=table1.getValueAt(selectedRow,5).toString();
        TraintransferFrm1 traintransferFrm1 = new TraintransferFrm1(startStation, endStation,year_month_day,ticketType,currentUser);
        traintransferFrm1.setVisible(true);

    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btndatail = new JButton();
        btnOrder = new JButton();
        btntransfer = new JButton();

        //======== this ========
        setTitle("\u5217\u8f66\u4fe1\u606f");
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/mainLogo.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 745, 195);

        //---- btndatail ----
        btndatail.setText("\u67e5\u8be2\u8be6\u60c5");
        btndatail.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        btndatail.addActionListener(e -> btndatailActionPerformed(e));
        contentPane.add(btndatail);
        btndatail.setBounds(new Rectangle(new Point(660, 200), btndatail.getPreferredSize()));

        //---- btnOrder ----
        btnOrder.setText("\u8ba2\u7968");
        btnOrder.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        btnOrder.addActionListener(e -> btnOrderActionPerformed(e));
        contentPane.add(btnOrder);
        btnOrder.setBounds(new Rectangle(new Point(555, 200), btnOrder.getPreferredSize()));

        //---- btntransfer ----
        btntransfer.setText("\u4e2d\u8f6c\u67e5\u8be2");
        btntransfer.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        btntransfer.addActionListener(e -> btntransferActionPerformed(e));
        contentPane.add(btntransfer);
        btntransfer.setBounds(new Rectangle(new Point(450, 200), btntransfer.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(800, 270));
        setSize(800, 270);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btndatail;
    private JButton btnOrder;
    private JButton btntransfer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
