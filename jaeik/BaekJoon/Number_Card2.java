package BaekJoon;

//첫째 줄 숫자카드의 개수 N
//둘째 줄 숫자 카드에 적혀있는 정수
//셋째 줄 몇개 가지고 있는지 확인할 정수의 개수 M
//넷째 줄 확인할 정수
import java.io.*;
import java.util.*;
public class Number_Card2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			
			int n = Integer.parseInt(st.nextToken());
			hm.put(n, hm.getOrDefault(n, 0) + 1);
		}
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			
			int n = Integer.parseInt(st.nextToken());
			if(hm.containsKey(n)) {
				sb.append(hm.get(n)).append(" ");
			}
			else {
				sb.append("0").append(" ");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
