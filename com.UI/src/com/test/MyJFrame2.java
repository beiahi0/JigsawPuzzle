package com.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {

    JButton jbt1=new JButton("点我");

    public MyJFrame2(){
        this.setSize(608,680);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("测试");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(2);

        jbt1.setBounds(0,0,100,50);
        jbt1.addMouseListener(this);

        this.getContentPane().add(jbt1);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按住不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
