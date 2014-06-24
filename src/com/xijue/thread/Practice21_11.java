package com.xijue.thread;

import com.bitory.print.MyPrint;

/**
 * Created by xijueyp on 14-6-24.
 */
class Resouce{
    private int value1;
    private int value2;

    public Resouce(){
        value1 = 1;
        value2 = 2;
    }

    public synchronized void changeValues(){
        value1+=value2;
        Thread.yield();
        value2++;
        print();
    }
    public void print(){
        MyPrint.printlnObject("value1:"+value1+","+"value2:"+value2);
    }

}

public class Practice21_11 implements Runnable{
    private Resouce r ;
    public Practice21_11(Resouce r){
        this.r = r;
    }

    public static void main(String arv[]){
        Resouce r = new Resouce();
        Practice21_11 p1 = new Practice21_11(r),
                p2 = new Practice21_11(r),
                p3 = new Practice21_11(r);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();

        //r.print();
    }

    @Override
    public void run() {
        r.changeValues();

    }
}