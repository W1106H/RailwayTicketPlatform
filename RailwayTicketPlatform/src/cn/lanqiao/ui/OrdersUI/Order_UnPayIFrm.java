/*
 * Created by JFormDesigner on Tue Apr 13 11:26:50 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import java.awt.event.*;
import javax.swing.event.*;

import cn.lanqiao.entity.Peoples.Orders;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.OrderService;
import cn.lanqiao.service.TrainInforService;
import cn.lanqiao.service.impl.OrderServiceImpl;
import cn.lanqiao.service.impl.TrainInforServiceimpl;
import cn.lanqiao.util.ClientUtil;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class Order_UnPayIFrm extends JInternalFrame {
    public User user;
    private String[] table1Title = {"订单编号","列车号","起始站","到达站","出发时间","票价","乘客姓名"};
    public Order_UnPayIFrm(User user) {
        this.user=user;
        initComponents();
        init();
    }

    private void init(){
        scrollPane1.setBounds(0, 0, 840, 325);
        this.setSize(865, 420);
//        初始化table2：未支付订单
        table1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {}
        ));

        currentPage.setText(String.valueOf(1));
        int currentPage=Integer.parseInt(this.currentPage.getText());
        OrderService orderService = new OrderServiceImpl();
        String userPID=user.getPId();
        int pageCount=(orderService.getOrderNotPay_Count(userPID)%2)==0?(orderService.getOrderNotPay_Count(userPID)/2):(orderService.getOrderNotPay_Count(userPID)/2)+1;
        this.pageCount.setText(String.valueOf(pageCount));
        Object[][] talbeUnpay = orderService.getOrderNotPay(userPID,currentPage);
        table1.setModel(new DefaultTableModel(
                talbeUnpay,
                table1Title
        ));
    }

    private void lastPageActionPerformed(ActionEvent e) {
        int current = Integer.parseInt(currentPage.getText());
        if(current==1)
            JOptionPane.showMessageDialog(this,"当前已是第一页！");
        if(current>=2)
        {
            currentPage.setText(String.valueOf(current-1));
            OrderService orderService = new OrderServiceImpl();
            String userPID=user.getPId();
            Object[][] orderNotPay = orderService.getOrderNotPay(userPID,current);
            table1.setModel(new DefaultTableModel(
                    orderNotPay,
                    table1Title
            ));
        }
    }

    private void nextPageActionPerformed(ActionEvent e) {
        int current = Integer.parseInt(currentPage.getText());
        int pagecount= Integer.parseInt(pageCount.getText());
        if(pagecount!=current)
        {
            currentPage.setText(String.valueOf(current+1));
            OrderService orderService = new OrderServiceImpl();
            String userPID=user.getPId();
            Object[][] orderNotPay = orderService.getOrderNotPay(userPID,current);
            table1.setModel(new DefaultTableModel(
                    orderNotPay,
                    table1Title
            ));
        }
        else
            JOptionPane.showMessageDialog(this,"当前已是最后一页！");
    }

    private void thisInternalFrameActivated(InternalFrameEvent e) {
        OrderInformationFrm.setVis();
    }

    private void refreshActionPerformed(ActionEvent e) {
        int currentPage = Integer.parseInt(this.currentPage.getText());
        System.out.println(currentPage);
        OrderService orderService = new OrderServiceImpl();
        String userPID=user.getPId();
        Object[][] orderNotPay = orderService.getOrderNotPay(userPID,currentPage);
        table1.setModel(new DefaultTableModel(
                orderNotPay,
                table1Title
        ));
    }

    private void deleteOrderActionPerformed(ActionEvent e) {
        OrderService orderService = new OrderServiceImpl();
        if(table1.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(table1,"请选择想要删除的订单");
            return ;
        }
        int confirmDialog = JOptionPane.showConfirmDialog(table1, "是否确认删除？");
        if(confirmDialog==0) {
            String orderNo = table1.getValueAt(table1.getSelectedRow(), 0).toString();  //获得订单号
            String pid = orderService.getOrderByOrderNo(orderNo).getPid();
            String trainNum = orderService.getOrderByOrderNo(orderNo).getTrain_No();
            String startStationNum = orderService.getOrderByOrderNo(orderNo).getStation_Start_No();
            String endStationNum = orderService.getOrderByOrderNo(orderNo).getStation_End_NO();
            TrainInforService trainInforService = new TrainInforServiceimpl();
            trainInforService.refundTicket(orderNo, trainNum, startStationNum, endStationNum);
            String hostIp = ClientUtil.getHostIp();
            String refundTicketString = ClientUtil.generateRefundTicketString(hostIp, orderNo, trainNum, startStationNum, endStationNum);
            ClientUtil.sendInfo(refundTicketString);
            boolean receiveFlag = ClientUtil.receiveInfo();
            int current = Integer.parseInt(currentPage.getText());
            Object[][] orderNotPay = orderService.getOrderNotPay(pid, current);
            table1.setModel(new DefaultTableModel(
                    orderNotPay,
                    table1Title
            ));
            if (receiveFlag) {
                JOptionPane.showMessageDialog(table1, "订单删除成功！");
            } else {
                JOptionPane.showMessageDialog(table1, "服务器开小差了~等会儿再来试试吧~ -.-~");
            }
        }

    }

    private void goToPayMouseClicked(MouseEvent e) {
        OrderService orderService = new OrderServiceImpl();
        if(table1.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(table1,"请选择想要支付的订单");
            return ;
        }
        int confirmDialog = JOptionPane.showConfirmDialog(table1, "是否确认支付？");
        if(confirmDialog==0){
            String orderNo = table1.getValueAt(table1.getSelectedRow(), 0).toString();  //获得订单号
            String pid = orderService.getOrderByOrderNo(orderNo).getPid();
            String trainNum = orderService.getOrderByOrderNo(orderNo).getTrain_No();
            String startStationNum = orderService.getOrderByOrderNo(orderNo).getStation_Start_No();
            String endStationNum = orderService.getOrderByOrderNo(orderNo).getStation_End_NO();
            String hostIp = ClientUtil.getHostIp();
            String generateBuyTicketString = ClientUtil.generateBuyTicketString(hostIp, trainNum, startStationNum, endStationNum);
            ClientUtil.sendInfo(generateBuyTicketString);
            boolean bBoolean = ClientUtil.receiveInfo();
            Boolean aBoolean = orderService.updateOrderState(orderNo);
            if(aBoolean && bBoolean)
                JOptionPane.showMessageDialog(table1, "订单支付成功！");
            else
                JOptionPane.showMessageDialog(table1, "订单支付失败！");
            int current = Integer.parseInt(currentPage.getText());
            Object[][] orderNotPay = orderService.getOrderNotPay(pid, current);
            table1.setModel(new DefaultTableModel(
                    new Object[][] {},
                    new String[] {}
            ));
            table1.setModel(new DefaultTableModel(
                    orderNotPay,
                    table1Title
            ));
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        refresh = new JButton();
        goToPay = new JButton();
        deleteOrder = new JButton();
        lastPage = new JButton();
        firstPage = new JButton();
        nextPage = new JButton();
        currentPage = new JLabel();
        pageCount = new JLabel();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setTitle("\u672a\u652f\u4ed8\u8ba2\u5355");
        setBorder(null);
        setBackground(new Color(102, 153, 255));
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                thisInternalFrameActivated(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 10, 750, 295);

        //---- refresh ----
        refresh.setText("\u5237\u65b0");
        refresh.addActionListener(e -> refreshActionPerformed(e));
        contentPane.add(refresh);
        refresh.setBounds(5, 330, 95, 30);

        //---- goToPay ----
        goToPay.setText("\u53bb\u652f\u4ed8");
        goToPay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goToPayMouseClicked(e);
            }
        });
        contentPane.add(goToPay);
        goToPay.setBounds(115, 330, 90, 30);

        //---- deleteOrder ----
        deleteOrder.setText("\u5220\u9664\u8ba2\u5355");
        deleteOrder.addActionListener(e -> deleteOrderActionPerformed(e));
        contentPane.add(deleteOrder);
        deleteOrder.setBounds(225, 330, 90, 30);

        //---- lastPage ----
        lastPage.setText("\u4e0a\u4e00\u9875");
        lastPage.addActionListener(e -> lastPageActionPerformed(e));
        contentPane.add(lastPage);
        lastPage.setBounds(480, 330, 80, 25);

        //---- firstPage ----
        firstPage.setText("\u7b2c\u4e00\u9875");
        contentPane.add(firstPage);
        firstPage.setBounds(570, 330, 80, 25);

        //---- nextPage ----
        nextPage.setText("\u4e0b\u4e00\u9875");
        nextPage.addActionListener(e -> nextPageActionPerformed(e));
        contentPane.add(nextPage);
        nextPage.setBounds(660, 330, 80, 25);

        //---- currentPage ----
        currentPage.setText("\u5f53\u524d\u9875");
        currentPage.setEnabled(false);
        contentPane.add(currentPage);
        currentPage.setBounds(new Rectangle(new Point(520, 270), currentPage.getPreferredSize()));

        //---- pageCount ----
        pageCount.setText("\u9875\u6570");
        pageCount.setEnabled(false);
        contentPane.add(pageCount);
        pageCount.setBounds(new Rectangle(new Point(620, 270), pageCount.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(750, 445));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton refresh;
    private JButton goToPay;
    private JButton deleteOrder;
    private JButton lastPage;
    private JButton firstPage;
    private JButton nextPage;
    private JLabel currentPage;
    private JLabel pageCount;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
