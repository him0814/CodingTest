package baekjoon;
//ȸ���ϴ� ť ���� 1021

//N���� ����� ��ȯ ť
//1.ù ��° ���Ҹ� �̾Ƴ��� a1~ak�� a2~ak�� �ȴ�
//2.�������� �� ĭ �̵� �� a1~ak�� a1~ak,a1�� �ȴ�.
//3.���������� �� ĭ �̵� �� a1~ak�� ak,a1~a(k-1)�� �ȴ�.
//N�� �־����� �������� ���� ��ġ �־���.
//������� �̾Ƴ��µ� ��� 2,3�� ������ �ּҰ� ���.

//ù° ��: ť�� ũ�� N(>= 50) , �̾Ƴ� ���� ���� M(<=N)
//��° ��: 1 <= �̾Ƴ� ���� ��ġ <= N

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
