package Baekjoon;

import java.io.*;
import java.util.*;

//백준 3190 뱀
public class Baekjoon_3190 {
	static int[] dx = { 0, 1, 0, -1 };// 오른쪽, 90도 아래(D), 왼쪽, 90도 위(L) -> 시계방향 회전
	static int[] dy = { 1, 0, -1, 0 };
	static int dxdyidx = 0;
	static int N;
	static Deque<int[]> dq;
	static int[][] arr;
	static Map<Integer, String> hm;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1]; // 게임맵의 크기
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; // 사과의 위치는 1로
		}

		int L = Integer.parseInt(br.readLine());
		hm = new HashMap<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			hm.put(a, b);
		}
		dq = new ArrayDeque<>(); // 뱀의 머리,꼬리 위치를 담을 리스트
		dq.offer(new int[] { 1, 1 });

		int res = solve();
		System.out.println(res);

//		출력 테스트
//		for(int i=1; i<N+1; i++) {
//			for(int j=1; j<N+1; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
	}

	private static int solve() {
		int cnt = 0;
		int nowx = 1;
		int nowy = 1;
		while (true) {
			cnt++;
			int nx = nowx + dx[dxdyidx];
			int ny = nowy + dy[dxdyidx];

			if (!end(nx, ny)) {
				break;
			}

			if (arr[nx][ny] == 1) {
				arr[nx][ny] = -1;
				dq.offer(new int[] { nx, ny });
			} else {
				arr[nx][ny] = -1;
				dq.offer(new int[] { nx, ny });
				int[] tmp = dq.pollFirst();
				arr[tmp[0]][tmp[1]] = 0;
			}
			nowx = nx;
			nowy = ny;

			if (hm.containsKey(cnt)) {
				if (hm.get(cnt).equals("D")) {
					dxdyidx++;
					if (dxdyidx == 4) {
						dxdyidx = 0;
					}
				}
				if (hm.get(cnt).equals("L")) {
					dxdyidx--;
					if (dxdyidx == -1) {
						dxdyidx = 3;
					}
				}
			}
		}
		return cnt;
	}

	private static boolean end(int x, int y) {
		if (x < 1 || y < 1 || x >= N + 1 || y >= N + 1) {
			return false;
		}

		if (arr[x][y] == -1) {
			return false;
		}

		return true;
	}
}
