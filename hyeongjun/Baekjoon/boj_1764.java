package study1;

import java.io.*;
import java.util.*;

public class boj_1764 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> hs = new HashSet<>();
		ArrayList<String> al = new ArrayList<>(); 
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			hs.add(str);
		}
		
		int count = 0;
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(hs.contains(str)) {
				count++;
				al.add(str);
			}
		}
		
		sb.append(count+"\n");
		
		Collections.sort(al); // 리스트 정렬 / Arrays.sort(배열이름);
				
		for(String str: al) {
			sb.append(str+"\n");
		}
		System.out.println(sb.toString());
	}
}
