package BOJ;

/*
백준 #11399 ATM
시간제한 : 1초
N (1~1000) / Pi (1~1000)
오름차순 정렬 후 더한 값을 누적 합 하면 될 것 같음
 */

import java.io.*;
import java.util.*;

public class boj_11399 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = Integer.parseInt(br.readLine());
		int[] time = new int[people];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < people; i++) {
			int num = Integer.parseInt(st.nextToken());
			time[i] = num;
		}
		
		// time 배열 오름차순 정렬
		Arrays.sort(time);
		
		int answer = 0;
		int total = 0;
		
		for(int i = 0; i < time.length; i++) {
			total += time[i];
			answer += total;
		}
		System.out.println(answer);
	}
}
