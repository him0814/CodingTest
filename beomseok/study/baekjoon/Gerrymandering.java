package baekjoon;

import java.io.*;
import java.util.*;

public class Gerrymandering {
	static int N;
	static int[] population;
	static int[][] arr;
	static int res = Integer.MAX_VALUE;
	static List<Integer> alA;
	static List<Integer> alB;
	static boolean[] visit;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		population = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		arr = new int[N+1][N+1];
	    flag = new boolean[N+1];
	    
	    for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            for(int j=0; j<area; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][num] = 1;
                arr[num][i] = 1;
            }
        }
	    
	    bfs(1);
	    
	    if(res == Integer.MAX_VALUE) {
	    	System.out.println(-1);
	    } else {
	    	System.out.println(res);
	    }
	}
	
	public static void bfs(int cnt) {
		if(cnt == N+1) {
			alA = new ArrayList<>();
		    alB = new ArrayList<>();
		    visit = new boolean[N+1];
			
			for(int i=1; i<=N; i++) {
				if(flag[i]) {
					alA.add(i);
				} else {
					alB.add(i);	
				}	
			}
			
			if(alA.size() == 0 || alB.size() == 0) {
				return;	
			}
			
			sectionA(alA.get(0));
			sectionB(alB.get(0));
			
			res = Math.min(res, check());
			return;	
		}
		
		flag[cnt] = true;
        bfs(cnt + 1);
        flag[cnt] = false;
        bfs(cnt + 1);   
	}
	 
	public static int check() {
		for(int i=1; i<N+1; i++) {
			if(!visit[i]) {
				return Integer.MAX_VALUE;	
			}	
		}
		
		int sumA = 0;
		int sumB = 0;
		
		for(int i=0; i<alA.size(); i++) {
			sumA += population[alA.get(i)];	
		}
		for(int i=0; i<alB.size(); i++) {
			sumB += population[alB.get(i)];	
		}
		return Math.abs(sumA - sumB);
	}
	
	public static void sectionA(int a) {
		Queue<Integer> q = new LinkedList<>();
	    q.offer(a);
	    visit[a] = true;
	        
	    while(!q.isEmpty()) {
	    	int poll = q.poll();
	        for(int i=0; i<alA.size(); i++) {
	        	if(arr[poll][alA.get(i)] == 1 && !visit[alA.get(i)]) {
	        		q.offer(alA.get(i));
	        		visit[alA.get(i)] = true;	
	        	} 
	        }   
	    }   
	}
	
	public static void sectionB(int b) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(b);
		visit[b] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			for(int i=0; i<alB.size(); i++) {
				if(arr[poll][alB.get(i)] == 1 && !visit[alB.get(i)]) {
					q.offer(alB.get(i));
	                visit[alB.get(i)] = true; 
				} 
			}
		}
	}
}

