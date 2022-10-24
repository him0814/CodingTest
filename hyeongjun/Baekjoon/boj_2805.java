package BOJ;

import java.io.*;
import java.util.*;

public class boj_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 나무 갯수
		int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이
		int[] tree = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		// 10 15 17 20
		Arrays.sort(tree);
		
		// 인덱스
		int left = 0;
		int right = tree[N-1];
		
		while(left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			
			for(int i = 0; i < N; i++) {
				long cut_tree = tree[i] - mid;
				// 자르는 높이보다 작은 나무를 자를때
				if(cut_tree <= 0) {
					continue;
				}
				sum += cut_tree;
			}
			
			if(sum >= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}		
		}
		
		System.out.println(right);
	}
}
