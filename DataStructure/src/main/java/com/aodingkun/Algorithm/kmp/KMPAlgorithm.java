package com.aodingkun.Algorithm.kmp;

import java.util.Arrays;

public class KMPAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		//String str2 = "BBC";
		
		int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
		System.out.println("next=" + Arrays.toString(next));
		
		int index = kmpSearch(str1, str2, next);
		System.out.println("index=" + index); // 15??
		
		
	}
	
	//?????????kmp??????
	/**
	 * 
	 * @param str1 ??????
	 * @param str2 ???
	 * @param next ????????, ?????????????????
	 * @return ?????-1?????????????????????????????
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {
		
		//???? 
		for(int i = 0, j = 0; i < str1.length(); i++) {
			
			//??????? str1.charAt(i) ??= str2.charAt(j), ?????j?????
			//KMP???????, ???????...
			while( j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1]; 
			}
			
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}			
			if(j == str2.length()) {//????? // j = 3 i 
				return i - j + 1;
			}
		}
		return  -1;
	}

	//?????????????(???) ???????????
	public static  int[] kmpNext(String dest) {
		//???????next ????g?????????
		int[] next = new int[dest.length()];
		next[0] = 0; //??????????????1 ????????????0
		for(int i = 1, j = 0; i < dest.length(); i++) {
			//??dest.charAt(i) != dest.charAt(j) ???????????next[j-1]??????j
			//?????????? ??  dest.charAt(i) == dest.charAt(j)?????????
			//???kmp????????
			while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j-1];
			}
			
			//??dest.charAt(i) == dest.charAt(j) ???????????????????+1
			if(dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
