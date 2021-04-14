/*
 * Created by JFormDesigner on Tue Apr 13 20:19:28 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import java.awt.event.*;
import cn.lanqiao.entity.Peoples.Orders;

import java.awt.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Brainrain
 */
public class Order_Detail extends JDialog {

    public Order_Detail() {
        //super(owner);
        initComponents();
    }

    public Order_Detail(Orders orders){
        initComponents();
        init(orders);
    }

    private void init(Orders orders){

//        放入数据
        Date date = null;
        java.sql.Time time = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM月dd日");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");

        String order_no = orders.getOrder_No();
        this.orderNo.setText(order_no);

        String pid = orders.getPid();
        this.passengerPID.setText(pid);

        String train_no = orders.getTrain_No();
        this.trainNo.setText(train_no);

        date = orders.getTrain_Start_Date();
        String startDate = sdf1.format(date);
        this.startDate.setText(startDate);

        time = orders.getTrain_start_Time();
        String startTime = sdf2.format(time);
        this.startTime.setText(startTime);

        date = orders.getTrain_End_Date();
        String endDate = sdf1.format(date);
        this.arriveDate.setText(endDate);

        time = orders.getTrain_end_Time();
        String endTime = sdf2.format(time);
        this.arriveTime.setText(endTime);

        String start_station = orders.getStation_Start_No();
        this.startStation.setText(start_station);

        String arrive_station = orders.getStation_End_NO();
        this.arriveStation.setText(arrive_station);

        String passengerName = orders.getPassengerName();
        this.passengerName.setText(passengerName);

        double sumprice = orders.getSumPrice();
        this.sumPrice.setText(String.valueOf(sumprice));

        String carriageNo = orders.getCarriage_No();
        this.carrigeNo.setText(carriageNo);

        String seatNo = orders.getSeat_No();
        this.seatNo.setText("0" + seatNo);

        String seatType = orders.getSeat_Type();
        this.seatType.setText(seatType);

        String orderType = orders.getOrder_Type();
        this.orderType.setText(orderType);

