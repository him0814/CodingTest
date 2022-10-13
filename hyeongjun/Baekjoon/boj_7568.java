package BOJ;

/*
시간제한: 1초 -> 10억
n -> 50
x -> 200 / y -> 200

1. 이차원 배열 {키, 몸무게} 선언
2. 이중 for문으로 첫번째 요소를 나머지 요소와 비교하여 작으면 순위+1
 */

import java.io.*;
import java.util.*;

public class boj_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2]; // {키, 몸무게}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			int rank = 1;
			
			for(int j = 0; j < arr.length; j++) {
				if(i == j) { // 같은 사람 일 때 
					continue;
				}
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			System.out.println(rank);
		}
	}
}
