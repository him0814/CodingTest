package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1966번 프린터 큐

public class Baekjoon_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());

		while (num-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			LinkedList<int[]> dq = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				dq.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}

			int count = 0;

			while (!dq.isEmpty()) {
				int tmp[] = dq.poll();
				boolean max = true;

				for (int i = 0; i < dq.size(); i++) {
					if (tmp[1] < dq.get(i)[1]) {
						dq.offer(tmp);
						for (int j = 0; j < i; j++)
							dq.offer(dq.poll());
						max = false;
						break;
					}
				}

				if (max == false)
					continue;

				count++;

				if (tmp[0] == M)
					break;
			}

			sb.append(count).append('\n');
		}

		System.out.println(sb.toString());
	}
}