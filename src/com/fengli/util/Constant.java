package com.fengli.util;

import java.awt.*;

/*
 * y游戏中所使用的常量类
 */
public class Constant {
    public static final String GAME_TITLE="坦克大战";

    public static final int FRAME_WIDTH=1000;

    public static final int FRAME_HIGHT=800;


    public static final int FRAME_X=1024-FRAME_WIDTH>>1;
    public static final int FRAME_Y=768 - FRAME_HIGHT>>1;

    /**
     * Y游戏菜单
     */
    public static final int STATE_MENU = 0 ;
    public static final int STATE_HELP = 1 ;
    public static final int STATE_ABOUT = 2 ;
    public static final int STATE_RUN = 3 ;
    public static final int STATE_OVER = 4 ;


    public static final String[] MENUS ={
            "开始游戏",
            "继续游戏",
            "游戏帮助",
            "游戏关于",
            "退出游戏"
    };
    /**
     * 字体d的设置
     */
    public static final Font font = new Font ( "宋体",Font.BOLD,25 );


}
