package BOJ;

/*
���� #2667 ������ȣ���̱�


 */

import java.io.*;
import java.util.*;

public class boj_2667 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static int[][] apt; // �Է� : ����Ʈ (0,1) �� ���� �迭
	static boolean[][] visit;
	static int count; // ����Ʈ ����
	static ArrayList<Integer> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		apt = new int[N][N];
		visit = new boolean[N][N];
		
		// �Է�
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				apt[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// �湮�� �� ���� 1�̸�
				if(!visit[i][j] && apt[i][j] == 1) {
					count = 1; // �̹� 1�� ���� ��
					dfs(i, j);
					al.add(count);
				}
			}
		}
		
		Collections.sort(al);
		sb.append(al.size() + "\n");
		
		for(int n: al) {
			sb.append(n + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) { // �����¿� 4�����̱� ����
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(!visit[nx][ny] && apt[nx][ny] == 1) {
					dfs(nx, ny);
					count++;
				}
			}
		}
		
	}
}
