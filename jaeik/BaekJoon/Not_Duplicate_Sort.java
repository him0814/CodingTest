package BaekJoon;
//10867

import java.util.*;
import java.io.*;

public class Not_Duplicate_Sort {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Set<Integer> hs = new HashSet<>();
		
		for(int i =0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> al = new ArrayList<>();
		
		Iterator<Integer> it = hs.iterator();
		
		while(it.hasNext()) {
			al.add(it.next());
		}
		
		Collections.sort(al);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : al) {
			sb.append(i).append(" ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
