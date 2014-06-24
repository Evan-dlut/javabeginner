package com.xijue.thread;

import com.bitory.print.MyPrint;
import org.w3c.dom.ranges.Range;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xijueyp on 14-6-23.
 */
public class Practice21_1 implements Runnable{
    private static int count = 0;
    private final int id = count++;
    static int i = 0;
    @Override
    public void run() {

        MyPrint.printlnObject(id+" Begin~:"+Thread.currentThread().getPriority());
        for (int i=0; i!=3 ;i++){
            MyPrint.printlnObject("#"+id+":"+i);
            Thread.yield();
        }
        MyPrint.printlnObject(id+" Over~");
    }

    public String status(){
        return "#"+id+":"+i++;
    }

    public static void main(String arv[]){
//        for (int i=0;i!=10;i++){
//            new Thread(new Practice21_1()).start();
//        }
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i=0;i < 5;i++){
//            MyPrint.printlnObject("num of threads:"+Thread.getAllStackTraces().size());
            exec.execute(new Practice21_1());
        }
        exec.shutdown();
//        MyPrint.printlnObject("num of threads:"+Thread.getAllStackTraces().size());
    }
}
