/*
 * Created by JFormDesigner on Tue Apr 13 15:04:12 GMT+08:00 2021
 */

package cn.lanqiao.ui.TrainInfoUI;

import java.awt.event.*;

import cn.lanqiao.entity.TrainInformation.TrainInfo;
import cn.lanqiao.service.TrainInforService;
import cn.lanqiao.service.impl.TrainInforServiceimpl;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import com.eltima.components.ui.*;

/**
 * @author Brainrain
 */
public class AllTrainInfoFrm extends JFrame {
    private TrainInforService trainInforService = new TrainInforServiceimpl();
    private String[] header = new String[]{"列车编号", "列车类型", "发车时间", "到达时间", "起点站", "终点站", "运行时间", "车厢数"};
    private Object[][] allTrainInfo = trainInforService.getAllTrainInfo();
    private String year_month_day;
    private int ticketType;

    public AllTrainInfoFrm() {
        this.year_month_day = year_month_day;
        this.ticketType = ticketType;
        initComponents();
        init();
    }

    public void init() {
        //设置datepicker只看到年月日??

        //设置颜色
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(102, 153, 255));
        //当数据超过下面的宽度和高度即可拉
        setSize(875, 505);
        table1.setPreferredScrollableViewportSize(new Dimension( 795, 255));
        //创建下拉条
        JScrollPane scrollPane = new JScrollPane(table1);
        //设置列大小不可拖动
        table1.getTableHeader().setResizingAllowed(false);
        //设置表头不可拖动
        table1.getTableHeader().setReorderingAllowed(false);
        //不显示水平线和垂直线
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        //拿到所有列车信息

        this.table1.setModel(new DefaultTableModel(allTrainInfo,header));
        //必须加上下面语句猜能显示
        scrollPane1.setViewportView(table1);

    }

    private void btnTicketActionPerformed(ActionEvent e) {
        int selectedRow = table1.getSelectedRow();
        //等到选中列车的列车号
        String trainNum = table1.getValueAt(selectedRow, 0).toString();
        //得到当前选中列车的座位信息
        Object[][] tickets = trainInforService.getRemainingTicketsByTrainNum(trainNum);
        //将座位信息传到RemainingTicketsFrm中
        RemainingTicketsFrm remainingTicketsFrm = new RemainingTicketsFrm(tickets);
        remainingTicketsFrm.setVisible(true);
    }

    private void btndetailsActionPerformed(ActionEvent e) {
        if (datePicker1.getText().length() > 0) {
            year_month_day = datePicker1.getText().substring(0,10);
            if (radioButton1.isSelected()) {
                ticketType = 2;//学生票
            } else {
                ticketType = 1;
            }
            int selectedRow = table1.getSelectedRow();
            String trainNum = table1.getValueAt(selectedRow, 0).toString();
            String startStation = table1.getValueAt(selectedRow, 4).toString();
            String endStation = table1.getValueAt(selectedRow, 5).toString();
            //需要修改
            GetDetailTrainParkingFrm getDetailTrainParkingFrm = new GetDetailTrainParkingFrm(trainNum, startStation, endStation, year_month_day, ticketType);
            getDetailTrainParkingFrm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "请选择时间");
        }

    }

    private void butserchActionPerformed(ActionEvent e) {
        String trainNo = trainNum.getText();
        Object[][] train = trainInforService.getTrainInfoBytrainNum(trainNo);
        this.table1.setModel(new DefaultTableModel(train, header));
        scrollPane1.setViewportView(table1);
    }

    private void btnupdataActionPerformed(ActionEvent e) {
        this.table1.setModel(new DefaultTableModel(allTrainInfo, header));
        scrollPane1.setViewportView(table1);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btnTicket = new JButton();
        btndetails = new JButton();
        trainNum = new JTextField();
        butserch = new JButton();
        btnupdata = new JButton();
        datePicker1 = new DatePicker();
        radioButton1 = new JRadioButton();

        //======== this ========
        setTitle("\u6240\u6709\u5217\u8f66\u4fe1\u606f");
        setBackground(new Color(102, 153, 255));
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/mainLogo.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 100, 800, 230);

        //---- btnTicket ----
        btnTicket.setText("\u67e5\u8be2\u4f59\u7968");
        btnTicket.addActionListener(e -> btnTicketActionPerformed(e));
        contentPane.add(btnTicket);
        btnTicket.setBounds(770, 360, 85, btnTicket.getPreferredSize().height);

        //---- btndetails ----
        btndetails.setText("\u67e5\u8be2\u8be6\u60c5");
        btndetails.addActionListener(e -> btndetailsActionPerformed(e));
        contentPane.add(btndetails);
        btndetails.setBounds(665, 360, 84, btndetails.getPreferredSize().height);
        contentPane.add(trainNum);
        trainNum.setBounds(25, 25, 305, 30);

        //---- butserch ----
        butserch.setText("\u641c\u7d22");
        butserch.addActionListener(e -> butserchActionPerformed(e));
        contentPane.add(butserch);
        butserch.setBounds(new Rectangle(new Point(365, 30), butserch.getPreferredSize()));

        //---- btnupdata ----
        btnupdata.setText("\u5237\u65b0");
        btnupdata.addActionListener(e -> btnupdataActionPerformed(e));
        contentPane.add(btnupdata);
        btnupdata.setBounds(new Rectangle(new Point(460, 30), btnupdata.getPreferredSize()));
        contentPane.add(datePicker1);
        datePicker1.setBounds(25, 65, 200, 26);

        //---- radioButton1 ----
        radioButton1.setText("\u5b66\u751f\u7968");
        radioButton1.setBackground(new Color(102, 153, 255, 110));
        contentPane.add(radioButton1);
        radioButton1.setBounds(255, 70, 70, radioButton1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(865, 465));
        setSize(865, 465);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btnTicket;
    private JButton btndetails;
    private JTextField trainNum;
    private JButton butserch;
    private JButton btnupdata;
    private DatePicker datePicker1;
    private JRadioButton radioButton1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
  /*  public static void main(String[] args) {
        AllTrainInfoFrm allTrainInfoFrm=new AllTrainInfoFrm();
        allTrainInfoFrm.setVisible(true);
    }*/
}
