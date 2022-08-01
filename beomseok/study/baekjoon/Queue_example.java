package baekjoon;
//큐 백준 10845

//큐 구현 문제

import java.io.*;
import java.util.*;

public class Queue_example {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int back = 0;

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			switch (str) {
			case "push":
				back = Integer.parseInt(st.nextToken());
				q.offer(back);
				break;
			case "pop":
				if (q.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(q.poll() + "\n");
				}
				break;
			case "size":
				sb.append(q.size() + "\n");
				break;
			case "empty":
				if (q.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if (q.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(q.peek() + "\n");
				}
				break;
			case "back":
				if (q.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(back+ "\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}

}
