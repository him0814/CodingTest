package baekjoon;
//백준 요세푸스 문제 1158

//N명의 사람이 원, 양의 정수 K(≤ N)
//순서대로 K번째 제거, 남은 사람들로 반복

//(N,K)가 주어지면 그 순열 출력
//첫째 줄: (1 ≤ K ≤ N ≤ 5,000)
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
