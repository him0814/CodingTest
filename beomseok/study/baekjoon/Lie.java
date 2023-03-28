package baekjoon;
//πÈ¡ÿ  1043 ∞≈¡˛∏ª

import java.io.*;
import java.util.*;

public class Lie {
	static int N, M;
	static int know;
	static ArrayList<Integer> party[];
	static ArrayList<Integer> people[];
	static ArrayList<Integer> knowNum;
	static boolean visit[];
	static int res;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		know = Integer.parseInt(st.nextToken());
		
		party = new ArrayList[M+1];
		for(int i=0; i<M+1; i++) {
			party[i] = new ArrayList<>();
		}
		
		people = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			people[i] = new ArrayList<>();
		}
		
		knowNum = new ArrayList<>();
		for(int i=0; i<know; i++) {
			knowNum.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++) {
                int idx = Integer.parseInt(st.nextToken());
                party[i].add(idx);
                people[idx].add(i);
            }
        }
		
		visit = new boolean[M+1];
		res = 0;
		bfs();
		System.out.println(res);     
	}
	
	public static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=0; i<knowNum.size(); i++) {
            for(int j=0; j<people[knowNum.get(i)].size(); j++) {
                if(!visit[people[knowNum.get(i)].get(j)]) {
                    visit[people[knowNum.get(i)].get(j)] = true;
                    q.add(people[knowNum.get(i)].get(j));
                }
            }
        }
        
        while(!q.isEmpty()) {
        	int p = q.poll();
            for(int i=0; i<party[p].size(); i++) {
                for(int j=0; j<people[party[p].get(i)].size(); j++) {
                    if(!visit[people[party[p].get(i)].get(j)]) {
                        visit[people[party[p].get(i)].get(j)] = true;
                        q.add(people[party[p].get(i)].get(j));
                    }
                }
            }
        }
        
        for(int i=0; i<M; i++) {
        	if(!visit[i]) {
            	res++;
            }
        }
    }
}
