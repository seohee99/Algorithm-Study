package com.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 창용마을무리의개수_7465 {
    
	static int[] visit;
	static ArrayList<Integer>[] map;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			map = new ArrayList[N+1];
			for(int i=1; i<= N; i++) {
				map[i] = new ArrayList<Integer>();
			}
			visit = new int[N+1];
			cnt = 0;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int f = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[f].add(b);
				map[b].add(f);
				
			}
			
			
			for(int i = 1; i <= N; i++) {
				if(visit[i] == 1) continue;
				dfs(i);
				cnt++;
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}
		

		
	}
	
	public static void dfs(int num) {
		
		if(visit[num] == 1) {
			return;
		}
		visit[num] = 1;
		for(int i = 0; i < map[num].size(); i++ ) {
			dfs(map[num].get(i));
		}

	}

}