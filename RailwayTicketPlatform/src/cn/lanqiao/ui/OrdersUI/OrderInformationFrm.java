/*
 * Created by JFormDesigner on Mon Apr 12 16:37:17 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import cn.lanqiao.entity.Peoples.Orders;
import cn.lanqiao.service.OrderService;
import cn.lanqiao.service.impl.OrderServiceImpl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class OrderInformationFrm extends JFrame {
    static private JDesktopPane desktopPane1;
    private String[] table1Title = {"订单编号","列车号","起始站","到达站","出发时间","票价","乘客姓名"};
    public OrderInformationFrm() {
        initComponents();
        init();
    }

    public static void setVis()
    {
        desktopPane1.setVisible(true);
    }

    private void init(){
        setSize(875, 505);
        frmContainer.setBackground(new Color(102, 153, 255));
        desktopPane2.setVisible(true);
        historicalOrdersTable.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] {}
        ));
        OrderService orderService = new OrderServiceImpl();
        currentPage.setText(String.valueOf(1));
        int currentPage=Integer.parseInt(this.currentPage.getText());
        int pageCount=(orderService.getHistoricalOrders_Count("1001")%2)==0?(orderService.getHistoricalOrders_Count("1001")/2):((orderService.getHistoricalOrders_Count("1001")/2)+1);
        this.pageCount.setText(String.valueOf(pageCount));
        Object[][] table1List = orderService.getHistoricalOrders("1001",currentPage);
        historicalOrdersTable.setModel(new DefaultTableModel(
                table1List,
                table1Title
        ));
    }

    private void menu2MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void menu2MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void menuItem3MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void menuItem3MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void menuItem4MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void menuItem4MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void menuItem5MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void menuItem5MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void menu3MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void menu3MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void tabbedPane2MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void tabbedPane2MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void menuItem5ActionPerformed(ActionEvent e) {
        desktopPane1.setVisible(false);
        desktopPane2.setVisible(false);
        // TODO add your code here
//        已经打开过的“已支付订单”不可以再次打开
        JInternalFrame[] childFrame = frmContainer.getAllFrames();
        JInternalFrame currentFrame = null;
        for (JInternalFrame f : childFrame) {
            if("已支付订单".equals(f.getTitle())){
                currentFrame = f;
                break;
            }
        }
        if(currentFrame == null){
            Order_AlreadyPayIFrm order_alreadyPayIFrm = new Order_AlreadyPayIFrm();
            if (order_alreadyPayIFrm.judge()) {
                order_alreadyPayIFrm.setVisible(true);
                frmContainer.add(order_alreadyPayIFrm);
            }
        }
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        desktopPane1.setVisible(false);
        desktopPane2.setVisible(false);
        // TODO add your code here
//        已经打开过的“未支付订单”不可以再次打开
        JInternalFrame[] childFrame = frmContainer.getAllFrames();
        JInternalFrame currentFrame = null;
        for (JInternalFrame f : childFrame) {
            if("未支付订单".equals(f.getTitle())){
                currentFrame = f;
                break;
            }
        }
        if(currentFrame == null){
            Order_UnPayIFrm order_unPayIFrm = new Order_UnPayIFrm();
            order_unPayIFrm.setVisible(true);
            frmContainer.add(order_unPayIFrm);
        }
    }

    private void historialsOrdersActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void lastPageActionPerformed(ActionEvent e) {
        int current = Integer.parseInt(currentPage.getText());
        System.out.println("last"+current);
        if(current==1)
            JOptionPane.showMessageDialog(desktopPane1,"当前已是第一页！");
        if(current>=2)
        {
            currentPage.setText(String.valueOf(current-1));
            OrderService orderService = new OrderServiceImpl();
            Object[][] table1List = orderService.getHistoricalOrders("1001",current-1);
            historicalOrdersTable.setModel(new DefaultTableModel(
                    table1List,
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
            Object[][] tableList= orderService.getHistoricalOrders("1001",current+1);
            historicalOrdersTable.setModel(new DefaultTableModel(
                    tableList,
                    table1Title
            ));
        }
        else
            JOptionPane.showMessageDialog(desktopPane1,"当前已是最后一页！");
    }

    private void firstPageActionPerformed(ActionEvent e) {
        currentPage.setText(String.valueOf(1));
        int current= Integer.parseInt(currentPage.getText());
        OrderService orderService = new OrderServiceImpl();
        Object[][] tableList = orderService.getHistoricalOrders("1001",current);
        historicalOrdersTable.setModel(new DefaultTableModel(
                tableList,
                table1Title
        ));
    }

    private void menu3MouseClicked(MouseEvent e) {
        // TODO add your code here
        desktopPane1.setVisible(false);
        desktopPane2.setVisible(true);
        OrderService orderService = new OrderServiceImpl();
        Object[][] personalTicket = orderService.getPersonalTicket("450000200010090022");
        if(personalTicket == null){
            JOptionPane.showMessageDialog(desktopPane2,"暂无本人车票信息");
        }else{
            personalTicketTable.setModel(new DefaultTableModel(
                    personalTicket,
                    table1Title
            ));
        }
    }

    private void personalTicketFlushMouseClicked(MouseEvent e) {
        // TODO add your code here
        OrderService orderService = new OrderServiceImpl();
        Object[][] personalTicket = orderService.getPersonalTicket("450000200010090022");
        if(personalTicket == null){
            JOptionPane.showMessageDialog(desktopPane2,"暂无本人车票信息");
        }else{
            personalTicketTable.setModel(new DefaultTableModel(
                    personalTicket,
                    table1Title
            ));
        }
    }

    private void personalTicketFlushMouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void personalTicketFlushMouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void checkDetailMouseClicked(MouseEvent e) {
        // TODO add your code here
        OrderService orderService = new OrderServiceImpl();
        if(personalTicketTable.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(personalTicketTable,"请选择需要查看的行");
            return ;
        }
        String orderNo = personalTicketTable.getValueAt(personalTicketTable.getSelectedRow(), 0).toString();  //获得订单号
        Orders detailOrder = orderService.getDetailOrder(orderNo);
        if(detailOrder != null){
            Order_Detail order_detail = new Order_Detail(detailOrder);
            order_detail.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(personalTicketTable,"服务器开小差了~稍后再试试");
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar2 = new JMenuBar();
        menu2 = new JMenu();
        unPayOrders = new JMenuItem();
        alreadyPayOrders = new JMenuItem();
        menu3 = new JMenu();
        frmContainer = new JDesktopPane();
        desktopPane1 = new JDesktopPane();
        scrollPane1 = new JScrollPane();
        historicalOrdersTable = new JTable();
        lastPage = new JButton();
        nextPage = new JButton();
        firstPage = new JButton();
        currentPage = new JLabel();
        label1 = new JLabel();
        pageCount = new JLabel();
        desktopPane2 = new JDesktopPane();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        personalTicketTable = new JTable();
        personalTicketFlush = new JButton();
        checkDetail = new JButton();

        //======== this ========
        setTitle("\u8ba2\u5355\u4fe1\u606f\u67e5\u8be2");
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/mainLogo.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar2 ========
        {

            //======== menu2 ========
            {
                menu2.setText("\u8ba2\u5355\u4fe1\u606f");
                menu2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        menu2MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        menu2MouseExited(e);
                    }
                });
                menu2.addSeparator();

                //---- unPayOrders ----
                unPayOrders.setText("\u672a\u652f\u4ed8\u8ba2\u5355");
                unPayOrders.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));
                unPayOrders.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        menuItem4MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        menuItem4MouseExited(e);
                    }
                });
                unPayOrders.addActionListener(e -> menuItem4ActionPerformed(e));
                menu2.add(unPayOrders);

                //---- alreadyPayOrders ----
                alreadyPayOrders.setText("\u5df2\u652f\u4ed8\u8ba2\u5355");
                alreadyPayOrders.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
                alreadyPayOrders.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        menuItem5MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        menuItem5MouseExited(e);
                    }
                });
                alreadyPayOrders.addActionListener(e -> menuItem5ActionPerformed(e));
                menu2.add(alreadyPayOrders);
            }
            menuBar2.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u672c\u4eba\u8f66\u7968");
                menu3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menu3MouseClicked(e);
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        menu3MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        menu3MouseExited(e);
                    }
                });
            }
            menuBar2.add(menu3);
        }
        setJMenuBar(menuBar2);

        //======== frmContainer ========
        {
            frmContainer.setBackground(new Color(102, 153, 255));

            //======== desktopPane1 ========
            {
                desktopPane1.setBackground(new Color(102, 153, 255));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(historicalOrdersTable);
                }
                desktopPane1.add(scrollPane1, JLayeredPane.DEFAULT_LAYER);
                scrollPane1.setBounds(0, 40, 860, 335);

                //---- lastPage ----
                lastPage.setText("\u4e0a\u4e00\u9875");
                lastPage.addActionListener(e -> lastPageActionPerformed(e));
                desktopPane1.add(lastPage, JLayeredPane.DEFAULT_LAYER);
                lastPage.setBounds(new Rectangle(new Point(540, 380), lastPage.getPreferredSize()));

                //---- nextPage ----
                nextPage.setText("\u4e0b\u4e00\u9875");
                nextPage.addActionListener(e -> nextPageActionPerformed(e));
                desktopPane1.add(nextPage, JLayeredPane.DEFAULT_LAYER);
                nextPage.setBounds(new Rectangle(new Point(755, 380), nextPage.getPreferredSize()));

                //---- firstPage ----
                firstPage.setText("\u7b2c\u4e00\u9875");
                firstPage.addActionListener(e -> firstPageActionPerformed(e));
                desktopPane1.add(firstPage, JLayeredPane.DEFAULT_LAYER);
                firstPage.setBounds(new Rectangle(new Point(645, 380), firstPage.getPreferredSize()));

                //---- currentPage ----
                currentPage.setText("\u5f53\u524d\u9875");
                currentPage.setEnabled(false);
                desktopPane1.add(currentPage, JLayeredPane.DEFAULT_LAYER);
                currentPage.setBounds(675, 345, 50, currentPage.getPreferredSize().height);

                //---- label1 ----
                label1.setText("\u6240\u6709\u8ba2\u5355\u5217\u8868");
                label1.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 24));
                desktopPane1.add(label1, JLayeredPane.DEFAULT_LAYER);
                label1.setBounds(350, 10, 165, 22);

                //---- pageCount ----
                pageCount.setText("\u9875\u6570");
                pageCount.setEnabled(false);
                desktopPane1.add(pageCount, JLayeredPane.DEFAULT_LAYER);
                pageCount.setBounds(555, 355, 65, pageCount.getPreferredSize().height);
            }
            frmContainer.add(desktopPane1, JLayeredPane.DEFAULT_LAYER);
            desktopPane1.setBounds(0, 0, 865, 410);

            //======== desktopPane2 ========
            {
                desktopPane2.setBackground(new Color(102, 153, 255));

                //---- label2 ----
                label2.setText("\u672c\u4eba\u8f66\u7968");
                label2.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 24));
                desktopPane2.add(label2, JLayeredPane.DEFAULT_LAYER);
                label2.setBounds(375, 10, 105, 22);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(personalTicketTable);
                }
                desktopPane2.add(scrollPane2, JLayeredPane.DEFAULT_LAYER);
                scrollPane2.setBounds(0, 40, 855, 335);

                //---- personalTicketFlush ----
                personalTicketFlush.setText("\u5237\u65b0");
                personalTicketFlush.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        personalTicketFlushMouseClicked(e);
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        personalTicketFlushMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        personalTicketFlushMouseExited(e);
                    }
                });
                desktopPane2.add(personalTicketFlush, JLayeredPane.DEFAULT_LAYER);
                personalTicketFlush.setBounds(new Rectangle(new Point(350, 380), personalTicketFlush.getPreferredSize()));

                //---- checkDetail ----
                checkDetail.setText("\u67e5\u770b\u8be6\u60c5");
                checkDetail.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        checkDetailMouseClicked(e);
                    }
                });
                desktopPane2.add(checkDetail, JLayeredPane.DEFAULT_LAYER);
                checkDetail.setBounds(new Rectangle(new Point(450, 380), checkDetail.getPreferredSize()));
            }
            frmContainer.add(desktopPane2, JLayeredPane.DEFAULT_LAYER);
            desktopPane2.setBounds(0, 0, 865, 410);
        }
        contentPane.add(frmContainer, BorderLayout.CENTER);
        setSize(860, 480);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar2;
    private JMenu menu2;
    private JMenuItem unPayOrders;
    private JMenuItem alreadyPayOrders;
    private JMenu menu3;
    private JDesktopPane frmContainer;
    private JScrollPane scrollPane1;
    private JTable historicalOrdersTable;
    private JButton lastPage;
    private JButton nextPage;
    private JButton firstPage;
    private JLabel currentPage;
    private JLabel label1;
    private JLabel pageCount;
    private JDesktopPane desktopPane2;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTable personalTicketTable;
    private JButton personalTicketFlush;
    private JButton checkDetail;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        OrderInformationFrm orderInformationFrm = new OrderInformationFrm();
        orderInformationFrm.setVisible(true);
    }
}
