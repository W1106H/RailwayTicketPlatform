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
        currentPage.setText(String.valueOf(1));
        int currentPage=Integer.parseInt(this.currentPage.getText());
        int pageCount=(orderService.getOrderAlreadyPay_Count("1001")%2)==0?(orderService.getOrderAlreadyPay_Count("1001")/2):(orderService.getOrderAlreadyPay_Count("1001")/2)+1;
        this.pageCount.setText(String.valueOf(pageCount));

        Object[][] table1DetailInfo = orderService.getOrderAlreadyPay("1001",currentPage);
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
        int currentPage = Integer.parseInt(this.currentPage.getText());
        OrderService orderService = new OrderServiceImpl();
        Object[][] orderAlreadyPay = orderService.getOrderAlreadyPay("1001",currentPage);
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
            currentPage.setText(String.valueOf(1));
            int currentPage=Integer.parseInt(this.currentPage.getText());

            OrderService orderService = new OrderServiceImpl();
            String orderNo = table1.getValueAt(table1.getSelectedRow(), 0).toString();
            boolean orderAlreadyPay_setVisible = orderService.getOrderAlreadyPay_SetVisible(orderNo);
            if(orderAlreadyPay_setVisible){
                JOptionPane.showMessageDialog(tabbedPane1,"删除成功！");
                Object[][] orderAlreadyPay = orderService.getOrderAlreadyPay("1001",currentPage);
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

    private void lastPageActionPerformed(ActionEvent e) {
        int current = Integer.parseInt(currentPage.getText());
        if(current==1)
            JOptionPane.showMessageDialog(tabbedPane1,"当前已是第一页！");
        if(current>=2)
        {
            currentPage.setText(String.valueOf(current-1));
            OrderService orderService = new OrderServiceImpl();
            Object[][] orderAlreadyPay = orderService.getOrderAlreadyPay("1001",current);
            table1.setModel(new DefaultTableModel(
                    orderAlreadyPay,
                    table1Title
            ));
            this.flagOfTable1 = true;
        }
    }

    private void nextPageActionPerformed(ActionEvent e) {
        int current = Integer.parseInt(currentPage.getText());
        int pagecount= Integer.parseInt(pageCount.getText());
        if(pagecount>=current)
        {
            currentPage.setText(String.valueOf(current+1));
            OrderService orderService = new OrderServiceImpl();
            Object[][] orderAlreadyPay = orderService.getOrderAlreadyPay("1001",current);
            table1.setModel(new DefaultTableModel(
                    orderAlreadyPay,
                    table1Title
            ));
            this.flagOfTable1 = true;
        }
        else
            JOptionPane.showMessageDialog(tabbedPane1,"当前已是最后一页！");
    }

    private void firstPageActionPerformed(ActionEvent e) {
        currentPage.setText(String.valueOf(1));
        int current= Integer.parseInt(currentPage.getText());
        OrderService orderService = new OrderServiceImpl();
        Object[][] orderAlreadyPay = orderService.getOrderAlreadyPay("1001",current);
        table1.setModel(new DefaultTableModel(
                orderAlreadyPay,
                table1Title
        ));
        this.flagOfTable1 = true;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        desktopPane2 = new JDesktopPane();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        上一页 = new JButton();
        下一页 = new JButton();
        firstPage = new JButton();
        currentPage = new JLabel();
        pageCount = new JLabel();
        lastPage = new JLabel();
        nextPage = new JLabel();
        desktopPane1 = new JDesktopPane();

        //======== this ========
        setVisible(true);
        setBorder(LineBorder.createBlackLineBorder());
        setTitle("\u5df2\u652f\u4ed8\u8ba2\u5355");
        setClosable(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

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

                //---- 上一页 ----
                上一页.setText("\u4e0a\u4e00\u9875");
                上一页.addActionListener(e -> lastPageActionPerformed(e));
                desktopPane2.add(上一页, JLayeredPane.DEFAULT_LAYER);
                上一页.setBounds(485, 330, 80, 25);

                //---- 下一页 ----
                下一页.setText("\u4e0b\u4e00\u9875");
                下一页.addActionListener(e -> nextPageActionPerformed(e));
                desktopPane2.add(下一页, JLayeredPane.DEFAULT_LAYER);
                下一页.setBounds(655, 330, 80, 25);

                //---- firstPage ----
                firstPage.setText("\u7b2c\u4e00\u9875");
                firstPage.addActionListener(e -> firstPageActionPerformed(e));
                desktopPane2.add(firstPage, JLayeredPane.DEFAULT_LAYER);
                firstPage.setBounds(570, 330, 80, 25);

                //---- currentPage ----
                currentPage.setText("\u5f53\u524d\u9875");
                currentPage.setEnabled(false);
                desktopPane2.add(currentPage, JLayeredPane.DEFAULT_LAYER);
                currentPage.setBounds(555, 365, 50, currentPage.getPreferredSize().height);

                //---- pageCount ----
                pageCount.setText("\u9875\u6570");
                pageCount.setEnabled(false);
                desktopPane2.add(pageCount, JLayeredPane.DEFAULT_LAYER);
                pageCount.setBounds(615, 365, 50, pageCount.getPreferredSize().height);

                //---- lastPage ----
                lastPage.setText("\u4e0a\u4e00\u9875");
                lastPage.setEnabled(false);
                desktopPane2.add(lastPage, JLayeredPane.DEFAULT_LAYER);
                lastPage.setBounds(490, 365, 50, lastPage.getPreferredSize().height);

                //---- nextPage ----
                nextPage.setText("\u4e0b\u4e00\u9875");
                nextPage.setEnabled(false);
                desktopPane2.add(nextPage, JLayeredPane.DEFAULT_LAYER);
                nextPage.setBounds(665, 365, 70, nextPage.getPreferredSize().height);
            }
            tabbedPane1.addTab("\u5df2\u51fa\u884c\u8ba2\u5355", desktopPane2);
            tabbedPane1.addTab("\u672a\u51fa\u884c\u8ba2\u5355", desktopPane1);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 750, 455);

        contentPane.setPreferredSize(new Dimension(750, 475));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setBounds(0, 0, 850, 415);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JDesktopPane desktopPane2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton 上一页;
    private JButton 下一页;
    private JButton firstPage;
    private JLabel currentPage;
    private JLabel pageCount;
    private JLabel lastPage;
    private JLabel nextPage;
    private JDesktopPane desktopPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private boolean flagOfTable1 = false;
}
