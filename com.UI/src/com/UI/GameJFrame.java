package com.UI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    int[][] data=new int[4][4];
    int x,y;
    String path="image\\animal\\animal3\\";
    int[][] win=new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    int step=0;
    
    //菜单条目，方便绑定事件监听
    JMenuItem animalItem=new JMenuItem("动物");
    JMenuItem girlItem=new JMenuItem("美女");
    JMenuItem sportItem=new JMenuItem("运动");
    JMenuItem replayJMItem=new JMenuItem("重新开始");
    JMenuItem reLoginJMItem=new JMenuItem("重新登录");
    JMenuItem closeJMItem=new JMenuItem("关闭游戏");
    JMenuItem helpJMItem=new JMenuItem("V我50，迅速通关");

    public GameJFrame(){
        //创建窗口
        setWindows();
        //创建菜单
        setMenu();
        //打乱数组图片
        setData();
        //添加图片
        setImage();

        //窗口显示
        this.setVisible(true);
    }

    private void setData() {
        int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
        Random r=new Random();
        for (int i = 0; i < arr.length; i++) {
            int num = r.nextInt(arr.length);

            int temp = arr[i];
            arr[i] = arr[num];
            arr[num] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=arr[i];
        }

    }

    private void setImage() {

        this.getContentPane().removeAll();

        //判断胜利
        if(victor()){
            JLabel winJLabel=new JLabel(new ImageIcon("image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }

        //添加步数
        JLabel sJLabel=new JLabel("步数："+step);
        sJLabel.setBounds(50,30,100,20);
        this.getContentPane().add(sJLabel);

        //按照二维数组的数字添加图片添加图片
        for(int j=0;j<4;j++)
        {
            for(int i=0;i<4;i++)
            {
                int num=data[j][i];
                ImageIcon image=new ImageIcon(path+num+".jpg");

                JLabel jLabel=new JLabel(image);
                jLabel.setBounds(i*105+83,j*105+134,105,105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                this.getContentPane().add(jLabel);

            }
        }
        //添加背景
        JLabel jLabel1=new JLabel(new ImageIcon("image\\background.png"));
        jLabel1.setBounds(40,40,508,560);
        this.getContentPane().add(jLabel1);

        this.getContentPane().repaint();
    }

    private void setMenu() {
        //创建菜单
        JMenuBar jMenuBar=new JMenuBar();
        //主菜单
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");
        JMenu replaceImage=new JMenu("更换照片");



        //添加菜单条目
        functionJMenu.add(replaceImage);
        functionJMenu.add(replayJMItem);
        functionJMenu.add(reLoginJMItem);
        functionJMenu.add(closeJMItem);
        aboutJMenu.add(helpJMItem);
        replaceImage.add(animalItem);
        replaceImage.add(girlItem);
        replaceImage.add(sportItem);


        //绑定监听事件
        replayJMItem.addActionListener(this);
        reLoginJMItem.addActionListener(this);
        closeJMItem.addActionListener(this);
        helpJMItem.addActionListener(this);
        animalItem.addActionListener(this);
        girlItem.addActionListener(this);
        sportItem.addActionListener(this);

        //添加主菜单
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //放置菜单
        setJMenuBar(jMenuBar);
    }

    private void setWindows() {
        //大小
        this.setSize(608,680);
        //置顶
        this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //标题
        this.setTitle("拼图游戏");
        //关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消居中
        this.setLayout(null);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(victor()){
            return;
        }

        //显示正确完整图片

        int code = e.getKeyCode();
        if(code==65){
            //清屏
            this.getContentPane().removeAll();

            JLabel sJLabel=new JLabel("步数："+step);
            sJLabel.setBounds(50,30,100,20);
            this.getContentPane().add(sJLabel);

            //正确图片
            JLabel jLabel=new JLabel(new ImageIcon(path+"all.jpg"));
            jLabel.setBounds(83,134,420,420);
            this.getContentPane().add(jLabel);
            //背景图
            JLabel jLabel1=new JLabel(new ImageIcon("image\\background.png"));
            jLabel1.setBounds(40,40,508,560);
            this.getContentPane().add(jLabel1);

            this.getContentPane().repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断是否胜利
        if(victor()){
            return;
        }

        int code= e.getKeyCode();

        //上38下40左37右39
        if(code==38){
            if(x==0){
                return;
            }

            data[x][y]=data[x-1][y];
            data[x-1][y]=16;
            x--;
            step++;
            setImage();
        } else if (code==40) {
            if(x==3){
                return;
            }

            data[x][y]=data[x+1][y];
            data[x+1][y]=16;
            x++;
            step++;
            setImage();
        } else if (code==37) {
            if(y==0){
                return;
            }

            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            step++;
            setImage();
        } else if (code==39) {
            if(y==3){
                return;
            }

            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            step++;
            setImage();
        } else if (code==65) {
            setImage();
        } else if (code==87) {
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };

            setImage();
        }
    }

    public boolean victor(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if(win[i][j]!=data[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        
        if(obj==replayJMItem){
            //重新打乱
            setData();
            //计步数清零
            step=0;
            //添加图片
            setImage();

        } else if (obj==reLoginJMItem) {
            //关闭界面
            this.setVisible(false);
            //重新登陆
            new LoginJFrame();
        } else if (obj == closeJMItem){
            //关闭JVM
            System.exit(0);
        } else if (obj==helpJMItem) {
            JDialog jDialog=new JDialog();

            JLabel jLabel=new JLabel(new ImageIcon("image\\about.jpg"));
            jLabel.setBounds(0,0,498,514);
            jDialog.getContentPane().add(jLabel);

            jDialog.setTitle("V我50，迅速通关");
            jDialog.setSize(600,630);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
            
        } else if (obj==animalItem) {
            Random r=new Random();
            path="image\\animal\\animal"+(r.nextInt(8)+1)+"\\";

            step=0;
            setData();
            setImage();


        } else if (obj==girlItem) {
            Random r=new Random();
            path="image\\girl\\girl"+(r.nextInt(13)+1)+"\\";

            step=0;
            setData();
            setImage();

        } else if (obj==sportItem) {
            Random r=new Random();
            path="image\\sport\\sport"+(r.nextInt(10)+1)+"\\";

            step=0;
            setData();
            setImage();

        }
    }
}
