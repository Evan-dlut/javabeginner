package com.xijue.thread;

import com.bitory.print.MyPrint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xijueyp on 14-6-25.
 */
class Resource{
    public int i = 0;
};

public class Practice21_15 implements Runnable{
    private static int count = 1;  // 调用哪个函数
    private Resource p;       // 同步的对象

    public Practice21_15(Resource p){
        this.p = p;
    }

    public Practice21_15(){
        p = new Resource();
    }

    public void a() throws InterruptedException {
        synchronized (p){
            MyPrint.printlnObject(p.i+"a begin");
            TimeUnit.SECONDS.sleep(2);
            MyPrint.printlnObject("a end");
            p.i++;
        }
    }

    public void b() throws InterruptedException {
        synchronized (p){
            MyPrint.printlnObject(p.i+"b begin");
            TimeUnit.SECONDS.sleep(2);
            MyPrint.printlnObject("b end");
            p.i++;
        }
    }

    public void c() throws InterruptedException {
        synchronized (p){
            MyPrint.printlnObject(p.i+"c begin");
            TimeUnit.SECONDS.sleep(2);
            MyPrint.printlnObject("c end");
            p.i++;
        }
    }


    @Override
    public void run() {
        try {
            switch (count++){

                case 1:
                    a();break;
                case 2:
                    b();break;
                case 3:
                    c();break;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String arv[]){
        Resource r = new Resource();
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(new Practice21_15(r));
        e.execute(new Practice21_15(r));
        e.execute(new Practice21_15(r));
//        e.shutdown();
//        MyPrint.printlnObject("Finish");
    }
}
