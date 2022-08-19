package Baekjoon;

import java.io.*;
import java.util.*;

//백준 9205번 맥주 마시면서 걸어가기
//맥주를 20병을 가지고 출발, 50미터가 되기전에 한병씩 마심, 맥주를 더구매해야될수도있음 가질수있는 맥주의 개수는 20병을 넘을수 없음
//맥주 구매하고나서도 50미터 가기전에 맥주한병을 마셔야함
//첫줄에 테스트케이스의 개수 t
//다음 줄부터 상근이네집 좌표, 편의점 집 좌표, 펜타포트 락 페스티벌 좌표가 주어짐(xy값 모두 -32768~32767)
//각 테스트 케이스에 대해 갈수있으면 happy, 더 이동할 수 없으면 sad를 출력한다.

public class Baekjoon_9205 {

	static int t; // 테스트케이스개수
	static int n; // 편의점의 개수
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n + 2][2];

			for (int j = 0; j < n + 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				map[j][0] = Integer.parseInt(st.nextToken());
				map[j][1] = Integer.parseInt(st.nextToken());

			}

			if (bfs(0)) {
				sb.append("happy" + "\n");
			} else {
				sb.append("sad" + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static boolean bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[n + 2];

		q.offer(x);
		visit[x] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < n + 2; i++) {
				if (!visit[i]) {
					if (Math.abs(map[now][0] - map[i][0]) + Math.abs(map[now][1] - map[i][1]) <= 1000) {
						q.offer(i);
						visit[i] = true;
						if (i == n + 1) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
