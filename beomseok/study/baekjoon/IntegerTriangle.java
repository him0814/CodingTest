package baekjoon;
//백준  1932 정수 삼각형

import java.io.*;
import java.util.*;

public class IntegerTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
	    for(int i=arr.length-1; i>0; i--){
	        for(int j=0; j<arr[i].length-1; j++){
	            arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
	        }
	        res = arr[0][0];
	    }
	    System.out.println(res);
	}
}
