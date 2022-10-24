package BOJ;

/*
백준 #1912 연속합

연속된 숫자의 합보다 절댓값이 큰 음수가 나오면, 즉 합이 음수가 되면 최댓값이 될 수 없음
-> 연속된 숫자의 합보다 절댓값이 큰 음수가 나오면 다음 연속값의 합을 구해서 그 합 중 최댓값을 출력
 */

import java.io.*;
import java.util.*;

public class boj_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // 예제 입력
		int[] tmp = new int[N]; // 연속된 수의 합을 넣을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tmp[0] = arr[0];
		
		for(int i = 1; i < N; i++) {
			tmp[i] = Math.max(arr[i], tmp[i-1] + arr[i]);
			//System.out.println(tmp[i]);
		}
		
		Arrays.sort(tmp);
		System.out.println(tmp[N-1]);
	}
}
