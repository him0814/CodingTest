package baekjoon;
//πÈ¡ÿ 1260 DFSøÕ BFS

import java.io.*;
import java.util.*;

public class DFSandBFS {
	static int N; 
	static int M; 
	static int V; 
	static int[][] arr; 
	static boolean[] visit; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			    
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		 dfs(V);
		 System.out.println();
		 bfs(V);
	}
	
	 public static void dfs(int v) {
		 visit[v] = true;
		 System.out.print(v + " ");
		 
		 if(v == arr.length) {
			 return;
		 }
		 
		 for(int i=1; i<arr.length; i++) {
			 if(arr[v][i] == 1 && !visit[i]){
		        dfs(i);
			 }
		 }
	 }
	 
	 private static void bfs(int v) {
		 Queue<Integer> q = new LinkedList<Integer>();
		 q.offer(v);
		 visit = new boolean[N+1];
		 visit[v] = true;

		 System.out.print(v + " ");

		 while (!q.isEmpty()) {
			 int p = q.poll();
			 for (int i=1; i<arr.length; i++) {
				 if (arr[p][i] == 1 && !visit[i]) {
					 visit[i] = true;
					 System.out.print(i + " ");
					 q.offer(i);
				 }
			 }
		 }
	 }
}
