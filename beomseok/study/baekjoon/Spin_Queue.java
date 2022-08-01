package baekjoon;
//회전하는 큐 백준 1021

//N개의 양방향 순환 큐
//1.첫 번째 원소를 뽑아내면 a1~ak가 a2~ak로 된다
//2.왼쪽으로 한 칸 이동 시 a1~ak가 a1~ak,a1이 된다.
//3.오른쪽으로 한 칸 이동 시 a1~ak가 ak,a1~a(k-1)이 된다.
//N이 주어지고 뽑으려는 원소 위치 주어짐.
//순서대로 뽑아내는데 드는 2,3번 연상의 최소값 출력.

//첫째 줄: 큐의 크기 N(>= 50) , 뽑아낼 원소 개수 M(<=N)
//둘째 줄: 1 <= 뽑아낼 수의 위치 <= N

import java.io.*;
import java.util.*;

public class Spin_Queue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> deq = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			deq.offer(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < M; j++) {
			int num = Integer.parseInt(st.nextToken());
			while (deq.peekFirst() != num) {
				if (deq.indexOf(num) <= (deq.size() / 2)) {
					deq.offerLast(deq.peekFirst());
					deq.pollFirst();
				} else {
					deq.offerFirst(deq.peekLast());
					deq.pollLast();
				}
				cnt++;
			}
			if (deq.peekFirst() == num) {
				deq.pollFirst();
			}
		}
		System.out.println(cnt);
	}
}
