package com.bitory.baseStruct;

import com.bitory.exception.EmptyStackException;
import com.bitory.print.MyPrint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import static java.lang.System.exit;

/**
 * Created by bitory on 2014/6/22.
 *
 * 函数的含义同官方文档
 */
public class Stack {
    private ArrayList data;

    public Stack(){
        data = new ArrayList();
    }

    boolean empty(){
        return data.size() == 0;
    }

    public Integer peek() {
        Integer index = null;
        try {
            index = (Integer) data.get(data.size() - 1);
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
        return index;
    }

    public Integer pop(){
        Integer index = null;
        try{
            index = new Stack().peek();
        }catch(EmptyStackException e){
            // 返回的异常名字为什么没有我写的这个异常
            e.printStackTrace();
        }
        data.remove(data.size() - 1);
        return index;
    }

    public Integer push(Integer item){
        data.add(item);


        return item;
    }

    public int search(Objects o){
        int local = 1;
        for (Iterator i = data.iterator();i.hasNext();){
            if (i.next().equals(o))
                return local;
            ++ local;
        }
        return -1;
    }

    public static void main(String arv[]){
        Stack s = new Stack();
        s.peek();
    }

}
