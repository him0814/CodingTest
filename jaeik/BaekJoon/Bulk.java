package BaekJoon;
// 2 ≤ N ≤ 50
// 10 ≤ x, y ≤ 200

import java.util.*;
import java.io.*;

public class Bulk {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int count = 1;
			for(int j = 0; j < N; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					count++;
				}
			}
			sb.append(count).append(" ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
