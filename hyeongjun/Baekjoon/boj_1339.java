package BOJ;

/*
���� #1339 �ܾ� ����
 */

import java.io.*;
import java.util.*;

public class boj_1339 {
	
	static int n;
	static int answer = Integer.MIN_VALUE;
	static String[] word;
	// �Է¿��� ���� ����Ʈ
	static ArrayList<Character> al = new ArrayList<>();
	static int[] tmp;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		// �����Է� ���� �迭
		word = new String[n];
		visit = new boolean[10];
		
		for(int i = 0; i < n; i++) {
			word[i] = br.readLine();
			for(int j = 0; j < word[i].length(); j++) {
				if(!al.contains(word[i].charAt(j))) {
					al.add(word[i].charAt(j));
				}
			}
		}
		
		// 0~9���� �� ���� �迭
		tmp = new int[al.size()];
		
		dfs(0);
		
		System.out.println(answer);
		
	}
	
	public static void dfs(int depth) {
		if(depth == al.size()) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				int num = 0;
				for(int j = 0; j < word[i].length(); j++) {
					num *= 10;
					num += tmp[al.indexOf(word[i].charAt(j))];
				}
				sum += num;
			}
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				tmp[depth] = i;
				dfs(depth + 1);
				tmp[depth] = 0;
				visit[i] = false;
			}
		}
	}
}
