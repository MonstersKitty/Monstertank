package com.fengli.game;

import com.fengli.util.MyUtil;
import sun.dc.pr.PRError;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
 *坦克类
 */
public class Tank {
    //四个方向
    public static final int DIR_UP = 0;
    public static final int DIR_DOWN = 1;
    public static final int DIR_LEFT = 2;
    public static final int DIR_RIGHT = 3;
    //默认速度 M每帧30ms
    public static final int DEFAULT_SPEED = 4;
    //坦克的状态
    public static final int STATE_STAND = 0;
    public static final int STATE_MOVE = 1;
    public static final int STATE_DIE = 2;

    //坦克的初始生命
    public static final int DEFAULT_HP = 1000;

    private int x,y;
    //半径
    public static final int RADIUS = 23;
    //血量
    private int hp =DEFAULT_HP ;
    //攻击力
    private int atk;
    //速度
    private int speed;
    //方向
    private int dir;
    //坦克的状态
    private int state = STATE_STAND;
    //坦克的颜色
    private Color color;
    //炮弹
    private List bullets = new ArrayList<> (  );

    public Tank ( int x , int y , int dir ) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        color = MyUtil.getRandomColor ();//随机颜色
    }

    /**
     * 绘制坦克
     */
    public void draw(Graphics g){
        g.setColor ( color );


        //绘制坦克的形状
        g.fillOval ( x-RADIUS,y-RADIUS,RADIUS<<1,RADIUS<<1 );
        int endX = x;
        int endY = y;
        switch (dir){
            case DIR_UP:
                endY = y-RADIUS*2;
                g.drawLine ( x-1,y,endX-1,endY );//这是给坦克突出的那条炮筒加粗的
                g.drawLine ( x+1,y,endX+1,endY );
                break;
            case DIR_DOWN:
                endY = y+RADIUS*2;
                g.drawLine ( x-1,y,endX-1,endY );
                g.drawLine ( x+1,y,endX+1,endY );
                break;
            case DIR_LEFT:
                //这里endY没改导致,坦克的炮筒按下左右键的时候不会发生变化,只会长度变化
//                endY = x-RADIUS*2;
                endX = x-RADIUS*2;
                g.drawLine ( x,y-1,endX,endY-1 );
                g.drawLine ( x,y+1,endX,endY+1 );
                break;
            case DIR_RIGHT:
//                endY = x+RADIUS*2;
                endX = x+RADIUS*2;
                g.drawLine ( x,y-1,endX,endY-1 );
                g.drawLine ( x,y+1,endX,endY+1 );
                break;
        }
        g.drawLine ( x,y,endX,endY );
    }

    public static int getDirUp () {
        return DIR_UP;
    }

    public static int getDirDown () {
        return DIR_DOWN;
    }

    public static int getDirLeft () {
        return DIR_LEFT;
    }

    public static int getDirRight () {
        return DIR_RIGHT;
    }

    public static int getDefaultSpeed () {
        return DEFAULT_SPEED;
    }

    public static int getStateStand () {
        return STATE_STAND;
    }

    public static int getStateMove () {
        return STATE_MOVE;
    }

    public static int getStateDie () {
        return STATE_DIE;
    }

    public static int getDefaultHp () {
        return DEFAULT_HP;
    }

    public int getX () {
        return x;
    }

    public void setX ( int x ) {
        this.x = x;
    }

    public int getY () {
        return y;
    }

    public void setY ( int y ) {
        this.y = y;
    }

    public static int getRADIUS () {
        return RADIUS;
    }

    public int getHp () {
        return hp;
    }

    public void setHp ( int hp ) {
        this.hp = hp;
    }

    public int getAtk () {
        return atk;
    }

    public void setAtk ( int atk ) {
        this.atk = atk;
    }

    public int getSpeed () {
        return speed;
    }

    public void setSpeed ( int speed ) {
        this.speed = speed;
    }

    public int getDir () {
        return dir;
    }

    public void setDir ( int dir ) {
        this.dir = dir;
    }

    public int getState () {
        return state;
    }

    public void setState ( int state ) {
        this.state = state;
    }

    public Color getColor () {
        return color;
    }

    public void setColor ( Color color ) {
        this.color = color;
    }

    public List getBullets () {
        return bullets;
    }

    public void setBullets ( List bullets ) {
        this.bullets = bullets;
    }
}
