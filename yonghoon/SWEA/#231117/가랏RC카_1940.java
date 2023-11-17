package com.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가랏RC카_1940 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		// 최종 거리
		int meter = 0;
		// 현재 속력
		int speed = 0;
		// 명령어
		int command = 0;
		// 가속, 감속 수치
		int f = 0;
		
		// 테스트 케이스 수
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<= N; i++) {
			// Command 의 수
			st = new StringTokenizer(bf.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			// 새롭게 시작 속력, 위치 0 으로 초기화
			meter = 0;
			speed = 0;
			f = 0;
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(bf.readLine(), " ");
				command = Integer.parseInt(st.nextToken());
				if(command == 0) {
					meter += speed;
				}else if(command == 1) {
					f = Integer.parseInt(st.nextToken());
					speed += f;
					meter += speed;
				}else if(command == 2) {
					f = Integer.parseInt(st.nextToken());
					if(speed - f >= 0) {
						speed -= f;
						meter += speed;
					}else {
						speed = 0;
						meter += speed;
					}

				}
			}
			System.out.println("#" + i + " " + meter);
		}

	}

}