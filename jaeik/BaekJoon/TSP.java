package BaekJoon;

import java.util.*;
import java.io.*;

public class TSP {
	static int N;
	static int[][] cost;
	static int[] sum;
	static int minsum;
	static boolean[] visit;
	static int first;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		visit = new boolean[N];
		minsum = Integer.MAX_VALUE;
		sum = new int[N];
		first = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			dfs(i, 0);
			first++;
		}
		
		System.out.print(minsum);
	}
	
	static void dfs(int start, int depth) {
		
		if(depth == N - 1) {
			if(cost[start][first] !=0) {
				visit[first] = true;
				sum[depth] = cost[start][first];
				dfs(first, depth + 1);
				visit[first] = false;
			}
		}
		
		if(depth == N) {
			int sumcost = 0;
			for(int i = 0; i < N; i++) {
				sumcost += sum[i];
			}
			minsum = Math.min(minsum, sumcost);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(first != i && !visit[i] && cost[start][i] !=0) {
				visit[i] = true;
				sum[depth] = cost[start][i];
				dfs(i, depth + 1);
				visit[i] = false;
			}
		}
	}
}
