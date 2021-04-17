/*
 * Created by JFormDesigner on Thu Apr 15 13:55:10 CST 2021
 */

package cn.lanqiao.ui;

import java.awt.event.*;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.PassengerService;
import cn.lanqiao.service.UserService;
import cn.lanqiao.service.impl.PassengerServiceImpl;
import cn.lanqiao.service.impl.UserServiceImpl;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.undo.CannotUndoException;

/**
 * @author Brainrain
 */
public class PassengerJDialog extends JDialog {
    private String[] header ={"姓名","身份证号","电话号码","性别"};
    public User currentUser = null;
    private PassengerService passengerService = new PassengerServiceImpl();
    public PassengerJDialog(User user) {
        this.currentUser = user;
        initComponents();
        init();
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
    private void deleteButtonActionPerformed(ActionEvent e) {
        if (currentUser == null) {
            return;
        }
        // 删除
        if(table1.getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(null,"请选择要删除的乘车人信息！");
            return;
        }
        //删除确认

        int confirm =JOptionPane.showConfirmDialog(null,"确认删除吗？");
        if(confirm==0) {
            int rowindex = table1.getSelectedRow();
            String passengerId=table1.getValueAt(rowindex,1).toString();
            PassengerService passengerService = new PassengerServiceImpl();
            passengerService.deletePassenger(passengerId);
            //刷新表格数据;
            table1.setModel(new DefaultTableModel(
                    passengerService.getAllPassenger(currentUser),
                    header
            ));
            JOptionPane.showMessageDialog(null,"删除成功！");
        }
    }

    private void AlterButtonActionPerformed(ActionEvent e) {
        // 修改
        if (table1.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "请选择要修改号码的乘车人！");
            return;
        }
        if (currentUser == null) {
            return;
        }
        new AlterPTelJDialog(this.table1,currentUser).setVisible(true);
    }

    private void AddPassengerButtonActionPerformed(ActionEvent e) {
        // 增加
        new AddPassengerJDialog(currentUser).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        AddPassengerButton = new JButton();
        AlterButton = new JButton();
        deleteButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("\u4e58\u8f66\u4eba\u4fe1\u606f");
        setBackground(Color.white);
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
            table1.setAutoCreateRowSorter(true);
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 525, 305);

        //---- AddPassengerButton ----
        AddPassengerButton.setText("\u6dfb\u52a0");
        AddPassengerButton.setBackground(new Color(102, 102, 255));
        AddPassengerButton.setFont(AddPassengerButton.getFont().deriveFont(AddPassengerButton.getFont().getStyle() | Font.BOLD));
        AddPassengerButton.setForeground(Color.white);
        AddPassengerButton.addActionListener(e -> AddPassengerButtonActionPerformed(e));
        contentPane.add(AddPassengerButton);
        AddPassengerButton.setBounds(405, 320, 80, 30);

        //---- AlterButton ----
        AlterButton.setText("\u4fee\u6539\u7535\u8bdd\u53f7\u7801");
        AlterButton.setFont(AlterButton.getFont().deriveFont(AlterButton.getFont().getStyle() | Font.BOLD));
        AlterButton.setBackground(new Color(102, 102, 255));
        AlterButton.setForeground(Color.white);
        AlterButton.addActionListener(e -> AlterButtonActionPerformed(e));
        contentPane.add(AlterButton);
        AlterButton.setBounds(265, 320, 120, 30);

        //---- deleteButton ----
        deleteButton.setText("\u5220\u9664");
        deleteButton.setBackground(new Color(102, 102, 255));
        deleteButton.setForeground(Color.white);
        deleteButton.setFont(deleteButton.getFont().deriveFont(deleteButton.getFont().getStyle() | Font.BOLD));
        deleteButton.addActionListener(e -> deleteButtonActionPerformed(e));
        contentPane.add(deleteButton);
        deleteButton.setBounds(160, 320, 80, 30);

        contentPane.setPreferredSize(new Dimension(525, 395));
        setSize(525, 395);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton AddPassengerButton;
    private JButton AlterButton;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
