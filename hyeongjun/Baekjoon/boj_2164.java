package study1;

/*
 백준 #2064
 N장의 카드 중 맨 위에 있는 카드를 버리고 
 그 다음 제일 위에 있는 카드를 카드 맨 아래로 옮긴다
 N이 주어졌을 때 제일 마지막에 남게 되는 카드를 구하기
 */


import java.io.*;
import java.util.*;

public class boj_2164 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		
		int testcnt = Integer.parseInt(br.readLine());
		
		// testcnt에 N장의 카드를 N,N-1,...,2,1 순으로 삽입 for문
		for(int i = 0; i < testcnt; i++) {
			deque.offerFirst(i+1); 
		}
		
		// 문제 속 주어진 조건 수행 for문
		for(int i = 0; i < testcnt; i++) {
			
			// deque 사이즈가 1일때 까지만 수행
			if(deque.size() == 1) {
				break;
			} else {
				deque.pollLast(); //맨 윗장 버림
				deque.offerFirst(deque.pollLast()); // 그 다음 맨 윗장 맨 아래로
			}
		}
		
		sb.append(deque.peek());
		System.out.println(sb.toString());
				
	}
	
}