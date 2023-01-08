package BOJ;

/*
백준 #17298 오큰수

오큰수 -> 오른쪽에 있으면서 배열 원소 A(n) 보다 큰 수 중에 가장 왼쪽에 있는 수
오큰수가 없으면 -1 출력

   3 5 2 7
-> 5 7 7 -1

    9 5 4 8
-> -1 8 8 -1

ex) test
arr     3 5 2 7
stack   7 5
answer  5 7 7 -1

stack에 마지막 arr배열 원소 먼저 push
stack.peek() <= (마지막-1) 인덱스 배열  이면 stack.pop()
stack.push((마지막-1) 인덱스 배열)
반복..

 */

import java.io.*;
import java.util.*;

public class boj_17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n]; // 입력 받을 배열
		int[] answer = new int[n]; // 정답 담을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 배열 끝부터 보기( 인덱스 n-1 ) 
		for(int i = n-1; i >= 0; i--) {
			
			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				answer[i] = -1;
			} else {
				answer[i] = stack.peek();
			}
			
			stack.push(arr[i]);
		}
		
		for(int i: answer) {
			sb.append(i+" ");
		}
		
		System.out.println(sb.toString());
	}
}
