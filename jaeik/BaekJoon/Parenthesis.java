package BaekJoon;

// ( ) 로만 구성 문자열 첫줄에 입력된 문자열 길이 2이상 50이하
// 올바른 문자열 vps면 YES, 아니면 NO 출력
import java.util.*;
import java.io.*;
public class Parenthesis {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			String str = st.nextToken();
			String[] sarr = str.split("");
			Stack<String> s = new Stack<>();
			int count = 0;
			for(int j = 0; j < sarr.length; j++) {
				if(sarr[j].equals("(")) {
					s.push(sarr[j]);
					count++;
				}
				else if(sarr[j].equals(")")) {
					if(s.empty()) {
						System.out.println("NO");
						break;
					}
					else {
						s.pop();
						count++;
					}
				}
			}
			if(count == sarr.length) {
				if(s.empty())
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}
