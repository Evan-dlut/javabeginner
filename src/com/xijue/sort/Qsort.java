package com.xijue.sort;

import java.util.Arrays;

public class Qsort {

	public Qsort() {
		// TODO Auto-generated constructor stub
	}

	public static void swap(Integer [] s, int a, int b){
		Integer tmp = s[a];
		s[a] = s[b];
		s[b]= tmp;
	}
	
	public static void sort(Integer[] s, final int start, final int end){
		if(start >= end)
			return ;
		int index = s[start];
		Integer temps;
        temps = start;
        Integer tempe = end;
		do{
			while(s[tempe] > index) tempe--;
			while(s[temps] <= index && tempe > temps) temps++;
			
			if(tempe == temps) {
                break;
            }
			swap(s, temps, tempe);
		}while(tempe > temps);
		swap(s, tempe, start);
		sort(s, start, tempe-1);
		sort(s, tempe+1, end);
	}
	// "What?"
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] a = {32,543,645,74,5674,56,2,523,42,324,4365,34,7645,754,66,234,1};
		System.out.println(a.length);
		Qsort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
	}

}