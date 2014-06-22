package com.bitory.search;

import com.bitory.print.MyPrint;

/**
 * Created by bitory on 2014/6/22.
 */
public class LinearSearch extends Search {
    @Override
    public int search(Integer[] a, Integer goal) {
        for(int i=0;i < a.length;i++){
            if (a[i].equals(goal))
                return i;
        }
        return -1;
    }

    public static void main(String arv[]){
        MyPrint.printlnObject(new LinearSearch().search(new Integer[]{1, 654, 63, 136, 51, 6584, 6, 4, 321, 35, 6584, 64, 6}, 6));
    }
}
