import java.util.*;

class Solution {
    static boolean[] visit;
    static int arr[];
    static int answer;
    static Map<Character, Integer> hm;
    
    public int solution(int n, String[] data) {
        answer = 0;
        hm = new HashMap<>();
        visit = new boolean[8];
        arr = new int[8];
        
        hm.put('A', 0);
        hm.put('C', 1);
        hm.put('F', 2);
        hm.put('J', 3);
        hm.put('M', 4);
        hm.put('N', 5);
        hm.put('R', 6);
        hm.put('T', 7);
        
        dfs(0, data);
        
        return answer;
    }
    public void dfs(int depth, String[] data){
        if(depth == 8){
            if(check(data)){
                answer++;
            }
            return;
        }
        for(int i=0; i<8; i++){
            if(!visit[i]){
            visit[i] = true;
            arr[depth] = i;
            dfs(depth+1, data);
            visit[i] = false;
            }
        }
    }
    public boolean check(String[] data){
        for(int i=0; i<data.length; i++){
            int first = hm.get(data[i].charAt(0));
            int third = hm.get(data[i].charAt(2));
            char op = data[i].charAt(3);
            int last = data[i].charAt(4) - '0';
            
            int distance = Math.abs(arr[first] - arr[third]) - 1;
            
            if(op == '=' && distance != last){
                return false;
            } else if(op == '>' && distance <= last){
                return false;
            } else if(op == '<' && distance >= last){
                return false;
            }
        }
        return true;
    }
}