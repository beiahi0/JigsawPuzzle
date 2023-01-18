package com.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterJFrame extends JFrame implements ActionListener {

    //添加按钮
    JButton register=new JButton(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\register\\注册按钮.png"));
    JButton replace=new JButton(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\register\\重置按钮.png"));


    public RegisterJFrame(){
        //初始化窗口
        setJFrame();
        //添加内容
        setImage();
    }

    private void setImage() {

        this.getContentPane().removeAll();
        //文本
        JLabel nameImage=new JLabel(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\register\\注册用户名.png"));
        nameImage.setBounds(100,140,79,17);
        this.getContentPane().add(nameImage);

        JLabel passwordImage=new JLabel(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\register\\注册密码.png"));
        passwordImage.setBounds(115,190,64,16);
        this.getContentPane().add(passwordImage);

        JLabel repasswordImage=new JLabel(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\register\\再次输入密码.png"));
        repasswordImage.setBounds(80,240,96,17);
        this.getContentPane().add(repasswordImage);

        //输入框
        JTextField nameText=new JTextField();
        nameText.setBounds(200,135,165,25);
        this.getContentPane().add(nameText);

        JTextField passwordText=new JTextField();
        passwordText.setBounds(200,185,165,25);
        this.getContentPane().add(passwordText);

        JTextField repasswordText=new JTextField();
        repasswordText.setBounds(200,235,165,25);
        this.getContentPane().add(repasswordText);

        //增添按钮
        register.setBounds(100,290,128,47);
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.setPressedIcon(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\register\\注册按下.png"));
        register.addActionListener(this);
        this.getContentPane().add(register);

        replace.setBounds(260,290,128,47);
        replace.setBorderPainted(false);
        replace.setContentAreaFilled(false);
        replace.setPressedIcon(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\register\\重置按下.png"));
        replace.addActionListener(this);
        this.getContentPane().add(replace);


        //设置背景
        JLabel backGround=new JLabel(new ImageIcon("C:\\Users\\86157\\Desktop\\JigsawPuzzle\\image\\register\\background.png"));
        backGround.setBounds(0,0,470,399);
        this.getContentPane().add(backGround);

        this.getContentPane().repaint();
    }

    private void setJFrame() {
        //大小
        this.setSize(488,435);
        //置顶
        this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //标题
        this.setTitle("拼图账号注册");
        //关闭方式
        this.setDefaultCloseOperation(3);
        //内容居中
        this.setLayout(null);
        //窗口显示
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==register){


        } else if (source==replace) {
            setImage();
        }
    }
}
