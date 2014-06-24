package com.xijue.thread;

/**
 * Created by xijueyp on 14-6-24.
 */
import com.bitory.print.MyPrint;

import java.util.concurrent.*;

public class SleepingTask extends Practice21_1 {
    public void run() {
        try {
            for (int i=0;i<5;i++) {
                MyPrint.printlnObject(status());
                // Old-style:
                // Thread.sleep(100);
                // Java SE5/6-style:
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch(InterruptedException e) {
            MyPrint.printlnObject("Interrupted");
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
