package baekjoon;
//���� �似Ǫ�� ���� 1158

//N���� ����� ��, ���� ���� K(�� N)
//������� K��° ����, ���� ������ �ݺ�

//(N,K)�� �־����� �� ���� ���
//ù° ��: (1 �� K �� N �� 5,000)
import java.io.*;
import java.util.*;

public class Josephus_problem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deq = new ArrayDeque<>();
		
		for (int i=1; i<=n; i++) {
			deq.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(deq.size() > 1 ) {
			for(int j=0; j<k-1; j++) {
				deq.offer(deq.poll());
			}
			sb.append(deq.poll() + ", ");
		}
		sb.append(deq.poll() + ">");
		System.out.println(sb);
	}
}
