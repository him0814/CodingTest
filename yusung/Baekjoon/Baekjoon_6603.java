package Baekjoon;

import java.io.*;
import java.util.*;

//백준 6603 로또

public class Baekjoon_6603 {
	
	static boolean[] visit;
	static int n;
	static int[] arr;
	static StringBuilder sb  = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			
			if(n==0) {
				break;
			}			
			arr = new int[n];
			visit = new boolean[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}			
			dfs(0,0);			
			sb.append("\n");
		}
		sb.setLength(sb.length()-3);
		System.out.print(sb.toString());
	}
	
	public static void dfs(int depth, int start) {		
		if(depth==6) {
			for(int i=0; i<n;i++) {
				if(visit[i]) {
					sb.append(arr[i]+" ");									
				}
			}			
			sb.append("\n");
		}
		
		for(int j=start; j<n;j++) {
			visit[j] = true;
			dfs(depth+1, j+1);
			visit[j] = false;
		}
		
	}
}
