package com.UI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

public class LoginJFrame extends JFrame implements MouseListener {

    static ArrayList<User> list = new ArrayList<>();

    static {
        list.add(new User("fangchihao", "123456"));
        list.add(new User("zhangsan", "123456"));
    }

    //验证码
    String codeRom = CodeRom.getCode();
    //验证码图片
    JLabel codeImage = new JLabel();

    //文本框
    JTextField name = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();


    //登录，注册按钮
    JButton login = new JButton(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\login\\登录按钮.png"));
    JButton register = new JButton(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\login\\注册按钮.png"));


    public LoginJFrame() {
        //初始化窗口
        setJFrame();
        //添加内容
        setImage();

    }

    private void setImage() {

        this.getContentPane().removeAll();

        //添加用户名
        JLabel nameText = new JLabel(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\login\\用户名.png"));
        nameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(nameText);

        name.setBounds(195, 134, 200, 30);
        this.getContentPane().add(name);

        //添加密码
        JLabel passwordText = new JLabel(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //添加验证码
        JLabel codeText = new JLabel(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        //随机验证码生成

        codeImage.setText(codeRom);
        codeImage.setBounds(300, 256, 50, 30);
        codeImage.addMouseListener(this);
        this.getContentPane().add(codeImage);

        //登录按钮
        login.setBounds(123, 310, 128, 47);
        //去除边框
        login.setBorderPainted(false);
        //去除背景
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        login.setPressedIcon(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\login\\登录按下.png"));
        this.getContentPane().add(login);

        //注册按钮
        register.setBounds(256, 310, 128, 47);
        //去除边框
        register.setBorderPainted(false);
        //去除背景
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        register.setPressedIcon(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\login\\注册按下.png"));
        this.getContentPane().add(register);

        //背景图片
        JLabel backGround = new JLabel(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\login\\background.png"));
        backGround.setBounds(0, 0, 470, 390);
        this.getContentPane().add(backGround);

        this.getContentPane().repaint();
    }

    private void setJFrame() {
        //大小
        this.setSize(488, 430);
        //窗口置顶
        this.setAlwaysOnTop(true);
        //窗口居中
        this.setLocationRelativeTo(null);
        //标题
        this.setTitle("拼图账号登录");
        //关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消内容居中
        this.setLayout(null);
        //窗口显示
        this.setVisible(true);


    }

    private void showBug (String r) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(200, 150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);

        JLabel jLabel = new JLabel();
        jLabel.setText(r);
        jLabel.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(jLabel);

        jDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source == login) {

            if (code.getText().equals(codeRom)) {
                for (User u : list) {
                    if (Objects.equals(u.userName, name.getText())) {
                        if (Objects.equals(u.passWord, new String(password.getPassword()))) {
                            new GameJFrame();
                            this.setVisible(false);
                            break;
                        }else {
                            showBug("密码错误");
                            break;
                        }
                    }else {
                        showBug("用户名错误");
                        break;
                    }
                }

            } else {
                showBug("验证码错误");
            }
        } else if (source == register) {
            new RegisterJFrame();
            this.setVisible(false);
        } else if (source==codeImage) {
            codeRom=CodeRom.getCode();
            setImage();
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