        String orderState = orders.getOrder_state();
        if("T".equals(orderState)){
            this.orderState.setText("已支付");
        }else{
            this.orderState.setText("未支付");
        }


    }

    private void button1MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void button1MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        desktopPane1 = new JDesktopPane();
        startDate = new JLabel();
        arriveDate = new JLabel();
        startTime = new JLabel();
        arriveTime = new JLabel();
        startStation = new JLabel();
        arriveStation = new JLabel();
        label1 = new JLabel();
        trainNo = new JLabel();
        passengerName = new JLabel();
        passengerPID = new JLabel();
        orderState = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        carrigeNo = new JLabel();
        seatNo = new JLabel();
        label4 = new JLabel();
        sumPrice = new JLabel();
        orderType = new JLabel();
        trainPassBtn = new JButton();
        seatType = new JLabel();
        label5 = new JLabel();
        orderNo = new JLabel();

        //======== this ========
        setTitle("\u8f66\u7968\u8be6\u60c5");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== desktopPane1 ========
        {
            desktopPane1.setBackground(new Color(102, 153, 255));

            //---- startDate ----
            startDate.setText("4\u67083\u65e5");
            startDate.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            desktopPane1.add(startDate, JLayeredPane.DEFAULT_LAYER);
            startDate.setBounds(40, 35, 85, 30);

            //---- arriveDate ----
            arriveDate.setText("4\u67083\u65e5");
            arriveDate.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            desktopPane1.add(arriveDate, JLayeredPane.DEFAULT_LAYER);
            arriveDate.setBounds(330, 35, 80, 30);

            //---- startTime ----
            startTime.setText("12:54");
            startTime.setFont(new Font("Times New Roman", Font.BOLD, 26));
            desktopPane1.add(startTime, JLayeredPane.DEFAULT_LAYER);
            startTime.setBounds(40, 70, 140, 50);

            //---- arriveTime ----
            arriveTime.setText("15:27");
            arriveTime.setFont(new Font("Times New Roman", Font.BOLD, 26));
            desktopPane1.add(arriveTime, JLayeredPane.DEFAULT_LAYER);
            arriveTime.setBounds(330, 70, 115, 50);

            //---- startStation ----
            startStation.setText("\u6842\u6797\u5317");
            startStation.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 17));
            desktopPane1.add(startStation, JLayeredPane.DEFAULT_LAYER);
            startStation.setBounds(40, 115, 120, 30);

            //---- arriveStation ----
            arriveStation.setText("\u5e7f\u5dde\u5357");
            arriveStation.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 17));
            desktopPane1.add(arriveStation, JLayeredPane.DEFAULT_LAYER);
            arriveStation.setBounds(330, 115, 120, 30);

            //---- label1 ----
            label1.setText("\u2192");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 10f));
            desktopPane1.add(label1, JLayeredPane.DEFAULT_LAYER);
            label1.setBounds(235, 115, 50, 25);

            //---- trainNo ----
            trainNo.setText("D2965");
            trainNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
            desktopPane1.add(trainNo, JLayeredPane.DEFAULT_LAYER);
            trainNo.setBounds(180, 115, 110, 35);

            //---- passengerName ----
            passengerName.setText("\u59dc\u67f3\u5f64");
            passengerName.setFont(new Font("\u534e\u6587\u6977\u4f53", Font.BOLD, 20));
            desktopPane1.add(passengerName, JLayeredPane.DEFAULT_LAYER);
            passengerName.setBounds(40, 160, 95, 35);

            //---- passengerPID ----
            passengerPID.setText("45010520001022222X");
            passengerPID.setFont(new Font("Times New Roman", Font.BOLD, 12));
            desktopPane1.add(passengerPID, JLayeredPane.DEFAULT_LAYER);
            passengerPID.setBounds(40, 195, 155, 25);

            //---- orderState ----
            orderState.setText("\u5df2\u652f\u4ed8");
            orderState.setForeground(new Color(255, 17, 13));
            desktopPane1.add(orderState, JLayeredPane.DEFAULT_LAYER);
            orderState.setBounds(40, 220, 80, 45);

            //---- label2 ----
            label2.setText("\u8f66\u53a2");
            label2.setFont(new Font("\u534e\u6587\u6977\u4f53", Font.BOLD, 20));
            desktopPane1.add(label2, JLayeredPane.DEFAULT_LAYER);
            label2.setBounds(310, 165, 105, 35);

            //---- label3 ----
            label3.setText("\u53f7");
            label3.setFont(new Font("\u534e\u6587\u6977\u4f53", Font.BOLD, 20));
            desktopPane1.add(label3, JLayeredPane.DEFAULT_LAYER);
            label3.setBounds(385, 165, 70, 35);

            //---- carrigeNo ----
            carrigeNo.setText("05");
            carrigeNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            desktopPane1.add(carrigeNo, JLayeredPane.DEFAULT_LAYER);
            carrigeNo.setBounds(295, 165, 35, 40);

            //---- seatNo ----
            seatNo.setText("01D");
            seatNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            desktopPane1.add(seatNo, JLayeredPane.DEFAULT_LAYER);
            seatNo.setBounds(355, 165, 35, 40);

            //---- label4 ----
            label4.setText("\u5143");
            desktopPane1.add(label4, JLayeredPane.DEFAULT_LAYER);
            label4.setBounds(new Rectangle(new Point(385, 205), label4.getPreferredSize()));

            //---- sumPrice ----
            sumPrice.setText("165");
            desktopPane1.add(sumPrice, JLayeredPane.DEFAULT_LAYER);
            sumPrice.setBounds(355, 205, 40, sumPrice.getPreferredSize().height);

            //---- orderType ----
            orderType.setText("\u6210\u4eba\u7968");
            orderType.setBorder(LineBorder.createBlackLineBorder());
            desktopPane1.add(orderType, JLayeredPane.DEFAULT_LAYER);
            orderType.setBounds(135, 170, 40, 25);

            //---- trainPassBtn ----
            trainPassBtn.setText("\u65f6\u523b\u8868");
            trainPassBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button1MouseEntered(e);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    button1MouseExited(e);
                }
            });
            desktopPane1.add(trainPassBtn, JLayeredPane.DEFAULT_LAYER);
            trainPassBtn.setBounds(new Rectangle(new Point(175, 80), trainPassBtn.getPreferredSize()));

            //---- seatType ----
            seatType.setText("\u4e8c\u7b49\u5ea7");
            seatType.setBorder(LineBorder.createBlackLineBorder());
            desktopPane1.add(seatType, JLayeredPane.DEFAULT_LAYER);
            seatType.setBounds(310, 200, 40, 25);

            //---- label5 ----
            label5.setText("NO.");
            label5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            desktopPane1.add(label5, JLayeredPane.DEFAULT_LAYER);
            label5.setBounds(5, 5, 25, 25);

            //---- orderNo ----
            orderNo.setText("5");
            desktopPane1.add(orderNo, JLayeredPane.DEFAULT_LAYER);
            orderNo.setBounds(30, 5, 230, 25);
        }
        contentPane.add(desktopPane1);
        desktopPane1.setBounds(0, 0, 470, 320);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JDesktopPane desktopPane1;
    private JLabel startDate;
    private JLabel arriveDate;
    private JLabel startTime;
    private JLabel arriveTime;
    private JLabel startStation;
    private JLabel arriveStation;
    private JLabel label1;
    private JLabel trainNo;
    private JLabel passengerName;
    private JLabel passengerPID;
    private JLabel orderState;
    private JLabel label2;
    private JLabel label3;
    private JLabel carrigeNo;
    private JLabel seatNo;
    private JLabel label4;
    private JLabel sumPrice;
    private JLabel orderType;
    private JButton trainPassBtn;
    private JLabel seatType;
    private JLabel label5;
    private JLabel orderNo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
