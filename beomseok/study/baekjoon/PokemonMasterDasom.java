package baekjoon;
//백준 1620 나는야 포켓몬 마스터 이다솜

import java.io.*;
import java.util.*;

public class PokemonMasterDasom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> hm = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			String num = Integer.toString(i+1);
			
			hm.put(str, num);
			hm.put(num, str);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append(hm.get(br.readLine())).append("\n"); 
        }
		
		System.out.println(sb);
	}
}
