package BaekJoon;

import java.util.*;
import java.io.*;

public class NandM2 {
	
	static int N;
	static int M;
	
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		arr = new int[M];
		
		dfs(0, 1);
		System.out.print(sb);
	}
	
	static void dfs(int depth, int at) {
		if(depth == M) {
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}
}
