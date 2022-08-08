package BaekJoon;

import java.io.*;
import java.util.*;
public class No_Listen_Look {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Set<String> hs = new HashSet<>();
		List<String> al = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			if(hs.contains(s)) {
				al.add(s);
			}
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(String s : al) {
			System.out.println(s);
		}
	}
}
