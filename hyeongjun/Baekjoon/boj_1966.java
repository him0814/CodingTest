package study1;

/*
 ���� #1966
 �߿䵵�� ���� ������ ���� 
 
 */

import java.io.*;
import java.util.*;

public class boj_1966 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testcnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int doc_cnt = Integer.parseInt(st.nextToken());
			int importance = Integer.parseInt(st.nextToken());

			Queue<Integer> queue = new LinkedList<>();
			Queue<Integer> index_queue = new LinkedList<>();

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < doc_cnt; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
				index_queue.offer(j);
			}
			
			int count = 1;

			while (!queue.isEmpty()) {
				// Collections.max() -> queue�� ���� ū ��
				// Collections.min() -> queue�� ���� ���� ��
				// Collections ������ int��
				// Collections.reverseOrder(); ��������
				int max = Collections.max(queue);
				int now = queue.poll();
				int now_index = index_queue.poll();
				
				
				
				if(now == max) {
					if(now_index == importance) {
						sb.append(count).append("\n");
						break;
					}
					count++;
				} else {
					queue.offer(now);
					index_queue.offer(now_index);
				}
			}
		}
		System.out.println(sb.toString());
	}
}