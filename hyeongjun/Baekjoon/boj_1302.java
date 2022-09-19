package BOJ;

/*

*/

import java.util.*;
import java.io.*;

public class boj_1302 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			String key= br.readLine();
			hm.put(key, hm.getOrDefault(key, 0)+1);
		}
		
		int max = 0;
		String name = "";
		
		for(String str: hm.keySet()) {
			// 가장 큰 value 값을 찾기 위함
			if (hm.get(str) > max) {
				max = hm.get(str);
				name = str;
			} else if (max == hm.get(str)) {
				if (name.compareTo(str) > 0) {
					name = str;
				}
			}
		}
		System.out.println(name);
	}
}
