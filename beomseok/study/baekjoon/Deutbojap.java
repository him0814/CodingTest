package baekjoon;
//듣보잡 백준 1764

//N: 듣도 못한 사람의 수
//M: 보도 못한 사람의 수
//N개의 줄에 걸쳐 듣도 못한 사람의 이름, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어짐

import java.io.*;
import java.util.*;

public class Deutbojap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String> al = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}	
		for(int j=0; j<M; j++) {
			String str = br.readLine();
			if(set.contains(str)){
				al.add(str);
			}
		}
		
		Collections.sort(al);
		System.out.println(al.size());
		for(String name: al) {
			System.out.println(name);
		}
	}
}
