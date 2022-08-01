package baekjoon;
//백준 스택 10828

//push X: 정수 X를 스택에 넣는 연산
//pop: 스택에서 가장 위에 있는 정수를 빼고 그 수 출력. 스택에 들어있는 정수가 없는 경우에 -1 출력
//size: 스택에 들어있는 정수의 개수를 출력
//empty: 스택이 비어있으면 1, 아니면 0을 출력
//top: 스택의 가장 위에 있는 정수를 출력. 스택에 들어있는 정수가 없는 경우에 -1 출력
//첫째 줄: 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)
//둘째 줄: N개의 줄에는 명령이 하나씩

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
