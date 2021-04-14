/*
 * Created by JFormDesigner on Wed Apr 14 11:17:34 GMT+08:00 2021
 */

package cn.lanqiao.ui;

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
    private String[] header = new String[]{"列车名", "出发站", "终点站", "发车时间", "到达时间", "用时"};
    private String trainNum;
    private String startStation;
    private String endStation;
    public GetDetailTrainParkingFrm(String trainNum, String startStation, String endStation) {
        initComponents();
        this.trainNum=trainNum;
        this.startStation=startStation;
        this.endStation = endStation;
        init();
    }

    public void init() {
        Object[][] detailTrainParking = trainInforService.getDetailTrainParking(trainNum, startStation, endStation);
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
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("\u7ecf\u505c\u7ad9\u4fe1\u606f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 550, 150);

        contentPane.setPreferredSize(new Dimension(550, 180));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
