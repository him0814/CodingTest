package baekjoon;

import java.io.*;
import java.util.*;

public class DivideByRectangles {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++){
			String str = br.readLine();
			for (int j = 0; j < M; j++){
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		long a, b, c, max = 0;
		//1
		for (int i=0; i<M-2; i++) {
			for (int j=i+1; j<M-1; j++){
				a = sum(0, 0, i, N-1);
				b = sum(i+1, 0, j, N-1);
				c = sum(j+1, 0, M-1, N-1);
				max = Math.max(max, a*b*c);
			}
		}
		//2
		for (int i=0; i<N-2; i++) {
			for (int j=i+1; j<N-1; j++){
				a = sum(0, 0, M-1, i);
				b = sum(0, i+1, M-1, j);
				c = sum(0, j+1, M-1, N-1);
				max = Math.max(max, a*b*c);
			}
		}
		//1
		for (int i=0; i<M-1; i++) {
			for (int j=0; j<N-1; j++){
				a = sum(0, 0, i, N-1);
				b = sum(i+1, 0, M-1, j);
				c = sum(i+1, j+1, M-1, N-1);
				max = Math.max(max, a*b*c);
			}
		}
		//2
		for (int i=M-1; i>0; i--) {
			for (int j=0; j<N-1; j++){
				a = sum(i, 0, M-1, N-1);
				b = sum(0, 0, i-1, j);
				c = sum(0, j+1, i-1, N-1);
				max = Math.max(max, a*b*c);
			}
		}
		//3
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<M-1; j++){
				a = sum(0, 0, M-1, i);
				b = sum(0, i+1, j, N-1);
				c = sum(j+1, i+1, M-1, N-1);
				max = Math.max(max, a*b*c);
			}
		}
		//4
		for (int i=N-1; i>0; i--) {
			for (int j=0; j<M-1; j++){
				a = sum(0, i, M-1, N-1);
				b = sum(0, 0, j, i-1);
				c = sum(j+1, 0, M-1, i-1);
				max = Math.max(max, a*b*c);
			}
		}
		//5
		for (int i=0; i<M-2; i++) {
			for (int j=i+1; j<M-1; j++){
				a = sum(0, 0, i, N-1);
				b = sum(i+1, 0, j, N-1);
				c = sum(j+1, 0, M-1, N-1);
				max = Math.max(max, a*b*c);
			}
		}
		//6
		for (int i=0; i<N-2; i++) {
			for (int j=i+1; j<N-1; j++){
				a = sum(0, 0, M-1, i);
				b = sum(0, i+1, M-1, j);
				c = sum(0, j+1, M-1, N-1);
				max = Math.max(max, a*b*c);
			}
		}
		System.out.println(max);
	}
	
	public static long sum(int x1, int y1, int x2, int y2) {
		long res = 0;
		for (int i = y1; i <= y2; i++){
			for (int j = x1; j <= x2; j++){
				res += arr[i][j];
			}
		}
		return res;
	}
}
