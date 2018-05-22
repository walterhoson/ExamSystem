package com.wayne.exam.util;

public class test {
	public static void main(String[] args) {
		for(int i=1;i<=7;i+=2) {
			for(int kg = 7 ;kg>i-1;kg--) {
				System.out.print(" ");
			}
			for(int xx = 1 ;xx<=i;xx++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int a =1;a<=5;a+=2) {
			for(int kg2 = 1 ;kg2<a+3;kg2++) {
				System.out.print(" ");
			}
			for(int xx2 = 5 ;xx2>=a;xx2--) {
				System.out.print("* ");
			}
			System.out.println();
		}	
	}
}
