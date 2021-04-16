/*
 * Created by JFormDesigner on Mon Apr 12 17:22:05 CST 2021
 */

package cn.lanqiao.ui;

import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.ui.TrainInfoUI.AllTrainInfoFrm;
import cn.lanqiao.ui.TrainInfoUI.serTrainInfoByStation1;
import com.eltima.components.ui.DatePicker;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
/*
 *
 * @author Brainrain
 */
public class MainFrm extends JFrame {
    private User currentUser;
    public MainFrm(User user) {
        this.currentUser = user;
        this.setTitle("\u94c1\u8def\u7968\u52a1\u7ba1\u7406\u5e73\u53f0");
        this.setTitle(this.getTitle() +"      " + "欢迎：" + user.getUName());
        var contentPane = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口后操作为退出程序
        init(contentPane);
        initComponents();
    }

    private void init(Container contentPane){
        //======== this ========
        setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 18));
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/mainLogo.png")).getImage());
        contentPane.setBackground(new Color(102, 153, 255));
        contentPane = getContentPane();
        contentPane.setLayout(null);


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
        setSize(875, 505);
        setLocationRelativeTo(getOwner());
    }


    private void originFocusGained(FocusEvent e) {
        //获取焦点时，清空提示内容
        String temp = origin.getText();

        if(temp.equals("出发站")) {
            origin.setText("");
        }
    }

    private void jiantouMouseClicked(MouseEvent e) {
        String theorigin=origin.getText();
        String thedestination=destination.getText();
        origin.setText(thedestination);
        destination.setText(theorigin);
    }

    private void destinationFocusGained(FocusEvent e) {
        //获取焦点时，清空提示内容
        String temp = destination.getText();

        if(temp.equals("终点站")) {
            destination.setText("");
        }
    }

    private void ticketSearchMouseClicked(MouseEvent e) {
        String searchOrigin=origin.getText(); //选择的出发站
        String searchDestination=destination.getText();//选择的终点站
        String dateString = datePicker.getText();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = null;
        try {
            utilDate = fmt.parse(dateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        java.sql.Date uSearchdate = new java.sql.Date(utilDate.getTime());//选择的日期
        //System.out.println(uSearchdate);
    }

    private void label3MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void label3MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void ticketSearchMouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void ticketSearchMouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void radioButton1MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void radioButton1MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void radioButton2MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void radioButton2MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    private void menuBar1MouseEntered(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void menuBar1MouseExited(MouseEvent e) {
        // TODO add your code here
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    //exaop 查询列车
    private void ticketSearchActionPerformed(ActionEvent e) {
        // TODO add your code here
        String Creator=currentUser.getPId();//传给创建订单的窗口
        String origin = this.origin.getText();
        String destination = this.destination.getText();
        //截取年月日
        String time;
        String type="火车";
        int ticketType=1;
        boolean selected = radioButton1.isSelected();
        if (selected) {
            type = "动车";
        }
        boolean selected1 = radioButton2.isSelected();
        if (selected1) {
            ticketType =2;//学生票
        }
        if (datePicker.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "请选择时间");
        } else {
            time = datePicker.getText().substring(0, 10);
            serTrainInfoByStation1 serTrainInfoByStation = new serTrainInfoByStation1(origin, destination, type,Creator,time,ticketType);
            if (serTrainInfoByStation.getTrainsInfoByStationName().length>0) {
                serTrainInfoByStation.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"列车不存在或起始站错误");
            }
        }


    }

    private void alltrainInfoActionPerformed(ActionEvent e) {
        //测试 year_month_day，ticketType 还需从AllTrainInfoFrm窗口中获取
        AllTrainInfoFrm allTrainInfoFrm = new AllTrainInfoFrm();
        allTrainInfoFrm.setVisible(true);
    }






    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menuBar2 = new JMenuBar();
        menu1 = new JMenu();
        alltrainInfo = new JMenuItem();
        menu3 = new JMenu();
        menu4 = new JMenu();
        origin = new JTextField();
        destination = new JTextField();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        datePicker = new DatePicker();
        ticketSearch = new JButton();
        label3 = new JLabel();

        //======== this ========
        setTitle("\u94c1\u8def\u7968\u52a1\u7ba1\u7406\u5e73\u53f0");
        setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 18));
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/mainLogo.png")).getImage());
        setBackground(new Color(102, 153, 255));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.setToolTipText("\u5217\u8f66\u4fe1\u606f");
            menuBar1.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 12));

            //======== menuBar2 ========
            {

                //======== menu1 ========
                {
                    menu1.setText("\u5217\u8f66\u4fe1\u606f");
                    menu1.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 14));

                    //---- alltrainInfo ----
                    alltrainInfo.setText("\u6240\u6709\u5217\u8f66\u4fe1\u606f");
                    alltrainInfo.addActionListener(e -> alltrainInfoActionPerformed(e));
                    menu1.add(alltrainInfo);
                }
                menuBar2.add(menu1);
            }
            menuBar1.add(menuBar2);

            //======== menu3 ========
            {
                menu3.setText("\u8ba2\u5355\u4fe1\u606f");
                menu3.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 14));
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u4e2a\u4eba\u4fe1\u606f");
                menu4.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 14));
            }
            menuBar1.add(menu4);
        }
        setJMenuBar(menuBar1);

        //---- origin ----
        origin.setHorizontalAlignment(SwingConstants.CENTER);
        origin.setToolTipText("\u51fa\u53d1\u7ad9");
        origin.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 22));
        origin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                originFocusGained(e);
            }
        });
        contentPane.add(origin);
        origin.setBounds(220, 110, 130, 70);

        //---- destination ----
        destination.setHorizontalAlignment(SwingConstants.CENTER);
        destination.setToolTipText("\u7ec8\u70b9\u7ad9");
        destination.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 22));
        destination.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                destinationFocusGained(e);
            }
        });
        contentPane.add(destination);
        destination.setBounds(520, 110, 130, 70);

        //---- radioButton1 ----
        radioButton1.setText("\u9ad8\u94c1/\u52a8\u8f66");
        radioButton1.setForeground(Color.white);
        radioButton1.setBackground(new Color(102, 153, 255, 110));
        radioButton1.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 14));
        radioButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                radioButton1MouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                radioButton1MouseExited(e);
            }
        });
        contentPane.add(radioButton1);
        radioButton1.setBounds(325, 250, radioButton1.getPreferredSize().width, 24);

        //---- radioButton2 ----
        radioButton2.setText("\u5b66\u751f\u7968");
        radioButton2.setBackground(new Color(102, 153, 255, 110));
        radioButton2.setForeground(Color.white);
        radioButton2.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 14));
        radioButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                radioButton2MouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                radioButton2MouseExited(e);
            }
        });
        contentPane.add(radioButton2);
        radioButton2.setBounds(485, 250, 75, radioButton2.getPreferredSize().height);

        //---- datePicker ----
        datePicker.setToolTipText("\u8bf7\u9009\u62e9\u51fa\u884c\u65e5\u671f");
        contentPane.add(datePicker);
        datePicker.setBounds(340, 205, 185, 30);

        //---- ticketSearch ----
        ticketSearch.setText("\u706b\u8f66\u7968\u67e5\u8be2");
        ticketSearch.setBackground(new Color(204, 204, 204));
        ticketSearch.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 22));
        ticketSearch.setForeground(new Color(0, 0, 204));
        ticketSearch.setIcon(null);
        ticketSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ticketSearchMouseClicked(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                ticketSearchMouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ticketSearchMouseExited(e);
            }
        });
        ticketSearch.addActionListener(e -> ticketSearchActionPerformed(e));
        contentPane.add(ticketSearch);
        ticketSearch.setBounds(new Rectangle(new Point(360, 290), ticketSearch.getPreferredSize()));

        //---- label3 ----
        label3.setIcon(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/jiantou.png")));
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jiantouMouseClicked(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                label3MouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                label3MouseExited(e);
            }
        });
        contentPane.add(label3);
        label3.setBounds(400, 115, 65, 65);

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
        setSize(875, 505);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenuBar menuBar2;
    private JMenu menu1;
    private JMenuItem alltrainInfo;
    private JMenu menu3;
    private JMenu menu4;
    private JTextField origin;
    private JTextField destination;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private DatePicker datePicker;
    private JButton ticketSearch;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        MainFrm mainFrm = new MainFrm(new User("133","1","王欢","女","2795222","北街","wh","123","622630"));
        mainFrm.setVisible(true);
    }
}
