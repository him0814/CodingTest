package baekjoon;
//RGB거리 백준 1149

import java.io.*;
import java.util.*;

public class RGBstreet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][3];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<n; i++) {
			house[i][0] += Math.min(house[i-1][1], house[i-1][2]);
			house[i][1] += Math.min(house[i-1][0], house[i-1][2]);
			house[i][2] += Math.min(house[i-1][0], house[i-1][1]);
		}
		int min = Math.min(house[n-1][0], Math.min(house[n-1][1], house[n-1][2]));
		System.out.println(min);
	}
}
