package com.fengli.app;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics;

public class TankFrame extends Frame {

    //坦克的坐标变量
    int x = 200;
    int y = 200;
    //方向的定义
    Dir dir = Dir.DOWN;

    //定义一个坦克的速度
    private static final int SPEED = 10;

    public TankFrame(){
        //设置一个窗口(frame就是一个窗口类)
        Frame frame = new Frame ();
        //窗口的大小
        setSize ( 800,600 );
        //窗口是否可以改变大小
        setResizable ( false );
        //窗口的名称
        setTitle ( "tank war" );
        //是否可以关掉窗口
        setVisible ( true );

        this.addKeyListener ( new MyKeyListener () );

        //监听器,当点击x就会发生一个事件,然后就会关闭0
        frame.addWindowListener ( new WindowAdapter () {
            @Override
            public void windowClosing ( WindowEvent e ) {
                System.exit ( 0 );
            }

        } );
    }
    //进行画画操作(paint这个方法事被自动调用,就是窗口改变时)

    //坦克的移动
    @Override
    public void paint(Graphics g){
       g.fillRect ( x,y,50,50 );

        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;

        }
   }

    //键盘监听处理类
    class MyKeyListener extends KeyAdapter{

        //按下去的键往斜着走的思路
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;


        //一个键被按下去的时候被调用
        @Override
        public void keyPressed ( KeyEvent e ) {
            int key = e.getKeyCode ();//这是取哪个键被按下的代码
            //相当于一个虚拟键盘,按下的键转为数字代表多少
            switch (key){
                //如果按下左键,会做什么
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;

                //如果按下上建,会做什么
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                //按下右键会做什么
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                //按下下键会做什么
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
            //x += 200;
            //会默认调用paint方法
//            repaint ();
        }

        //一个键被抬起来的时候被调用
        @Override
        public void keyReleased ( KeyEvent e ) {
            int key = e.getKeyCode ();
            switch (key){
                //如果按下左键,会做什么
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;

                //如果按下上建,会做什么
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                //按下右键会做什么
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                //按下下键会做什么
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir () {
            if(bL) dir = Dir.LEFT;
            if(bU) dir = Dir.UP;
            if(bR) dir = Dir.RIGHT;
            if(bD) dir = Dir.DOWN;
         }
    }

}
