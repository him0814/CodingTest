package BaekJoon;

import java.util.*;
import java.io.*;
public class Lotto {
	static int[] arr;
	static int n;
	static boolean[] visit;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n == 0) {
				break;
			}
			arr = new int[n];
			visit = new boolean[n];
			result = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("\n");
		}
		sb.setLength(sb.length() - 2);
		System.out.print(sb);
		
	}
	static void dfs(int depth, int start) {
		
		if(depth == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			
			if(!visit[i] && arr[i] > start) {
				visit[i] = true;
				result[depth] = arr[i];
				dfs(depth + 1, arr[i]);
				visit[i] = false;
			}
		}
	}
}
