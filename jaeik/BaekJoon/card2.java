package BaekJoon;

// N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있다
// 
import java.util.*;
import java.io.*;
public class card2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		for(int i = 1; i < N; i++) {
			deque.poll();
			int tmp = deque.poll();
			deque.offer(tmp);
		}
		System.out.print(deque.peek());
	}
}
