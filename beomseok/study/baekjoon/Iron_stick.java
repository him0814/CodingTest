package baekjoon;
//�踷��� ���� 10799

//���� �����̿��� ��ȣ ������ ���
//�������� ���� ��ȣ�� �ݴ� ��ȣ�� ������ �� ��( )�� ���� ǥ�� 
//��� ��( )���� �ݵ�� �������� ǥ��

import java.io.*;
import java.util.*;

public class Iron_stick {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		int cnt = 0;
		
		for (int i=0; i<str.length(); i++) {
			char p = str.charAt(i);
			if(p == '(') {
				stack.push(p);
			} else if(p == ')') {
				stack.pop();
				if(str.charAt(i-1) == '(') {
					cnt += stack.size();
				} else {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
