package com.fengli.util;

import java.awt.*;

/*
工具类
 */
public class MyUtil {
    private MyUtil(){}
    /**
     * 得到指定区间的随机数
     * @param min 最小区间 包含
     * @param max 最大区间 不包含
     */
    public static final int getRandomNumber(int min , int max){
        return (int)(Math.random ()*(max-min)+min);
    }

    /**
     * 得到一个随机颜色(利用三原色获取)
     */
    public static final  Color getRandomColor(){
        //创建三原色
        int red = getRandomNumber ( 0,256 );
        int green = getRandomNumber ( 0,256 );
        int blue = getRandomNumber ( 0,256 );
        //颜色Color整这个类需要传入三元色,在组成随机颜色
        return new Color ( red,green,blue );
    }
}
