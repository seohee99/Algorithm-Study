package com.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 프로세서연결하기_1767 {
	static int maxCore, minLen, n;
	static int[][] map;
    static int dx[] = {0,0,-1,1}; // 상 하 좌 우
    static int dy[] = {-1,1,0,0};
    static ArrayList<Core> coreList;
    
    static class Core {
    	int x;
    	int y;
    	
    	Core(int y, int x){
    		this.x = x;
    		this.y = y;
    	}
    }
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= N; t++) {
			st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			coreList = new ArrayList<>();
			map = new int[n][n];
			minLen = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for(int j = 0; j < n; j++) {
					int in = Integer.parseInt(st.nextToken());
                    if(in==1) {
                        map[i][j] = in;
                         
                        // 가장자리에 있는 코어라면 리스트에 저장X
                        if(i==0 || j==0 || i==n-1 || j==n-1)
                            continue;
                        coreList.add(new Core(i,j));  // 행, 열
                    }
				}
			}
			
			dfs(0,0,0);
			
			
			System.out.println("#" + t + " " + minLen);
			
		}
		
		
	}
	
	public static void dfs (int index, int coreCnt, int len) {
		
		if(index == coreList.size()) {
			
			if(coreCnt > maxCore) {
				maxCore = coreCnt;
				minLen = len;
			} else if(coreCnt == maxCore) {
				minLen = (minLen < len) ? minLen : len;
			}
			
			return;
		}
		
		int x = coreList.get(index).x;
		int y = coreList.get(index).y;
		
		for(int i = 0; i < 4; i++) {
			int cnt = 0;
			int tempX = x;
			int tempY = y;
			
			
			while(true) {
				tempX += dx[i];
				tempY += dy[i];
				
				if(tempX < 0 || tempY < 0 || tempX >= n || tempY >= n)	break;
				
				if(map[tempY][tempX] == 1) {
					cnt = 0;
					break;
				}
				
				cnt++;
			}
			
			int fill_x = x;
            int fill_y = y;
             
            for(int j=0; j<cnt; j++) {
                fill_x += dx[i];
                fill_y += dy[i];
                map[fill_y][fill_x] = 1;
            }
			
			if(cnt == 0) {
				dfs(index+1, coreCnt, len);
			}else {
				dfs(index+1, coreCnt+1, len+cnt);
				
                fill_x = x;
                fill_y = y;
                 
                for(int j=0; j<cnt; j++) {
                    fill_x += dx[i];
                    fill_y += dy[i];
                    map[fill_y][fill_x] = 0;
                }
				
			}

			
		}
	}
}