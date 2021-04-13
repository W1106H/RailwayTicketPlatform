/*
 * Created by JFormDesigner on Tue Apr 13 11:26:50 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Brainrain
 */
public class Order_UnPayIFrm extends JInternalFrame {
    public Order_UnPayIFrm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setTitle("\u672a\u652f\u4ed8\u8ba2\u5355");
        setBorder(LineBorder.createBlackLineBorder());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 750, scrollPane1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(750, 445));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setBounds(0, 0, 850, 415);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
