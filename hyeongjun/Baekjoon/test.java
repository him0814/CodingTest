package BOJ;

import java.io.*;
import java.util.*;

// z 가 a보다 먼저
// 긴게 먼저

public class test {
	public static void main(String[] args) throws IOException {
		String[] str = { "abcd", "ab", "abcde", "c", "cfd", "cdf" };

		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s2.compareTo(s1) >= 1) {
					if(s1.length() > s2.length()) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return 0;
				}
			}
		});

		for (String s : str) {
			System.out.println(s);
		}
	}
}
