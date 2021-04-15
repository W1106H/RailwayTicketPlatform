/*
 * Created by JFormDesigner on Tue Apr 13 17:26:48 GMT+08:00 2021
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
public class SerTrainInfoByStation extends JInternalFrame {
    private String[] header = new String[]{"列车名", "列车种类", "发车时间", "到达时间", "起始站", "终点站", "运行时间", "价格","余票"};
    private String startStation;
    private String endStation ;
    private String trainType;
    private TrainInforService trainInforService = new TrainInforServiceimpl();
    public SerTrainInfoByStation(String startStation, String endStation,String trainType) {
        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口后操作为退出程序*/
        this.startStation=startStation;
        this.endStation = endStation;
        this.trainType=trainType;
        initComponents();
        init();
    }

    public void init() {
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(102, 153, 255));
        this.setSize(650, 250);
        //当数据超过下面的宽度和高度即可拉
        table1.setPreferredScrollableViewportSize(new Dimension( 650, 250));
        //创建下拉条
        JScrollPane scrollPane = new JScrollPane(table1);
        //设置列大小不可拖动
        table1.getTableHeader().setResizingAllowed(false);
        //设置表头不可拖动
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        Object[][] trainsInfoByStationName = trainInforService.getTrainsInfoByStationNameAndtrainType(startStation,endStation,trainType);
        this.table1.setModel(new DefaultTableModel(trainsInfoByStationName,header));
        //必须加上下面语句才能显示
        scrollPane1.setViewportView(table1);

    }

    private void btndatailActionPerformed(ActionEvent e) {
        int selectedRow = table1.getSelectedRow();
        String trainNum = table1.getValueAt(selectedRow, 0).toString();
        String startStation = table1.getValueAt(selectedRow, 4).toString();
        String endStation = table1.getValueAt(selectedRow, 5).toString();
        GetDetailTrainParkingFrm getDetailTrainParkingFrm = new GetDetailTrainParkingFrm(trainNum, startStation, endStation);
        getDetailTrainParkingFrm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btndatail = new JButton();
        btnorder = new JButton();
        btntransfer = new JButton();

        //======== this ========
        setVisible(true);
        setClosable(true);
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
                },
                new String[] {
                    null, null, null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 625, 180);

        //---- btndatail ----
        btndatail.setText("\u67e5\u8be2\u8be6\u60c5");
        btndatail.addActionListener(e -> btndatailActionPerformed(e));
        contentPane.add(btndatail);
        btndatail.setBounds(new Rectangle(new Point(540, 190), btndatail.getPreferredSize()));

        //---- btnorder ----
        btnorder.setText("\u8ba2\u7968");
        contentPane.add(btnorder);
        btnorder.setBounds(new Rectangle(new Point(445, 190), btnorder.getPreferredSize()));

        //---- btntransfer ----
        btntransfer.setText("\u4e2d\u8f6c\u67e5\u8be2");
        contentPane.add(btntransfer);
        btntransfer.setBounds(new Rectangle(new Point(350, 190), btntransfer.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(625, 240));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btndatail;
    private JButton btnorder;
    private JButton btntransfer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        SerTrainInfoByStation serTrainInfoByStation = new SerTrainInfoByStation("桂林北站", "柳州站","动车");
        serTrainInfoByStation.setVisible(true);
}
}
