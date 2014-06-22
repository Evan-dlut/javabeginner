package com.bitory.search;

import com.bitory.exception.CannotHappenException;

/**
 * Created by bitory on 2014/6/22.
 */
public class BinarySearch extends Search{

    @Override
    /*
        默认是从大到小排列的数组
     */
    public int search(Integer[] a, Integer goal) {
        int end = a.length;
        int begin = 0;
        int middle  = (end + begin) / 2;
        while (middle > 0){
            if (a[middle] > goal){
                begin = middle;
                middle = (begin + end)/2;
            }
            else if(a[middle] < 0){
                end = middle;
                middle = (end + begin)/2;
            }
            else if(a[middle] == goal){
                return middle;
            }
            else {
                System.out.println("What A Fuck!?");
                throw new CannotHappenException();
            }
        }
        return -1;
    }

    public static void main(String ap[]){
        Integer [] a = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("The localion of 5 is " + new BinarySearch().search(a, 5));
    }
}
