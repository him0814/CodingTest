package BaekJoon;
// 첫째 줄 전체 사람 n
// 둘째 줄 계산해야 하는 서로 다른 두 사람
// 셋째 줄에는 부모 자식들 간의 관계의 개수 M
// 넷째 줄부터는 부모 자식간의 관계 두 번호 x,y 각 줄 x는 y의 부모

import java.util.*;
import java.io.*;
public class Kinship {
	static int[][] arr;
	static int[] cnt;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		cnt = new int[n+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			arr[p1][p2] = 1;
			
		}
	
		
		bfs(start, end);
		System.out.print(cnt[end]);
	}
	
	static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		cnt[x] = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 1; i <= n; i++) {
				
				for(int j = 1; j <= n; j++) {
					if(arr[now][j] == 1 && cnt[j] == 0) {
						q.offer(j);
						cnt[j] = cnt[now] + 1;
					}
					if(arr[i][now] == 1 && cnt[i] == 0) {
						q.offer(i);
						cnt[i] = cnt[now] + 1;
					}
				}
			}
		}
		if(cnt[y] == 0) {
			cnt[y] = -1;
		}
	}
}
