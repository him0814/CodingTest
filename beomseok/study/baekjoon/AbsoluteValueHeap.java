package baekjoon;
//Àý´ñ°ª Èü ¹éÁØ 11286

import java.io.*;
import java.util.*;

public class AbsoluteValueHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				} else if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				} else {
					return -1;
				}
			}
		});
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (q.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(q.poll() + "\n");
				}
			} else {
				q.offer(x);
			}
		}
		System.out.println(sb);
	}
}