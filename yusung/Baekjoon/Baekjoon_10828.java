package Baekjoon;

import java.io.*;
import java.util.*;

//백준 10828번 스택

public class Baekjoon_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();

			if (str.equals("push")) {
				int m = Integer.parseInt(st.nextToken());
				stack.push(m);
			} 
			else if (str.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			} 
			else if (str.equals("size")) {
				int size = stack.size();
				sb.append(size).append("\n");
			} 
			else if (str.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} 
			else if (str.equals("top")) {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					int top = stack.peek();
					sb.append(top).append("\n");
				}
			}

		}
		System.out.println(sb.toString());
	}
}
