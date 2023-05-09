package com.fengli.app;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *  程序的入口
 */
public class GameMain {
    public static void main ( String[] args ) throws InterruptedException {
        TankFrame tankFrame = new TankFrame ();
        while (true){
            Thread.sleep ( 50 );
            tankFrame.repaint ();
        }
    }
}
