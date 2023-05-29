package com.fengli.game;

import com.fengli.util.Constant;
import com.fengli.util.Constant.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * y游戏的窗口类
 * 所有的游戏展示的内容都要在该类实现
 */
public class GameFrame extends Frame {
    //游戏状态
    public static int gameState;

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

    private void initEventListener(){
        //监听器,当点击x就会发生一个事件,然后就会关闭0
        addWindowListener ( new WindowAdapter () {

            //点击关闭按钮的时候,方法回自动背调用
            @Override
            public void windowClosing ( WindowEvent e ) {
                System.exit ( 0 );//结束虚拟机的
            }

        } );
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

        final int DIS = 30;
        for ( int i = 0 ; i < Constant.MENUS.length ; i++ ) {
            g.drawString ( Constant.MENUS[i],x,y+DIS*i );

        }
    }

}
