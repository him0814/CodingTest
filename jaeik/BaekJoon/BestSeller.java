package BaekJoon;
import java.io.*;
import java.util.*;
public class BestSeller {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			hm.put(s, hm.getOrDefault(s, 0) + 1);
		}
		int max = 0;
		String s = "";
		for(String str : hm.keySet()) {
			if(hm.get(str) > max) {
				s = str;
				max = hm.get(str);
			} else if(hm.get(str) == max) {
				if(str.compareTo(s) < 0) {
					s = str;
				}
			}
		}
		System.out.print(s);
	}
}
