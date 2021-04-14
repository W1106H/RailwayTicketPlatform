/*
 * Created by JFormDesigner on Wed Apr 14 15:49:07 CST 2021
 */

package cn.lanqiao.ui.OrdersUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class Order_DetailTrainPass extends JDialog {
    public Order_DetailTrainPass(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u65f6\u523b\u8868");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                },
                new String[] {
                    null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 35, 400, 265);

        //---- label1 ----
        label1.setText("D8481");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        contentPane.add(label1);
        label1.setBounds(5, 10, 60, label1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 305));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
