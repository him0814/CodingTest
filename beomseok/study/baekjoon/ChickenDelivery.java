package baekjoon;
//백준 15686 치킨 배달

import java.io.*;
import java.util.*;

public class ChickenDelivery {
	static int N,M;
	static int[][] arr;
	static boolean[] visit;
	static List<int[]> house;
	static List<int[]> chicken_restaurant;
	static int res;
	
	public static void main(String srgs[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N]; 
		
		house = new ArrayList<>();
		chicken_restaurant = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					house.add(new int[] {i,j});
				} else if(arr[i][j] == 2) {
					chicken_restaurant.add(new int[] {i,j});
				}
			}
		}
		
		visit = new boolean[chicken_restaurant.size()];
		res = Integer.MAX_VALUE;
		
		dfs(-1, 0);
		System.out.println(res);
	}
	
	public static void dfs(int at, int depth) {
		if(depth == M) {
			int distance = 0;
			for(int i=0; i<house.size(); i++) {
				int tmp = Integer.MAX_VALUE;
				for(int j=0; j<chicken_restaurant.size(); j++) {
					if(visit[j]) {
						int mindist = Math.abs(house.get(i)[0] - chicken_restaurant.get(j)[0]) + 
								Math.abs(house.get(i)[1] - chicken_restaurant.get(j)[1]);
						tmp = Math.min(tmp, mindist);
					}
				}
				distance += tmp;
			}
			res = Math.min(res, distance);
			return;
		}
		
		for(int i=at+1; i<chicken_restaurant.size(); i++) {
			visit[i] = true;
			dfs(i, depth+1);
			visit[i] = false;
		}
	}
}
