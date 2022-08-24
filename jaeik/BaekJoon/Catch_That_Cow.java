package BaekJoon;
// N(0 ≤ N ≤ 100,000), K(0 ≤ K ≤ 100,000) 
// 앞뒤 혹은 위치의 2배

import java.util.*;
import java.io.*;

public class Catch_That_Cow {
	static boolean[] visit;
	static int[] hide;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];
		hide = new int[100001];
		bfs(start);
		System.out.print(hide[end]);
	}
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visit[x] = true;
		hide[x] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int m1 = now - 1;
			int m2 = now + 1;
			int m3 = now*2;
			if(m1 >= 0 && m1 <= 100000 && !visit[m1]) {
				q.offer(m1);
				visit[m1] = true;
				hide[m1] = hide[now] + 1;
			}
			if(m2 >= 0 && m2 <= 100000 && !visit[m2]) {
				q.offer(m2);
				visit[m2] = true;
				hide[m2] = hide[now] + 1;
			}
			if(m3 >= 0 && m3 <= 100000 && !visit[m3]) {
				q.offer(m3);
				visit[m3] = true;
				hide[m3] = hide[now] + 1;
			}
		}
	}
}
