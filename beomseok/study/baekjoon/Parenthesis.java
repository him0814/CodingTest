package baekjoon;
//���� ��ȣ 9012

//��ȣ�� �ùٸ� ���°� VPS
//VPS�� ��ȣ�� ���ڿ� x�� �־ VPS
//VPS x�� y�� ���ս��ѵ� VPS
// --> ��ȣ�� ¦�� ��� �¾ƾ� VPS

//ù��° ��: �׽�Ʈ ������ T
//�� ���� : T��ŭ ��, 2 <= ��ȣ ���ڿ� ���� <= 50 
// --> ���� ��ȣ push, �ݴ� ��ȣ pop


import java.io.*;
import java.util.*;

public class Parenthesis {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			String string = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for(int j=0; j<string.length(); j++){
				char p = string.charAt(j);
				if(p == '(') {
					stack.push(p);
				} else if(stack.empty()) {
					stack.push(p);
					break;
				}
				else
					stack.pop();
			}
			if(stack.empty())
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}
