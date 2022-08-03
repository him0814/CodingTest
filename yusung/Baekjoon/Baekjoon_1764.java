package Baekjoon;

import java.util.*;
import java.io.*;

//백준 1764번 듣보잡
//첫째줄에 듣도 못한사람 N, 보도 못한 사람 M이 주어짐
//시간제한 2초 -> 이중포문까지가능
// N, M은 50만 이하의 자연수
// 듣도못한사람 먼저 set에 넣고 다음에 보도못한사람과 중복되는 사람이 set에 있으면 중복되는 사람을 ArrayList에 넣고 정렬

public class Baekjoon_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> hs = new HashSet<>();

		for (int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
		
		ArrayList<String> tmp = new ArrayList<>();
		for(int j=0; j< M; j++) {
			String str = br.readLine();
			if(hs.contains(str)) {
				tmp.add(str);
			}
		}
		Collections.sort(tmp);
		System.out.println(tmp.size());
		for(String str2 : tmp) {
			System.out.println(str2);
		}
	}
}
