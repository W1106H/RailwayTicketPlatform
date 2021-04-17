/*
 * Created by JFormDesigner on Tue Apr 13 16:57:06 GMT+08:00 2021
 */

package cn.lanqiao.ui.TrainInfoUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class RemainingTicketsFrm extends JDialog {
    private String[] header=new String[]{"列车名","座位类型","车厢号","剩余座位"};
    private  Object[][] tickets=null;
    public RemainingTicketsFrm(Object[][] tickets) {
        this.tickets=tickets;
        initComponents();
        init();
    }

    public void init() {
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        this.table1.setModel(new DefaultTableModel(tickets,header));
        //必须加上下面语句猜能显示
        scrollPane1.setViewportView(table1);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 425, 130);
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/mainLogo.png")).getImage());

        contentPane.setPreferredSize(new Dimension(425, 160));
        setSize(425, 160);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
