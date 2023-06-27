package com.fengli.game;

import com.fengli.util.Constant;
import com.fengli.util.MyUtil;
import sun.awt.image.ToolkitImage;
import sun.dc.pr.PRError;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
 *坦克类
 */
public class Tank {
    //可以用图片替换画的坦克
    private static Image[] tankImage;
    private static Image[] enemyImage;
    static {
        tankImage = new Image[4];
        //分别存有上下左右的图片位置
        tankImage[0] = Toolkit.getDefaultToolkit ().createImage ( "Image/u.png" );
        tankImage[0] = Toolkit.getDefaultToolkit ().createImage ( "Image/u.png");
        tankImage[0] = Toolkit.getDefaultToolkit ().createImage ( "Image/u.png" );
        tankImage[0] = Toolkit.getDefaultToolkit ().createImage ( "Image/u.png" );

        enemyImage = new Image[4];
        enemyImage[0] = Toolkit.getDefaultToolkit ().createImage ( "Image/cat.png" );
        enemyImage[0] = Toolkit.getDefaultToolkit ().createImage ( "Image/cat.png");
        enemyImage[0] = Toolkit.getDefaultToolkit ().createImage ( "Image/cat.png" );
        enemyImage[0] = Toolkit.getDefaultToolkit ().createImage ( "Image/cat.png" );
   }

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
    private int speed = DEFAULT_SPEED;
    //方向
    private int dir;
    //坦克的状态
    private int state = STATE_STAND;
    //坦克的颜色
    private Color color;
    //炮弹(弹夹,用来管理炮弹)
    private List<Bullet> bullets = new ArrayList<> (  );

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
        logic ();
        //画坦克自身的方法
//        drawTank(g);

        //自己设置的图片画坦克
        drawImageTank ( g );

        //画子弹自身的方法
        drawBullets ( g );

    }

    /**
     * 使用自己设置的图片去绘制坦克
     * @param g
     */
   private void drawImageTank(Graphics g){
       g.drawImage ( tankImage[dir],x-RADIUS,y-RADIUS,null );//这是引用图片作为坦克的形状

   }

    private void drawTank(Graphics g){
        g.setColor ( color );


        //绘制坦克的形状(使用系统的方式去绘制坦克)
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
    //坦克的逻辑处理
    private void logic(){
        switch (state){
            case STATE_STAND:
                break;
            case STATE_MOVE:
                move ();
                break;
            case STATE_DIE:
                break;

        }
    }
    //坦克移动的方法
    private void move(){
        switch (dir){
            case DIR_UP:
                y -=speed;
                if( y < RADIUS ){
                    y = RADIUS;
                }
                break;
            case DIR_DOWN:
                y +=speed;
                if( y > Constant.FRAME_HIGHT - RADIUS ){
                    y = Constant.FRAME_HIGHT - RADIUS;
                }
                break;
            case DIR_LEFT:
                x -=speed;
                if( x < RADIUS){
                    x = RADIUS;
                }
                break;
            case DIR_RIGHT:
                x +=speed;
                if(x > Constant.FRAME_WIDTH-RADIUS){
                    x = Constant.FRAME_WIDTH-RADIUS;
                }
                break;

        }

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


    /**
     * 坦克发射炮弹的功能
     */
    public void fire(){
        int bulletX = x;
        int bulletY = y;
        switch (dir){
            case DIR_UP:
                bulletY -= 2*RADIUS;
                break;
            case DIR_DOWN:
                bulletY += 2*RADIUS;
                break;
            case DIR_LEFT:
                bulletX -= 2*RADIUS;
                break;
            case DIR_RIGHT:
                bulletX += 2*RADIUS;
                break;
        }
        Bullet bullet = new Bullet (bulletX,bulletY,dir,atk,color);
        bullets.add ( bullet );
    }

    /**
     *将坦克发射的子弹,绘制在界面上
     */
    private void drawBullets(Graphics g){
        for ( Bullet bullet : bullets ) {
            bullet.draw ( g );
        }
    }
}
