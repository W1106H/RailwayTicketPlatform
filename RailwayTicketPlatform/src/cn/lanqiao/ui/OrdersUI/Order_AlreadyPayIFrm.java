/*
 * Created by JFormDesigner on Mon Apr 12 17:42:22 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import java.awt.event.*;
import cn.lanqiao.service.OrderService;
import cn.lanqiao.service.impl.OrderServiceImpl;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class Order_AlreadyPayIFrm extends JInternalFrame {
    private String userName;
    private String[] table1Title = {"订单编号","列车号","起始站","到达站","出发时间","票价","乘客姓名"};

    public Order_AlreadyPayIFrm() {
        initComponents();
        init();
    }

    private void init(){
        scrollPane1.setBounds(0, 0, 840, 325);
        tabbedPane1.setBounds(0, 0, 845, 390);
        button1.setVisible(true);
//        初始化table1：未出行订单
        table1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {}
        ));
        OrderService orderService = new OrderServiceImpl();
        Object[][] table1DetailInfo = orderService.getOrderAlreadyPay("450000200010090022");
        if (orderService.getOrderAlreadyPay_JudgeFlag() == false){
            JOptionPane.showMessageDialog(table1,"暂无订单信息");
            this.flagOfTable1 = false;
        }
        else {
            table1.setModel(new DefaultTableModel(
                    table1DetailInfo,
                    table1Title
            ));
            this.flagOfTable1 = true;
        }
    }

    public boolean judge(){
        return flagOfTable1;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        OrderService orderService = new OrderServiceImpl();
        Object[][] orderAlreadyPay = orderService.getOrderAlreadyPay("450000200010090022");
        if (orderService.getOrderAlreadyPay_JudgeFlag() == false){
            JOptionPane.showMessageDialog(table1,"暂无订单信息");
            this.flagOfTable1 = false;
        }
        else {
            table1.setModel(new DefaultTableModel(
                    orderAlreadyPay,
                    table1Title
            ));
            this.flagOfTable1 = true;
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(table1.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(tabbedPane1,"请选择需要删除的行");
            return ;
        }
        int confirmDialog = JOptionPane.showConfirmDialog(tabbedPane1, "是否确认删除？");
        if(confirmDialog == 0){
            OrderService orderService = new OrderServiceImpl();
            String orderNo = table1.getValueAt(table1.getSelectedRow(), 0).toString();
            boolean orderAlreadyPay_setVisible = orderService.getOrderAlreadyPay_SetVisible(orderNo);
            if(orderAlreadyPay_setVisible){
                JOptionPane.showMessageDialog(tabbedPane1,"删除成功！");
                Object[][] orderAlreadyPay = orderService.getOrderAlreadyPay("450000200010090022");
                table1.setModel(new DefaultTableModel(
                        orderAlreadyPay,
                        table1Title
                ));
                this.flagOfTable1 = true;
            }else {
                JOptionPane.showMessageDialog(tabbedPane1,"删除失败！");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        desktopPane1 = new JDesktopPane();
        desktopPane2 = new JDesktopPane();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setVisible(true);
        setBorder(LineBorder.createBlackLineBorder());
        setTitle("\u5df2\u652f\u4ed8\u8ba2\u5355");
        setClosable(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.addTab("\u672a\u51fa\u884c\u8ba2\u5355", desktopPane1);

            //======== desktopPane2 ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }
                desktopPane2.add(scrollPane1, JLayeredPane.DEFAULT_LAYER);
                scrollPane1.setBounds(5, 0, 550, 215);

                //---- button1 ----
                button1.setText("\u5237\u65b0");
                button1.addActionListener(e -> button1ActionPerformed(e));
                desktopPane2.add(button1, JLayeredPane.DEFAULT_LAYER);
                button1.setBounds(5, 330, 95, 30);

                //---- button2 ----
                button2.setText("\u67e5\u770b\u8be6\u60c5");
                desktopPane2.add(button2, JLayeredPane.DEFAULT_LAYER);
                button2.setBounds(110, 330, 95, 30);

                //---- button3 ----
                button3.setText("\u5220\u9664\u8ba2\u5355");
                button3.addActionListener(e -> button3ActionPerformed(e));
                desktopPane2.add(button3, JLayeredPane.DEFAULT_LAYER);
                button3.setBounds(215, 330, 95, 30);
            }
            tabbedPane1.addTab("\u5df2\u51fa\u884c\u8ba2\u5355", desktopPane2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 750, 455);

        contentPane.setPreferredSize(new Dimension(750, 475));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setBounds(0, 0, 850, 415);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JDesktopPane desktopPane1;
    private JDesktopPane desktopPane2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private boolean flagOfTable1 = false;
}
