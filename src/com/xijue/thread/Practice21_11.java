package com.xijue.thread;

import com.bitory.print.MyPrint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xijueyp on 14-6-24.
 */
class Resouce{
    private volatile int value1;
    private volatile int value2;
    private static int k = 0;

    public Resouce(){
        value1 = 1;
        value2 = 2;
    }

    public void changeValues() throws InterruptedException {
        // synchronized 的多种用法？
        // 联合成静态的
        value1+=value2;
        int i=0;
        while(i++<1000000);
        value2++;
        print();
    }
    public void print(){
        MyPrint.printlnObject(k++ +"->value1:"+value1+","+"value2:"+value2);
    }

}

public class Practice21_11 implements Runnable{
    private Resouce r ;
    public Practice21_11(Resouce r){
        this.r = r;
    }

    public static void main(String arv[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        Resouce r = new Resouce();
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
        exec.execute(new Practice21_11(r));
    }

    @Override
    public void run() {
        try {
            r.changeValues();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}