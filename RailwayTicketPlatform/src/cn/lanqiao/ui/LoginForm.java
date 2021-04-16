/*
 * Created by JFormDesigner on Wed Apr 14 20:30:01 CST 2021
 */

package cn.lanqiao.ui;

import cn.lanqiao.entity.Peoples.User;
import cn.lanqiao.service.UserService;
import cn.lanqiao.service.impl.UserServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class LoginForm extends JFrame {
    public static User currentUser = null;
    public LoginForm() {
        initComponents();
        this.getRootPane().setDefaultButton(this.LoginButton); //按回车键，触发登录按钮;
    }
    public void init() {
        File file = new File("user.data");
        File AutFile = new File("userWithAut.data");
        if(file.exists()){ //存在;
            try {
                ObjectInputStream objectInputStream =new ObjectInputStream(new FileInputStream(file));
                User user =  (User) objectInputStream.readObject();
                unameTextField.setText(user.getUName());
                PasswordField.setText(user.getUPassword());
                remberPswCheckBox.setSelected(true);
                //关闭
                objectInputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (AutFile.exists()) {
            try {
                ObjectInputStream objectInputStream =new ObjectInputStream(new FileInputStream(AutFile));
                User user =  (User) objectInputStream.readObject();
                currentUser=user;
                unameTextField.setText(user.getUName());
                PasswordField.setText(user.getUPassword());
                remberPswCheckBox.setSelected(true);
                AutcheckBox.setSelected(true);
                //关闭
                objectInputStream.close();
                PersonalForm personalForm = new PersonalForm(user);
                personalForm.setVisible(true);
                this.setVisible(false);
                return ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void LoginButtonActionPerformed(ActionEvent e) {
        // 登录
        User user = null;
        String uname = unameTextField.getText();
        String upassword = new String(PasswordField.getPassword());
        UserService userService = new UserServiceImpl();
        user=userService.login(uname, upassword);
        if (user!=null) {
            currentUser = user;
            if (remberPswCheckBox.isSelected()){
                String fileName = "user.data";
                if (AutcheckBox.isSelected()) {
                    fileName = "userWithAut.data";
                }
                try {
                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(fileName));
                    objectOutputStream.writeObject(user);
                    //关闭
                    objectOutputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }else {
                String fileName = "user.data";
                String fileName1 = "userWithAut.data";
                //修改
               /* if (AutcheckBox.isSelected()) {
                    fileName = "userWithAut.data";
                } */
                File file = new File(fileName);
                File file1=new File(fileName1);
                if(file.exists()){
                    boolean isdelete = file.delete();
                    System.out.println(isdelete);
                } else if (file1.exists()) {
                    boolean isdelete = file1.delete();
                }
            }
            PersonalForm personalForm = new PersonalForm(user);
            personalForm.setVisible(true);
            //登录成功:转到主窗体
            //new mainForm(currentUser).setVisible(true);
            //登录窗体需要隐藏;
            this.setVisible(false);
        } else{
            //给出提示;
            JOptionPane.showMessageDialog(null,"请检查账号与密码,本次登录失败!");
        }
    }

    private void RegisterButtonActionPerformed(ActionEvent e) {
        // 注册
        new AddUserJDialog().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        layeredPane1 = new JLayeredPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        unameTextField = new JTextField();
        PasswordField = new JPasswordField();
        remberPswCheckBox = new JCheckBox();
        AutcheckBox = new JCheckBox();
        LoginButton = new JButton();
        RegisterButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u7528\u6237\u767b\u5f55");
        setBackground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== layeredPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //---- label1 ----
                label1.setIcon(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/sky (1).jpg")));
                panel1.add(label1);
                label1.setBounds(0, 0, 430, 130);
            }
            layeredPane1.add(panel1, JLayeredPane.DEFAULT_LAYER);
            panel1.setBounds(0, 0, 430, 130);

            //======== panel2 ========
            {
                panel2.setLayout(null);

                //---- label2 ----
                label2.setIcon(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/user.png")));
                panel2.add(label2);
                label2.setBounds(60, 15, 30, 30);

                //---- label3 ----
                label3.setIcon(new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/suotou.png")));
                panel2.add(label3);
                label3.setBounds(60, 55, 30, 30);
                panel2.add(unameTextField);
                unameTextField.setBounds(110, 15, 240, 30);
                panel2.add(PasswordField);
                PasswordField.setBounds(110, 55, 240, 30);

                //---- remberPswCheckBox ----
                remberPswCheckBox.setText("\u8bb0\u4f4f\u5bc6\u7801");
                remberPswCheckBox.setBackground(Color.white);
                panel2.add(remberPswCheckBox);
                remberPswCheckBox.setBounds(new Rectangle(new Point(110, 90), remberPswCheckBox.getPreferredSize()));

                //---- AutcheckBox ----
                AutcheckBox.setText("\u81ea\u52a8\u767b\u5f55");
                AutcheckBox.setBackground(Color.white);
                panel2.add(AutcheckBox);
                AutcheckBox.setBounds(new Rectangle(new Point(275, 90), AutcheckBox.getPreferredSize()));

                //---- LoginButton ----
                LoginButton.setText("\u767b\u5f55");
                LoginButton.setBackground(Color.blue);
                LoginButton.setForeground(Color.white);
                LoginButton.addActionListener(e -> LoginButtonActionPerformed(e));
                panel2.add(LoginButton);
                LoginButton.setBounds(110, 140, 100, 30);

                //---- RegisterButton ----
                RegisterButton.setText("\u6ce8\u518c");
                RegisterButton.setBackground(Color.blue);
                RegisterButton.setForeground(Color.white);
                RegisterButton.addActionListener(e -> RegisterButtonActionPerformed(e));
                panel2.add(RegisterButton);
                RegisterButton.setBounds(250, 140, 100, 30);
            }
            layeredPane1.add(panel2, JLayeredPane.DEFAULT_LAYER);
            panel2.setBounds(0, 130, 430, 210);
        }
        contentPane.add(layeredPane1);
        layeredPane1.setBounds(0, 0, 430, 340);

        contentPane.setPreferredSize(new Dimension(430, 370));
        setSize(430, 370);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLayeredPane layeredPane1;
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label2;
    private JLabel label3;
    private JTextField unameTextField;
    private JPasswordField PasswordField;
    private JCheckBox remberPswCheckBox;
    private JCheckBox AutcheckBox;
    private JButton LoginButton;
    private JButton RegisterButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
class LoginBackGroundThread extends Thread {
    private JLabel jLabel;
    private ImageIcon[] icons=new ImageIcon[57];

    public LoginBackGroundThread(JLabel jLabel) {
        for (int i = 0; i < 57; i++) {
        icons[i] = new ImageIcon(getClass().getResource("/cn/lanqiao/util/Pictures/sky ("+(i+1)+").jpg"));
        }
        this.jLabel = jLabel;
    }

    @Override

    public void run() {
        int i = 0;
        int j = 0;
        while (true) {
            for (i =0;i<57 ; i++) {
                jLabel.setIcon(new ImageIcon(icons[i].getImage().getScaledInstance(430,130,Image.SCALE_DEFAULT)));
                try {
                    sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (j = i-1; j >= 0; j--) {
                jLabel.setIcon(new ImageIcon(icons[j].getImage().getScaledInstance(430,130,Image.SCALE_DEFAULT)));
                try {
                    sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i=0;
            j=0;
        }

    }
}
