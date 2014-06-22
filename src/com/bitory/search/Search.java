package com.bitory.search;

/**
 * Created by bitory on 2014/6/22.
 */
public abstract class Search {
    public abstract int search(Integer a[], Integer goal);
    public void swap(Integer [] a, int s, int b){
        Integer tmp = a[s];
        a[s] = a[b];
        a[b] = tmp;
    }
}
