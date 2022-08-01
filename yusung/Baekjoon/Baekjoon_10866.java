package Baekjoon;

import java.io.*;
import java.util.*;

//백준 10866번 최소, 최대

public class Baekjoon_10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());		

		while (N-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();			
			switch (str) {
			case ("push_front"): {
				int num = Integer.parseInt(st.nextToken());
				dq.offerFirst(num);
				break;
			}

			case ("push_back"): {
				int num = Integer.parseInt(st.nextToken());
				dq.offerLast(num);
				break;
			}

			case ("pop_front"): {
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");

				} else {
					sb.append(dq.pollFirst()).append("\n");
				}
				break;
			}

			case ("pop_back"): {
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");

				} else {
					sb.append(dq.pollLast()).append("\n");
				}
				break;
			}

			case ("size"): {
				sb.append(dq.size()).append("\n");
				break;
			}
			
			case ("empty"): {
				if (dq.isEmpty()) {
					sb.append(1).append("\n");

				} else {
					sb.append(0).append("\n");
				}
				break;
			}

			case ("front"): {
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.peekFirst()).append("\n");
				}
				break;
			}

			case ("back"): {
				if (dq.isEmpty()) {
					sb.append(-1).append("\n");
				}

				else {
					sb.append(dq.peekLast()).append("\n");
				}
				break;
			}
						
			}			
		}
		//sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
