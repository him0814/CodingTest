package study1;

/*
백준 #10773
장부를 관리하는 문제
잘못된 수를 부를 때 마다 0을 외쳐서 최근에 쌓인 수를 제거
K개의 정수 1개씩 주어짐 
최종적으로 적어낸 수의 합을 출력
*/

import java.io.*;
import java.util.*;

public class boj_10773 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int testcnt = Integer.parseInt(br.readLine());
		int total = 0;
		
		for(int i = 0; i < testcnt; i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			// 0이면 pop -> 스택이 비어있는지도 생각
			if(num == 0) {
				if(stack.isEmpty()) {
					break;
				}else {
					stack.pop();
				}
			} else {
				stack.push(num);
			}
		}
		
		while(!stack.empty()) {
			total += stack.pop();
		}
		
		sb.append(total);
		System.out.println(sb.toString());
		
	}
}