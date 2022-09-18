package study1;

/*
백준 #1158
요세푸스 순열 문제
1~N까지 인원이 원을 그리고 앉아있음
순서대로 K번째 사람을 N명의 사람이 모두 제거될때까지 계속 제거
 */

import java.io.*;
import java.util.*;

public class boj_1158 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
				
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		
		while(!queue.isEmpty()) {
			for(int k = 0; k < K-1; k++) {
				int pollnum = queue.poll();
				queue.offer(pollnum);
			}
			if(queue.size() == 1) { // 마지막 사람 제거 시 ", " 뒤에 안 붙게 하기위함
				int del_num = queue.poll();
				sb.append(del_num);
			} else {
				int del_num = queue.poll();
				sb.append(del_num).append(", ");
			}
		}
		//sb.setLength(sb.length()-1); 마지막 요소 지우는
		sb.append(">");
		System.out.println(sb.toString());
	}
}
