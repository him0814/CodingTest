package BOJ;

/*
백준 #2346
1~N 개의 풍선을 1번부터 터뜨린다
풍선 안에는 -N~N까지 정수가 있고
N>0, N만큼 오른쪽의 풍선 터뜨림
N<0, N만큼 왼쪽의 풍선 터뜨림
단, 터진 풍선은 빼고 진행
 */

import java.io.*;
import java.util.*;

public class boj_2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// queue를 써봤지만 양방향으로 움직이면서 지워워야하므로 덱씀
		Deque<int[]> deque = new ArrayDeque<>();
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < test_cnt; i++) {
			deque.offer(new int[] {(i+1), Integer.parseInt(st.nextToken())}); // 인덱스 / 풍선번호
		}
		
		// 첫번째 풍선 먼저 터짐
		sb.append("1 ");
		int[] arr = deque.poll();
		int num = arr[1];
		
		while(!deque.isEmpty()) {
			if(num > 0) {
				for(int k = 1; k < num; k++) {
					deque.offerLast(deque.pollFirst());
				}
				int[] next_num = deque.poll();
				num = next_num[1];
				sb.append(next_num[0]+" ");
			}
			else { // num < 0
				for(int l = 1; l < -num; l++) {
					deque.offerFirst(deque.pollLast());
				}
				int[] next_num = deque.pollLast();
				num = next_num[1];
				sb.append(next_num[0]+" ");				
			}
		}
		System.out.println(sb.toString());
	}
}
