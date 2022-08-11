package BaekJoon;

import java.util.*;
import java.io.*;

public class NandM3 {
	
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
		
		dfs(0);
		System.out.print(sb);
	}
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
}
