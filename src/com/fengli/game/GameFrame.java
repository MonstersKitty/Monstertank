package com.fengli.game;

import com.fengli.util.Constant;
import com.fengli.util.Constant.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * y游戏的窗口类
 * 所有的游戏展示的内容都要在该类实现
 */
public class GameFrame extends Frame {
    //游戏状态
    public static int gameState;
    //菜单选项
    private int menuIndex;

    /**
     * 对窗口进行初始化
     */
    public GameFrame(){
        initFrame ();
        initEventListener ();

    }
    /**
     * 属性进行初始化
     */
    private void initFrame(){

        setTitle ( Constant.GAME_TITLE );
        //设置窗口可见
        setVisible ( true );
        //窗口的大小
        setSize ( Constant.FRAME_WIDTH,Constant.FRAME_HIGHT );
        //设置窗口的左上角的坐标
        setLocation ( Constant.FRAME_X,Constant.FRAME_Y );
        //窗口是否可以改变大小
        setResizable ( false );

        repaint ();
    }

    /**
     * 对游戏进行初始化
     */
    private void initGame(){

        gameState = Constant.STATE_MENU;
    }




    /**
     * 该方法负责了所有绘制的内容,所有需要在屏幕中显示的内容,该方法不能主动调用,要通过repaint()--然后娶回调该方法
     * @param g
     */
    @Override
    public void update ( Graphics g ) {
        g.setFont ( Constant.font );
        switch (gameState){
            case Constant.STATE_MENU:
                drawMenu ( g );
                break;
            case Constant.STATE_HELP:
                drawHelp ( g );
                break;
            case Constant.STATE_ABOUT:
                drawAbout ( g );
                break;
            case Constant.STATE_RUN:
                drawRun ( g );
                break;
            case Constant.STATE_OVER:
                drawOver ( g );
                break;

        }
    }

    private void drawOver ( Graphics g ) {

    }

    private void drawRun ( Graphics g ) {
    }

    private void drawAbout ( Graphics g ) {
    }


    private void drawHelp ( Graphics g ) {
    }

    /**
     *绘制菜单状态下的 内容
     */
    private void drawMenu(Graphics g){
        //绘制黑色的背景
        g.setColor ( Color.black );
        g.fillRect ( 0,0,Constant.FRAME_WIDTH,Constant.FRAME_HIGHT );

        g.setColor ( Color.white );

        final int STR_WIDTH = 50;
        int x = Constant.FRAME_WIDTH - STR_WIDTH >> 1;
        int y = Constant.FRAME_HIGHT/3;

        final int DIS = 50;
        for ( int i = 0 ; i < Constant.MENUS.length ; i++ ) {
            if(i == menuIndex){//给菜单的字上颜色
                g.setColor ( Color.red );
            }else{
                g.setColor ( Color.white );
            }
            g.drawString ( Constant.MENUS[i],x,y+DIS*i );

        }
    }


    /**
     * 窗口的监听事件
     */
    private void initEventListener(){
        //监听器,当点击x就会发生一个事件,然后就会关闭0
        addWindowListener ( new WindowAdapter () {

            //点击关闭按钮的时候,方法回自动背调用
            @Override
            public void windowClosing ( WindowEvent e ) {
                System.exit ( 0 );//结束虚拟机的
            }

        } );
        //添加按键的监听事件
        addKeyListener ( new KeyAdapter () {

            //按下去执行的事件
            @Override
            public void keyPressed ( KeyEvent e ) {
                int keyCode = e.getKeyCode ();
                //不同的游戏状态,给出不同的游戏方法
                switch (gameState){
                    case Constant.STATE_MENU:
                        KeyEventMenu(keyCode);
                        break;
                    case Constant.STATE_HELP:
                        KeyEventHelp(keyCode);
                        break;
                    case Constant.STATE_ABOUT:
                        KeyEventAbout(keyCode);
                        break;
                    case Constant.STATE_RUN:
                        KeyEventRun(keyCode);
                        break;
                    case Constant.STATE_OVER:
                        KeyEventOver(keyCode);
                        break;

                }
            }

            private void KeyEventOver ( int keyCode ) {
            }

            private void KeyEventRun ( int keyCode ) {
            }

            private void KeyEventAbout ( int keyCode ) {
            }

            private void KeyEventHelp ( int keyCode ) {
            }

            //控制菜单选项上下移动
            private void KeyEventMenu ( int keyCode ) {
                switch (keyCode){
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        //每触发一次都得减1
                        --menuIndex;
                        if(menuIndex < 0){
                            menuIndex = Constant.MENUS.length - 1;
                        }
                        //必须得有repaint没有的话,按下想上或者想下的键是没有反应的,因为根本没有再次触发这几个按键事件
                        repaint ();
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        //每触发一次都得加1
                        ++menuIndex;
                        if(menuIndex > Constant.MENUS.length - 1 ){
                            menuIndex = 0;
                        }
                        repaint ();
                        break;

                }
            }

            //按键结束执行的事件
            @Override
            public void keyReleased ( KeyEvent e ) {
                super.keyReleased ( e );
            }
        } );
    }

}
