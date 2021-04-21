/*
 * Created by JFormDesigner on Sun Apr 18 14:34:41 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import java.awt.event.*;
import cn.lanqiao.entity.Peoples.Orders;
import cn.lanqiao.service.OrderService;
import cn.lanqiao.service.impl.OrderServiceImpl;
import cn.lanqiao.util.ClientUtil;

import java.awt.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class CertainToPay extends JDialog {
    String orderNum;
    public CertainToPay(String orderNo,String passenger) {
//        super(owner);
        this.orderNum = orderNo;
        initComponents();
        init(orderNo,passenger);
    }

    private void init(String orderNo,String passenger){
        OrderService orderService = new OrderServiceImpl();
        Orders orderByOrderNo = orderService.getOrderByOrderNo(orderNo);
        if(orderByOrderNo == null){
            JOptionPane.showMessageDialog(desktopPane1,"服务器开小差了~去未支付订单看看吧~");
        } else {
            this.orderNo.setText(orderNo);
            trainNo.setText(orderByOrderNo.getTrain_No());
            startStation.setText(orderByOrderNo.getStation_Start_No());
            arriveStation.setText(orderByOrderNo.getStation_End_NO());
            Date train_start_date = orderByOrderNo.getTrain_Start_Date();
            Date order_create_time = orderByOrderNo.getOrder_Create_Time();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String date = sdf.format(order_create_time);
            startTime.setText(date);
            passengerName.setText(passenger);
            PID.setText(orderByOrderNo.getPid());
            sumprice.setText(String.valueOf(orderByOrderNo.getSumPrice()));
        }
    }

    private void certainToPayActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(userCheck.isSelected()){
            int confirmDialog = JOptionPane.showConfirmDialog(desktopPane1, "是否确认支付？");
            if(confirmDialog==0){
                OrderService orderService = new OrderServiceImpl();
                String pid = orderService.getOrderByOrderNo(orderNum).getPid();
                String trainNum = orderService.getOrderByOrderNo(orderNum).getTrain_No();
                String startStationNum = orderService.getOrderByOrderNo(orderNum).getStation_Start_No();
                String endStationNum = orderService.getOrderByOrderNo(orderNum).getStation_End_NO();
                String hostIp = ClientUtil.getHostIp();
                String generateBuyTicketString = ClientUtil.generateBuyTicketString(hostIp, trainNum, startStationNum, endStationNum);
                ClientUtil.sendInfo(generateBuyTicketString);
                boolean bBoolean = ClientUtil.receiveInfo();
                Boolean aBoolean = orderService.updateOrderState(orderNum);
                if(aBoolean && bBoolean)
                    JOptionPane.showMessageDialog(desktopPane1, "订单支付成功！");
                else
                    JOptionPane.showMessageDialog(desktopPane1, "订单支付失败！");
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(desktopPane1,"请在阅读订单信息后勾选确认框");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        desktopPane1 = new JDesktopPane();
        label1 = new JLabel();
        orderNo = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        userCheck = new JCheckBox();
        certainToPay = new JButton();
        trainNo = new JLabel();
        startStation = new JLabel();
        arriveStation = new JLabel();
        startTime = new JLabel();
        passengerName = new JLabel();
        PID = new JLabel();
        sumprice = new JLabel();
        label18 = new JLabel();

        //======== this ========
        setTitle("\u8ba2\u5355\u786e\u8ba4");
        setBackground(new Color(102, 153, 255));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== desktopPane1 ========
        {
            desktopPane1.setBackground(new Color(102, 153, 255));

            //---- label1 ----
            label1.setText("No.");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
            desktopPane1.add(label1, JLayeredPane.DEFAULT_LAYER);
            label1.setBounds(0, 35, 30, 30);

            //---- orderNo ----
            orderNo.setText("asdfsdfasd");
            orderNo.setFont(orderNo.getFont().deriveFont(orderNo.getFont().getSize() + 1f));
            desktopPane1.add(orderNo, JLayeredPane.DEFAULT_LAYER);
            orderNo.setBounds(30, 40, 445, orderNo.getPreferredSize().height);

            //---- label3 ----
            label3.setText("\u51fa\u53d1\u65f6\u95f4\uff1a");
            label3.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
            desktopPane1.add(label3, JLayeredPane.DEFAULT_LAYER);
            label3.setBounds(new Rectangle(new Point(65, 195), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u59cb\u53d1\u7ad9\uff1a");
            label4.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
            desktopPane1.add(label4, JLayeredPane.DEFAULT_LAYER);
            label4.setBounds(65, 125, 95, 19);

            //---- label5 ----
            label5.setText("\u5230\u8fbe\u7ad9\uff1a");
            label5.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
            desktopPane1.add(label5, JLayeredPane.DEFAULT_LAYER);
            label5.setBounds(65, 160, 90, 19);

            //---- label6 ----
            label6.setText("\u8f66   \u6b21\uff1a");
            label6.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
            desktopPane1.add(label6, JLayeredPane.DEFAULT_LAYER);
            label6.setBounds(65, 90, 85, 19);

            //---- label7 ----
            label7.setText("\u4e58\u8f66\u4eba\uff1a");
            label7.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
            desktopPane1.add(label7, JLayeredPane.DEFAULT_LAYER);
            label7.setBounds(65, 230, label7.getPreferredSize().width, 19);

            //---- label8 ----
            label8.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
            label8.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
            desktopPane1.add(label8, JLayeredPane.DEFAULT_LAYER);
            label8.setBounds(65, 265, 110, 19);

            //---- label9 ----
            label9.setText("\u603b\u91d1\u989d\uff1a");
            label9.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
            desktopPane1.add(label9, JLayeredPane.DEFAULT_LAYER);
            label9.setBounds(65, 300, 100, 19);

            //---- label10 ----
            label10.setText("\u8bf7\u786e\u8ba4\u60a8\u7684\u8ba2\u5355\u4fe1\u606f\u5e76\u8fdb\u884c\u652f\u4ed8\uff0c\u60a8\u7684\u8ba2\u5355\u4fe1\u606f\u5982\u4e0b:");
            label10.setFont(new Font("\u7530\u6c0f\u989c\u4f53\u5927\u5b57\u5e93", Font.PLAIN, 21));
            label10.setForeground(Color.white);
            desktopPane1.add(label10, JLayeredPane.DEFAULT_LAYER);
            label10.setBounds(0, 0, 495, label10.getPreferredSize().height);

            //---- userCheck ----
            userCheck.setText("\u6211\u5df2\u786e\u8ba4\u4ee5\u4e0a\u4fe1\u606f");
            userCheck.setFont(new Font("\u6977\u4f53", Font.PLAIN, 19));
            userCheck.setBackground(new Color(102, 153, 255));
            desktopPane1.add(userCheck, JLayeredPane.DEFAULT_LAYER);
            userCheck.setBounds(new Rectangle(new Point(70, 345), userCheck.getPreferredSize()));

            //---- certainToPay ----
            certainToPay.setText("\u652f\u4ed8");
            certainToPay.addActionListener(e -> certainToPayActionPerformed(e));
            desktopPane1.add(certainToPay, JLayeredPane.DEFAULT_LAYER);
            certainToPay.setBounds(new Rectangle(new Point(295, 345), certainToPay.getPreferredSize()));

            //---- trainNo ----
            trainNo.setText("D2894");
            trainNo.setFont(new Font("\u534e\u6587\u4eff\u5b8b", Font.BOLD, 20));
            desktopPane1.add(trainNo, JLayeredPane.DEFAULT_LAYER);
            trainNo.setBounds(180, 85, 170, trainNo.getPreferredSize().height);

            //---- startStation ----
            startStation.setText("\u6842\u6797\u5317\u7ad9");
            startStation.setFont(new Font("\u534e\u6587\u4eff\u5b8b", Font.BOLD, 20));
            desktopPane1.add(startStation, JLayeredPane.DEFAULT_LAYER);
            startStation.setBounds(180, 120, 170, startStation.getPreferredSize().height);

            //---- arriveStation ----
            arriveStation.setText("\u5e7f\u5dde\u5357\u7ad9");
            arriveStation.setFont(new Font("\u534e\u6587\u4eff\u5b8b", Font.BOLD, 20));
            desktopPane1.add(arriveStation, JLayeredPane.DEFAULT_LAYER);
            arriveStation.setBounds(180, 155, 170, arriveStation.getPreferredSize().height);

            //---- startTime ----
            startTime.setText("2021-04-18 14:53");
            startTime.setFont(new Font("\u534e\u6587\u4eff\u5b8b", Font.BOLD, 20));
            desktopPane1.add(startTime, JLayeredPane.DEFAULT_LAYER);
            startTime.setBounds(180, 190, 170, startTime.getPreferredSize().height);

            //---- passengerName ----
            passengerName.setText("\u59dc\u67f3\u5f64");
            passengerName.setFont(new Font("\u534e\u6587\u4eff\u5b8b", Font.BOLD, 20));
            desktopPane1.add(passengerName, JLayeredPane.DEFAULT_LAYER);
            passengerName.setBounds(180, 225, 170, passengerName.getPreferredSize().height);

            //---- PID ----
            PID.setText("45010520001025204X");
            PID.setFont(new Font("\u534e\u6587\u4eff\u5b8b", Font.BOLD, 20));
            desktopPane1.add(PID, JLayeredPane.DEFAULT_LAYER);
            PID.setBounds(180, 260, 240, PID.getPreferredSize().height);

            //---- sumprice ----
            sumprice.setText("165");
            sumprice.setFont(new Font("\u534e\u6587\u4eff\u5b8b", Font.BOLD, 20));
            desktopPane1.add(sumprice, JLayeredPane.DEFAULT_LAYER);
            sumprice.setBounds(205, 295, 240, sumprice.getPreferredSize().height);

            //---- label18 ----
            label18.setText("\uffe5");
            label18.setFont(new Font("\u534e\u6587\u4eff\u5b8b", Font.BOLD, 20));
            desktopPane1.add(label18, JLayeredPane.DEFAULT_LAYER);
            label18.setBounds(180, 295, 25, label18.getPreferredSize().height);
        }
        contentPane.add(desktopPane1);
        desktopPane1.setBounds(0, 0, 495, 495);

        contentPane.setPreferredSize(new Dimension(495, 455));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JDesktopPane desktopPane1;
    private JLabel label1;
    private JLabel orderNo;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JCheckBox userCheck;
    private JButton certainToPay;
    private JLabel trainNo;
    private JLabel startStation;
    private JLabel arriveStation;
    private JLabel startTime;
    private JLabel passengerName;
    private JLabel PID;
    private JLabel sumprice;
    private JLabel label18;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
