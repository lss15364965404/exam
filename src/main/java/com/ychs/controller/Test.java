package com.ychs.controller;

import com.ychs.util.Constants;

public class Test {
	public static void main(String[] args) {
		String a = "1,2,3,";
		String b[] = a.split(",");
		for(int i = 0;i<b.length;i++){
			System.out.println(b[i]);
		}
		//System.out.println(1==Constants.SUCCESS);
		
	}
}
