/*
 * Created by JFormDesigner on Mon Apr 12 17:22:05 CST 2021
 */

package cn.lanqiao.ui;

import com.eltima.components.ui.DatePicker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Brainrain
 */
public class MainFrm extends JFrame {
    //private User currentUser;
    public MainFrm() {
        var contentPane = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口后操作为退出程序
        init(contentPane);
        initComponents();
    }

    /*public MainFrm(User user){
        this();
        this.currentUser = user;
        this.setTitle(this.getTitle() +"      " + "欢迎：" + user.getUname());
    }*/

    private void init(Container contentPane){
        //======== this ========
        setTitle("\u94c1\u8def\u7968\u52a1\u7ba1\u7406\u5e73\u53f0");
        setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 18));
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/MainLogo.png")).getImage());

        contentPane.setLayout(null);
        contentPane.setBackground(new Color(102, 153, 255, 110));

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menuBar2 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu3 = new JMenu();
        menu4 = new JMenu();
        origin = new JTextField();
        destination = new JTextField();
        label3 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        datePicker = new DatePicker();
        button1 = new JButton();

        //======== this ========
        setTitle("\u94c1\u8def\u7968\u52a1\u7ba1\u7406\u5e73\u53f0");
        setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 18));
        setIconImage(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/MainLogo.png")).getImage());
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

                    //======== menu2 ========
                    {
                        menu2.setText("text");
                    }
                    menu1.add(menu2);
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

        //---- label3 ----
        label3.setIcon(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/jiantou .png")));
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jiantouMouseClicked(e);
            }
        });
        contentPane.add(label3);
        label3.setBounds(405, 110, 65, 65);

        //---- radioButton1 ----
        radioButton1.setText("\u9ad8\u94c1/\u52a8\u8f66");
        radioButton1.setForeground(Color.white);
        radioButton1.setBackground(new Color(102, 153, 255, 110));
        radioButton1.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 14));
        contentPane.add(radioButton1);
        radioButton1.setBounds(325, 250, radioButton1.getPreferredSize().width, 24);

        //---- radioButton2 ----
        radioButton2.setText("\u5b66\u751f\u7968");
        radioButton2.setBackground(new Color(102, 153, 255, 110));
        radioButton2.setForeground(Color.white);
        radioButton2.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 14));
        contentPane.add(radioButton2);
        radioButton2.setBounds(485, 250, 75, radioButton2.getPreferredSize().height);

        //---- datePicker ----
        datePicker.setToolTipText("\u8bf7\u9009\u62e9\u51fa\u884c\u65e5\u671f");
        contentPane.add(datePicker);
        datePicker.setBounds(345, 205, 185, 30);

        //---- button1 ----
        button1.setText("\u706b\u8f66\u7968\u67e5\u8be2");
        button1.setBackground(new Color(204, 204, 204));
        button1.setFont(new Font("\u4eff\u5b8b", Font.BOLD, 22));
        button1.setForeground(new Color(0, 0, 204));
        button1.setIcon(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/search.png")));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(340, 290), button1.getPreferredSize()));

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
    private JMenu menu2;
    private JMenu menu3;
    private JMenu menu4;
    private JTextField origin;
    private JTextField destination;
    private JLabel label3;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private DatePicker datePicker;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        MainFrm mainFrm = new MainFrm();
        mainFrm.setVisible(true);
    }
}
