package study1;

/*
���� #10773
��θ� �����ϴ� ����
�߸��� ���� �θ� �� ���� 0�� ���ļ� �ֱٿ� ���� ���� ����
K���� ���� 1���� �־��� 
���������� ��� ���� ���� ���
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
			
			// 0�̸� pop -> ������ ����ִ����� ����
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