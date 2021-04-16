/*
 * Created by JFormDesigner on Thu Apr 15 17:19:52 CST 2021
 */

package cn.lanqiao.ui;

import cn.lanqiao.entity.Peoples.Passenger;
import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.PassengerService;
import cn.lanqiao.service.impl.PassengerServiceImpl;
import cn.lanqiao.util.TelMathches;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class AlterPTelJDialog extends JDialog {
    private String[] header ={"编号","姓名","性别","生日","邮箱","专业","密码","账号"};
    private JTable jTable=null;
    private User currentUser = null;
    public AlterPTelJDialog(JTable jTable,User user) {
        this.jTable = jTable;
        this.currentUser = user;
        initComponents();
    }

    private void CancleButtonActionPerformed(ActionEvent e) {
        // 取消
        this.dispose();
    }

    private void SureButtonActionPerformed(ActionEvent e) {
        //确认修改
        if (currentUser == null) {
            return;
        }

        String PTel = PTelTextField.getText().trim();
        if (this.jTable == null) {
            return;
        }
        int rowindex = jTable.getSelectedRow();
        String passengerId=jTable.getValueAt(rowindex,1).toString().trim();
        PassengerService passengerService = new PassengerServiceImpl();
        boolean pTelMatches = TelMathches.judgeLegal(PTel);
        if (pTelMatches) {
            int result = passengerService.updatePTel(PTel, passengerId);
            if (result > 0) {
                //刷新表格数据;
                jTable.setModel(new DefaultTableModel(
                        passengerService.getAllPassenger(currentUser),
                        header
                ));
                //对窗体相关组件数据初使化;
                JOptionPane.showMessageDialog(null, "修改成功！");
                PTelTextField.setText(null);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "该电话号码已被其他乘客绑定！");
            }
        } else {
            JOptionPane.showMessageDialog(null, "电话号码输入格式错误！");
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        SureButton = new JButton();
        CancleButton = new JButton();
        label1 = new JLabel();
        PTelTextField = new JTextField();
        panel1 = new JPanel();

        //======== this ========
        setBackground(new Color(102, 102, 255));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- SureButton ----
        SureButton.setText("\u786e\u8ba4\u4fee\u6539");
        SureButton.setBackground(Color.white);
        SureButton.setFont(SureButton.getFont().deriveFont(SureButton.getFont().getStyle() | Font.BOLD));
        SureButton.addActionListener(e -> SureButtonActionPerformed(e));
        contentPane.add(SureButton);
        SureButton.setBounds(140, 95, 95, 30);

        //---- CancleButton ----
        CancleButton.setText("\u53d6\u6d88");
        CancleButton.setBackground(Color.white);
        CancleButton.setFont(CancleButton.getFont().deriveFont(CancleButton.getFont().getStyle() | Font.BOLD));
        CancleButton.addActionListener(e -> CancleButtonActionPerformed(e));
        contentPane.add(CancleButton);
        CancleButton.setBounds(20, 95, 80, 30);

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u65b0\u7684\u7535\u8bdd\u53f7\u7801");
        label1.setForeground(Color.white);
        contentPane.add(label1);
        label1.setBounds(75, 40, 125, label1.getPreferredSize().height);
        contentPane.add(PTelTextField);
        PTelTextField.setBounds(30, 5, 190, PTelTextField.getPreferredSize().height);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 255));
            panel1.setLayout(null);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 260, 140);

        contentPane.setPreferredSize(new Dimension(260, 170));
        setSize(260, 170);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton SureButton;
    private JButton CancleButton;
    private JLabel label1;
    private JTextField PTelTextField;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
