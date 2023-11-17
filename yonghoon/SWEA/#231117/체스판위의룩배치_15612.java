package com.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 체스판위의룩배치_15612 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), "");
		
		String[][] map = new String[8][8];
		
		
		// 테스트 케이스 수
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<= N; i++) {
			ArrayList<Integer> x = new ArrayList<>();
			ArrayList<Integer> y = new ArrayList<>();
			int flag = 0;
			int cnt = 0;
			// 체스판 위에 룩 설치 하기
			for(int p = 0; p < 8; p++) {
				st = new StringTokenizer(bf.readLine(), "");
				String line = st.nextToken();
				String[] array = line.split("");
				for(int q = 0; q < 8; q++) {
					if(array[q].equals("O")) {
						cnt ++;
                        if(flag == 1) continue;
						if(!x.contains(p)) {
							x.add(p);
						}else {
							flag = 1;
						}
						if(!y.contains(q)) {
							y.add(q);
						}else {
							flag = 1;
						}
						
					}
//					System.out.print(map[p][q] + " ");
				}
//				System.out.println();
			}
			
			if(flag == 0 && cnt == 8) {
				System.out.println("#" + i + " yes");
			}else {
				System.out.println("#" + i + " no");
			}
		}

	}

}