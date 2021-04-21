/*
 * Created by JFormDesigner on Sat Apr 17 14:38:30 GMT+08:00 2021
 */

package cn.lanqiao.ui;

import java.awt.event.*;

import cn.lanqiao.dao.OrderDao;
import cn.lanqiao.dao.impl.OrderDaoImpl;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.OrderService;
import cn.lanqiao.service.PassengerService;
import cn.lanqiao.service.impl.OrderServiceImpl;
import cn.lanqiao.service.impl.PassengerServiceImpl;
import cn.lanqiao.ui.OrdersUI.CertainToPay;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class AllPassenger extends JDialog {
    private String[] header ={"姓名","身份证号","电话号码","性别"};
    public User currentUser = null;
    private PassengerService passengerService = new PassengerServiceImpl();
    private Object[][] order=new Object[1][];
    private String year_month_day;
    private int ticketType;//学生票为1  成人票为2
    private int price;
    public AllPassenger(User currentUser,Object[][] order,String year_month_day,int ticketType,int price) {
        this.currentUser = currentUser;
        this.order=order;
        this.year_month_day = year_month_day;
        this.ticketType = ticketType;
        this.price = price;
        initComponents();
        init();
        this.setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/mainLogo.png")).getImage());
    }
    private void init() {
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    passengerService.getAllPassenger(currentUser),
                    header
            ));
            table1.setAutoCreateRowSorter(true);
            scrollPane1.setViewportView(table1);
        }
    }

    private void btncreatOrderActionPerformed(ActionEvent e) {
        java.util.Date startData=null;
        java.util.Date endData=null;
        int selectedRow = table1.getSelectedRow();
        if (table1.getSelectedRow()>=0) {
            String passengerId = table1.getValueAt(selectedRow, 1).toString();
            String trainNum = order[0][0].toString();
            String startTime = year_month_day + " " + order[0][1].toString();
            String endTime = year_month_day + " " + order[0][2].toString();
            String startNo = order[0][3].toString();
            String endNo = order[0][4].toString();
            String creator = order[0][5].toString();
            Date creatTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                startData = sdf.parse(startTime);
                endData = sdf.parse(endTime);

            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            OrderService orderService = new OrderServiceImpl();
            String order_no = UUID.randomUUID().toString();
            boolean flag = orderService.addOrderIncludeUuid(order_no, passengerId, trainNum, startNo, endNo, startData, endData, currentUser.getPId(), price, ticketType);
            if (flag) {
                String passengerName = (String) table1.getValueAt(table1.getSelectedRow(), 0);
                CertainToPay certainToPay = new CertainToPay(order_no,passengerName);
                certainToPay.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "订单创建失败");
            }
        } else {
            JOptionPane.showMessageDialog(null,"请选择乘客");
        }

    }

    private void btnaddpassengActionPerformed(ActionEvent e) {
        // TODO add your code here
        new AddPassengerJDialog(currentUser).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btncreatOrder = new JButton();
        btnaddpasseng = new JButton();

        //======== this ========
        setTitle("\u4e58\u5ba2\u4fe1\u606f");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    null, null, null, null
                }
            ));
            table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 485, 285);

        //---- btncreatOrder ----
        btncreatOrder.setText("\u8ba2\u7968");
        btncreatOrder.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        btncreatOrder.addActionListener(e -> btncreatOrderActionPerformed(e));
        contentPane.add(btncreatOrder);
        btncreatOrder.setBounds(new Rectangle(new Point(400, 295), btncreatOrder.getPreferredSize()));

        //---- btnaddpasseng ----
        btnaddpasseng.setText("\u6dfb\u52a0\u4e58\u5ba2");
        btnaddpasseng.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        btnaddpasseng.addActionListener(e -> btnaddpassengActionPerformed(e));
        contentPane.add(btnaddpasseng);
        btnaddpasseng.setBounds(new Rectangle(new Point(305, 295), btnaddpasseng.getPreferredSize()));

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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btncreatOrder;
    private JButton btnaddpasseng;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
