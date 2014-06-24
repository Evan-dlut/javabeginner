package com.bitory.baseStruct;

import com.bitory.exception.EmptyStackException;
import com.bitory.print.MyPrint;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.exit;

/**
 * Created by bitory on 2014/6/22.
 *
 * 函数的含义同官方文档
 */
public class Stack<T> {
    private ArrayList<T> data;

    public Stack(){
        data = new ArrayList();
    }

    boolean empty(){
        return data.size() == 0;
    }

    public T peek() {
        T index = null;
        if (data.size() == 0)
            throw new EmptyStackException();
        else
            data.remove(data.size() - 1);
        return index;
    }

    @Deprecated
    public T pop(){
        T index = null;
        try{
            index = (T) new Stack().peek();
        }catch(EmptyStackException e){
            // 返回的异常名字为什么没有我写的这个异常
            MyPrint.printlnObject("as");
            // e.printStackTrace();
        }
        data.remove(data.size() - 1);
        return index;
    }

    public T push(T item){
        data.add(item);


        return item;
    }

    public int search(Object o){
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
