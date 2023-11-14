package com.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class 개수세기_10807 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine(), " ");
		int[] list = new int[N];
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(list[i] == v) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}