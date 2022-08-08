package BaekJoon;

// n개의 테스트 케이스
// 문서의 개수 N, N보다 작은 위치를 알려주는 M 범위 0~N-1

import java.io.*;
import java.util.*;

public class printer_que {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st1.nextToken());
			int location = Integer.parseInt(st1.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			Deque<Integer> deq = new ArrayDeque<>();
			
			for(int x = 0; x < size; x++) {
				deq.offerLast(Integer.parseInt(st2.nextToken()));
			}
			int count = 0;
			loop:
			for(int j = 9; j >=1; j--) {
				for(int k = 0; k < size; k++) {
					if(deq.peek() == j) {
						if(location == 0) {
							count++;
							break loop;
						} else {
							deq.pollFirst();
							count++;
							location--;							
						}
					} else {
						deq.offerLast(deq.pollFirst());
						if(location == 0) {
							location = deq.size() - 1;
						} else {
							location--;
						}
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}
