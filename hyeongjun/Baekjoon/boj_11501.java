package BOJ;

/*
백준 #11501 주식
시간제한: 5초 -> 50억
N <= 1,000,000
주가 <= 10,000


1. 주식의 가격이 가장 비싼 날을 선언 -> max라고 하겠음
2. max보다 작은 가격일땐 매일 삼
3. max인 날 주식 다 팔기
4. max 다음 날부터 다시 max값 갱신
5. 반복

 */

import java.io.*;
import java.util.*;

public class boj_11501 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			int day = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// arr배열에 주식의 가격 삽입
			int[] arr = new int[day];
			for(int j = 0; j < day; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			long profit = 0;
			
			for(int j = day - 1; j >= 0; j--) {
				if(max < arr[j]) {
					max = arr[j];
				} else {
					profit += max - arr[j];
				}
			}
			sb.append(profit+"\n");
		}
		
		System.out.println(sb.toString());
	}
}