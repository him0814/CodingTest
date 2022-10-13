package BOJ;

/*
백준 #9205 맥주 마시면서 걸어가기

거리 = (목표x좌표 - 현재x좌표) + (목표y좌표 - 현재y좌표)
최대 맥주 20병으로 1000m 이동가능

편의점, 페스티벌 좌표 -> al

bfs에서 페스티벌 도착하면 true로
-> 다음 좌표를 들리지 않았고 맥주가 남아있으면 al에 들어있는 좌표 q에 추가
 */

import java.io.*;
import java.util.*;

public class boj_9205 {
	
	static boolean[] visit;
	static ArrayList<int[]> al;
	static Queue<int[]> q;
	static boolean success;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			
			int shop_cnt = Integer.parseInt(br.readLine());
			
			visit = new boolean[shop_cnt + 1]; // visit에 (편의점 좌표 + 페스티벌 좌표) 
			al = new ArrayList<>();
			q = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int house_x = Integer.parseInt(st.nextToken());
			int house_y = Integer.parseInt(st.nextToken());
			q.offer(new int[] {house_x, house_y});
			
			for(int j = 0; j < shop_cnt+1; j++) { // ArrayList에 편의점 좌표 + 페스티벌 좌표
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				al.add(new int[] {x, y});
			}
			
			success = false;
			
			bfs(shop_cnt);
			
			if(success) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int shop_cnt) {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int now_x = now[0];
			int now_y = now[1];
			
			// 페스티벌에 도착했으면
			if(now_x == al.get(al.size() - 1)[0] && now_y == al.get(al.size() - 1)[1]) {
				success = true;
				return;
			} 
			
			for(int i = 0; i < shop_cnt + 1; i++) {
				if(!visit[i]) {
					// 거리 = (목표x좌표 - 현재x좌표) + (목표y좌표 - 현재y좌표)
					// 좌표로 거리 구할 때는 절댓값으로..
					int distance = Math.abs(al.get(i)[0] - now[0]) + Math.abs(al.get(i)[1] - now[1]);
					
					if(distance <= 1000) { // 한 병에 50m가는데 최대 20병이면 1000
						visit[i] = true;
						q.offer(new int[] {al.get(i)[0], al.get(i)[1]});
					}
				}
			}
		}
	}
}
