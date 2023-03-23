package baekjoon;
//백준 1389 케빈 베이컨의 6단계 법칙

import java.io.*;
import java.util.*;

public class KevinBacon6stepRule {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(i != j) {
					arr[i][j] = 5001;
				}
			}
		}
		
		for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
		
		for(int k=1; k<N+1; k++){
			for(int i=1; i<N+1; i++){
				for(int j=1; j<N+1; j++){
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
        int res = 0;

        for(int i=1; i<N+1; i++){
            int sum = 0;
            
            for(int j=1; j<N+1; j++) {
            	sum += arr[i][j];
            }
            
            if(min > sum){
                min = sum;
                res = i;
            }
        }
        System.out.println(res);
	}
}
