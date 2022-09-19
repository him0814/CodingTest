package BOJ;

/*
���� #3986
���� �ܾ� ã��
���� �ܾ� : ���� �� ��ġ�� ��� �׾� �� ��ġ�� �����ܾ�
���ڿ��� ���� �ܾ� ���� ��Ī�� �Ǹ� �����ܾ� -> stack���� Ǯ�� �ɵ�
 */

import java.io.*;
import java.util.*;

public class boj_3986 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_cnt = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < test_cnt; i++) {
			
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				// ó�� ���Ե� ����(peek())�� ���� ���ڸ� ���� ������ pop() �ٸ��� push()
				if(!stack.isEmpty() && stack.peek() == str.charAt(j)) {
					stack.pop();
				} else { // stack.peek() != str.charAt(i)
					stack.push(str.charAt(j));
				}
			}
			if(stack.size() == 0) {
				count++;
			}
		}
		sb.append(count);
		System.out.println(count);
	}
}