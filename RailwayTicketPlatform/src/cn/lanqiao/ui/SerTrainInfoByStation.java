/*
 * Created by JFormDesigner on Tue Apr 13 17:26:48 GMT+08:00 2021
 */

package cn.lanqiao.ui;

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
    private String[] header = new String[]{"列车名", "列车种类", "发车时间", "到达时间", "起始站", "终点站", "运行时间", "价格"};
    private String startStation;
    private String endStation ;
    private String trainType;
    private TrainInforService trainInforService = new TrainInforServiceimpl();
    public SerTrainInfoByStation(String startStation, String endStation,String trainType) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口后操作为退出程序
        this.startStation=startStation;
        this.endStation = endStation;
        this.trainType=trainType;
        initComponents();
        init();
    }

    public void init() {
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

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
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 625, 180);

        contentPane.setPreferredSize(new Dimension(650, 200));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
/*    public static void main(String[] args) {
        SerTrainInfoByStation serTrainInfoByStation = new SerTrainInfoByStation("桂林北站", "百色站");
        serTrainInfoByStation.setVisible(true);
}*/
}
