package BOJ;

/*
���� #17298 ��ū��

��ū�� -> �����ʿ� �����鼭 �迭 ���� A(n) ���� ū �� �߿� ���� ���ʿ� �ִ� ��
��ū���� ������ -1 ���

   3 5 2 7
-> 5 7 7 -1

    9 5 4 8
-> -1 8 8 -1

ex) test
arr     3 5 2 7
stack   7 5
answer  5 7 7 -1

stack�� ������ arr�迭 ���� ���� push
stack.peek() <= (������-1) �ε��� �迭  �̸� stack.pop()
stack.push((������-1) �ε��� �迭)
�ݺ�..

 */

import java.io.*;
import java.util.*;

public class boj_17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n]; // �Է� ���� �迭
		int[] answer = new int[n]; // ���� ���� �迭
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// �迭 ������ ����( �ε��� n-1 ) 
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
