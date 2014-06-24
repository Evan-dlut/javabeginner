package com.xijue.note;

import com.bitory.print.MyPrint;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xijueyp on 14-6-23.
 */
public class NoteTest {
    @Test(id=10)
    public void a(){}

    @Test(id=20, name = "b")
    public void b(){ }

    public static void track(List<Integer> a, Class<?> c){
        for(Method m:c.getDeclaredMethods()){
            Test t = m.getAnnotation(Test.class);
            if (t != null){
                MyPrint.printlnObject(t.id()+":"+t.name());
                a.remove((Integer)t.id());
            }
            else{
                MyPrint.printlnObject("t is null");
            }
        }
        for (Integer i:a){
            MyPrint.printlnObject(i+": miss");
        }
    }

    public static void main(String arv[]){
        List<Integer> a = new ArrayList<Integer>();
        Collections.addAll(a, 10,20);
        MyPrint.printlnObject(a);
        track(a, NoteTest.class);
    }
}
