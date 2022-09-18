package study1;

/*
 백준 #1966
 중요도에 따른 프린터 순서 
 
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
				// Collections.max() -> queue의 가장 큰 수
				// Collections.min() -> queue의 가장 작은 수
				// Collections 쓰려면 int로
				// Collections.reverseOrder(); 내림차순
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