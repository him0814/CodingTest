package Baekjoon;

import java.io.*;
import java.util.*;

//백준 5430번 AC

public class Baekjoon_5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<String> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			boolean flag = false;
			boolean er = false;
			String cal = br.readLine().replace("RR", "");
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			str = str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", " ");
			StringTokenizer st = new StringTokenizer(str);
			for (int j = 0; j < n; j++) {
				dq.add(st.nextToken());
			}
			for (int k = 0; k < cal.length(); k++) {
				if (cal.charAt(k) == 'R') {
					flag = !flag;
				}
				if (cal.charAt(k) == 'D') {
					if (dq.isEmpty()) {
						er = true;
					} else {
						if (flag) {
							dq.pollLast();
						} else {
							dq.pollFirst();
						}
					}
				}
			}
			if (er) {
				sb.append("error").append("\n");
			} else {
				sb.append("[");
				while (!dq.isEmpty()) {
					if (flag) {
						sb.append(dq.pollLast());
					} else {
						sb.append(dq.pollFirst());
					}
					if (!dq.isEmpty()) {
						sb.append(",");
					}
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
