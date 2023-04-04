package baekjoon;
//백준 11404 플로이드

import java.io.*;
import java.util.*;

public class Floyd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(i != j) {
					arr[i][j] = 9900001;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            arr[a][b] = Math.min(arr[a][b], c);
		}
		
		for(int k=1; k<N+1; k++){
			for(int i=1; i<N+1; i++){
				for(int j=1; j<N+1; j++){
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<N+1; i++) {
            for (int j=1; j<N+1; j++) {
                if (arr[i][j] == 9900001) {
                    arr[i][j] = 0;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
		
		System.out.println(sb);
	}
}
