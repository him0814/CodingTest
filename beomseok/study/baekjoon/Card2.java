package baekjoon;
// 백준 카드2 2164

//1~N까지 번호, 1번카드 제일 위 N번카드 제일 아래
//N=4일때, 1234 순서  
//제일 위 버리기 -> 제일 위 제일 아래로 옮기기 -> 한장 남을 때 까지 반복

//첫째 줄: 정수 N(1 ≤ N ≤ 500,000)

import java.io.*;
import java.util.*;

public class Card2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			deq.offer(i);
		}
		while(deq.size() > 1) {
			deq.poll();
			deq.offer(deq.poll());
		}
		System.out.println(deq.poll());
	}
}
