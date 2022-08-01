package baekjoon;
//���� ���� 10828

//push X: ���� X�� ���ÿ� �ִ� ����
//pop: ���ÿ��� ���� ���� �ִ� ������ ���� �� �� ���. ���ÿ� ����ִ� ������ ���� ��쿡 -1 ���
//size: ���ÿ� ����ִ� ������ ������ ���
//empty: ������ ��������� 1, �ƴϸ� 0�� ���
//top: ������ ���� ���� �ִ� ������ ���. ���ÿ� ����ִ� ������ ���� ��쿡 -1 ���
//ù° ��: �־����� ����� �� N (1 �� N �� 10,000)
//��° ��: N���� �ٿ��� ����� �ϳ���

import java.io.*;
import java.util.*;

public class Stack_example {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String string = st.nextToken();
			if (string.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (string.equals("pop")) {
				if (!stack.empty())
					sb.append(stack.pop()).append("\n");
				else
					sb.append(-1).append("\n");
			} else if (string.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (string.equals("empty")) {
				if (!stack.empty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
			} else {
				if (!stack.empty())
					sb.append(stack.peek()).append("\n");
				else
					sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}
}
