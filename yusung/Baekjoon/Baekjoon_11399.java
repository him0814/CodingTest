package Baekjoon;

import java.util.*;
import java.io.*;

//백준 11399번 ATM
//첫째 줄에 사람의 수 N(1~1000), 둘째 줄 부터 사람이 돈을 인출하는데 걸리는 시간Pi가 주어짐
//입력받아서 배열에 넣고 배열을 오름차순으로 정렬한다음 누적으로 합하면될거같음
//시간제한 1초 -> for문 한번
//tmp에 각각 배열을 누적해서 담고, 누적해서 담긴 합을 answer에 누적해서 더해줌

public class Baekjoon_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);

		int answer = 0;
		int tmp = 0;

		for (int i = 0; i < N; i++) {
			tmp += time[i];
			answer += tmp;
		}
		System.out.println(answer);
	}
}
