package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2606번 바이러스
//첫째줄에 컴퓨터수, 둘째 줄에 네트워크상에서 직접연결되어있는 컴퓨터쌍의 수, 이어서 그 수 만큼 한줄마다 연결되어있는 번호의 쌍이 주어짐
//[1][2] == [2][1] == 1이면 1번과 2번이 서로 상호연결이 되어있는 상태이다.
//따라서 dfs를 돌면서 붙어있는 컴퓨터를 보는데 이때 방문하지않았고, 감염됬을때만 카운트를 세면서 dfs를 돈다.

public class Baekjoon_2606 {

	static int computer_number;
	static int line_number;
	static int arr[][];
	static boolean visit[];
	static int answer;
	static int at;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		computer_number = Integer.parseInt(br.readLine());
		line_number = Integer.parseInt(br.readLine());

		//배열을 +1 해주는 것은 입력값이 1부터 들어와야 되기 때문에 입력받은 값보다 1크게 사이즈를 설정해준다.
		//배열의 인덱스는 0번부터이기 때문에
		
		arr = new int[computer_number+1][computer_number+1];
		visit = new boolean[computer_number+1];

		for (int i = 0; i <line_number; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = arr[y][x] = 1;
		}

		dfs(1);

		//초기 dfs입력을 1로 넣었기때문에 출력에서 -1을 해준다.
		System.out.println(answer-1);
	}

	private static void dfs(int at) {
		visit[at] = true;
		answer++;
		for (int i = 0; i <= computer_number; i++) {
			if (!visit[i] && arr[at][i] == 1) {
				dfs(i);
			}
		}
	}
}
