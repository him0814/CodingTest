import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> sk = new Stack<>(); 
        for(int i=0; i<s.length(); i++){
            char g = s.charAt(i);
            if(!sk.isEmpty() && g == ')'){
                sk.pop();
            }
            else {
                sk.push(g);
            }
        }
         if(sk.isEmpty()){
                answer = true;
            } else {
                answer = false;
            }
        return answer;
    }
}