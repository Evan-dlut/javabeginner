package com.xijue.thread;

import com.bitory.print.MyPrint;
import org.w3c.dom.ranges.Range;

/**
 * Created by xijueyp on 14-6-23.
 */
public class Practice21_1 implements Runnable{
    private static int count = 0;
    private final int id = count++;

    @Override
    public void run() {
        MyPrint.printlnObject(id+" Begin~");
        for (int i=0; i!=3 ;i++){
            MyPrint.printlnObject("#"+id+":"+i);
            Thread.yield();
        }
        MyPrint.printlnObject(id+" Over~");
    }

    public static void main(String arv[]){
        for (int i=0;i!=10;i++){
            new Thread(new Practice21_1()).start();
        }
    }
}
