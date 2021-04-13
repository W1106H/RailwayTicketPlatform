/*
 * Created by JFormDesigner on Mon Apr 12 16:37:17 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class OrderInformationFrm extends JFrame {

    public OrderInformationFrm() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar2 = new JMenuBar();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu3 = new JMenu();
        frmContainer = new JDesktopPane();

        //======== this ========
        setTitle("\u8ba2\u5355\u4fe1\u606f\u67e5\u8be2");
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

                //---- menuItem3 ----
                menuItem3.setText("\u6240\u6709\u5386\u53f2\u8ba2\u5355");
                menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
                menuItem3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        menuItem3MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        menuItem3MouseExited(e);
                    }
                });
                menu2.add(menuItem3);
                menu2.addSeparator();

                //---- menuItem4 ----
                menuItem4.setText("\u672a\u652f\u4ed8\u8ba2\u5355");
                menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));
                menuItem4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        menuItem4MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        menuItem4MouseExited(e);
                    }
                });
                menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
                menu2.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("\u5df2\u652f\u4ed8\u8ba2\u5355");
                menuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
                menuItem5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        menuItem5MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        menuItem5MouseExited(e);
                    }
                });
                menuItem5.addActionListener(e -> menuItem5ActionPerformed(e));
                menu2.add(menuItem5);
            }
            menuBar2.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u672c\u4eba\u8f66\u7968");
                menu3.addMouseListener(new MouseAdapter() {
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
        contentPane.add(frmContainer, BorderLayout.CENTER);
        setSize(865, 480);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenu menu3;
    private JDesktopPane frmContainer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        OrderInformationFrm orderInformationFrm = new OrderInformationFrm();
        orderInformationFrm.setVisible(true);
    }
}
