package baekjoon;
// ���� ���� 10773

//������ �߸��� �� �θ� �� ���� 0, ����� �� �� ����  ��> ���� �θ��� push, 0�̸� pop
//�׷��� �޾����� ��� �� �� ���

//ù��° ��: ���� K(1 �� K �� 100,000)
//����: K�� �� ��ŭ ���� 1����

import java.io.*;
import java.util.*;

public class Zero_That_Out {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				stack.pop();
			else
				stack.push(n);
		}
		int sum = 0;
		for(int r : stack) {
			sum +=r;
		}
		System.out.println(sum);
	}
}
