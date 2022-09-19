package BOJ;

/*
���� #10799
�踷��� ����
��ȣ ������ �ƶ� �Ȱ���
 */

import java.io.*;
import java.util.*;

public class boj_10799 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		int count = 0;
				
		for(int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if(str.charAt(i) == '(') {
				stack.push('(');
			} else {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				
				if(now == str.charAt(i-1)) { // '))' �� ���� 1�� ����⶧�� 
					count++;
				} else {
					count += stack.size();
				}
			}
		}
		System.out.println(count);
	}
}
