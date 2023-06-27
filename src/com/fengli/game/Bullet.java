package com.fengli.game;


import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    //子弹的速度---是坦克的两倍
    public static final int DEFAULT_SPEED = Tank.DEFAULT_SPEED << 1;
    public static final int RADIUS = 4;

    private int x,y;
    private int speed = DEFAULT_SPEED;
    private int dir;
    private int ark;
    private Color color;

    @Override
    public String toString () {
        return "Bullet{" +
                "x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                ", dir=" + dir +
                ", ark=" + ark +
                '}';
    }

    public Bullet ( int x , int y , int dir , int ark , Color color) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.ark = ark;
        this.color = color;
    }


    /**
     * 绘制炮弹的形状的方法
     */
    public void draw( Graphics g ){
        logic ();
        g.setColor ( color );
        g.fillOval ( x-RADIUS,y-RADIUS,RADIUS<<1,RADIUS<<1 );
    }

    /**
     * 子弹的逻辑
     */
    private void logic(){
        move ();
    }

    private void move(){
        switch (dir){
            case Tank.DIR_UP:
                y -= speed;
                break;
            case Tank.DIR_DOWN:
                y += speed;
                break;
            case Tank.DIR_LEFT:
                x -= speed;
                break;
            case Tank.DIR_RIGHT:
                x += speed;
                break;
        }
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

    public int getArk () {
        return ark;
    }

    public void setArk ( int ark ) {
        this.ark = ark;
    }
}
