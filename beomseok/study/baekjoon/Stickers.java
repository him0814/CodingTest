package baekjoon;
//백준 9465 스티커

import java.io.*;
import java.util.*;

public class Stickers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr1 = new int[2][N+1];
	        int[][] arr2 = new int[2][N+1];
			
	        for(int j=0; j<2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=1; k<=N; k++) {
					arr1[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			arr2[0][1] = arr1[0][1];
			arr2[1][1] = arr1[1][1];
			
			for(int l=2; l<=N; l++) {
				arr2[0][l] = Math.max(arr2[1][l-1], arr2[1][l-2]) + arr1[0][l];
				arr2[1][l] = Math.max(arr2[0][l-1], arr2[0][l-2]) + arr1[1][l];
			}
			
			sb.append(Math.max(arr2[0][N], arr2[1][N]) + "\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
