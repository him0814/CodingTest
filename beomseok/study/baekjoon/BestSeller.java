package baekjoon;
//베스트셀러 백준 1302

import java.io.*;
import java.util.*;

public class BestSeller {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		String max_str = "";

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			hm.put(str, hm.getOrDefault(str, 0) + 1);
		}

		for (String k : hm.keySet()) {
			if (hm.get(k) > max) {
				max = hm.get(k);
				max_str = k;
			} else if (hm.get(k) == max) {
				if (max_str.compareTo(k) > 0) {
					max_str = k;
				}
			}
		}
		System.out.println(max_str);
	}
}
