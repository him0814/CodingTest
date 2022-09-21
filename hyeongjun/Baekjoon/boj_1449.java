package BOJ;

/*
백준 #1449 수리공 항공
시간제한: 2초 -> 20억
N,L -> 각각 1000

1. 처음 물이 새는 곳 (N -0.5) +L 
2. 다음 물 새는곳 (N+1-0.5) < (N -0.5) +L 보다 작으면 테이프 붙일 필요 없음
3. (N -0.5) +L < (N+1-0.5) 가 되는 곳부터 다시 테이프를 붙이면 됨
 */

import java.io.*;
import java.util.*;

public class boj_1449 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 물 새는 곳 개수
		int L = Integer.parseInt(st.nextToken()); // 테이프의 길이
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// 물 새는 곳을 arr 배열에 담음
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 예제 입력3 같이 3 2 1이 담길 수도 있기 때문에 정렬
		Arrays.sort(arr);
		
		// 1. 처음 물이 새는 곳 (N -0.5) +L 
		double range = (arr[0] - 0.5) + L; // ex) 3.5
		int count = 1; // 테이프 갯수 -> 이미 하나 붙인 상태
		
		for(int i = 0; i < arr.length; i++) {
			// 2. 다음 물 새는곳 (N+1-0.5) < (N -0.5) +L 보다 작으면 테이프 붙일 필요 없음
			if(range <= arr[i] - 0.5) {
				// 3. 3. (N -0.5) +L < (N+1-0.5) 가 되는 곳부터 다시 테이프를 붙이면 됨
				range = arr[i] - 0.5 + L;
				count++; // 테이프 갯수 +1
			}
		}
		
		System.out.println(count);
	}
}
