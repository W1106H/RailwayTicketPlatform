/*
 * Created by JFormDesigner on Thu Apr 15 16:46:49 GMT+08:00 2021
 */

package cn.lanqiao.ui.TrainInfoUI;


import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class CreateOrder extends JFrame {
    Object[][] order=new Object[1][];
    String year_month_day;
    int ticketType;
    public CreateOrder(Object[][] order,String year_month_day,int ticketType) {
        this.order = order;
        this.year_month_day=year_month_day;
        this.ticketType=ticketType;
        initComponents();
    }


    private void btnCreateActionPerformed(ActionEvent e) {
        //订单信息 还差一个插入数据库方法
        String passengerId = passenger.getText();
        String trainNum = order[0][0].toString();
        String startTime=year_month_day+" "+order[0][1].toString();
        String endTime = year_month_day+" "+order[0][2].toString();
        String startNo = order[0][3].toString();
        String endNo = order[0][4].toString();
        String creator = order[0][5].toString();
        Date creatTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //查询身份证格式是否正确
        String regex = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(passengerId);
        if (matcher.matches()) {
            System.out.println("匹配");
        } else {
            JOptionPane.showMessageDialog(null, "身份证格式错误");
        }
        try {
            java.util.Date startData =  sdf.parse(startTime);
            java.util.Date endDate = sdf.parse(endTime);
            System.out.println(passengerId);
            System.out.println(trainNum);
            System.out.println(startNo + " " + endNo);
            System.out.println(creator);
            System.out.println(startData + " || " + endDate);
            System.out.println(creatTime);
            System.out.println(ticketType);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        passenger = new JTextField();
        btnCreate = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4e58\u5ba2\u8eab\u4efd\u8bc1\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(40, 45, 100, 25);
        contentPane.add(passenger);
        passenger.setBounds(140, 45, 170, passenger.getPreferredSize().height);

        //---- btnCreate ----
        btnCreate.setText("\u521b\u5efa");
        btnCreate.addActionListener(e -> btnCreateActionPerformed(e));
        contentPane.add(btnCreate);
        btnCreate.setBounds(new Rectangle(new Point(315, 100), btnCreate.getPreferredSize()));

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
        setSize(420, 170);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField passenger;
    private JButton btnCreate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
