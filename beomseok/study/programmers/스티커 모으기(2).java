class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if(sticker.length == 1){
            return sticker[0];
        }
        
        int[] odd = new int[sticker.length];
        int[] even = new int[sticker.length];
        
        odd[0] = sticker[0];
        odd[1] = sticker[0];
        
        for(int i=2; i<(sticker.length-1); i++){
            odd[i] = Math.max(odd[i-1], odd[i-2] + sticker[i]);
        }
        
        even[0] = 0;
        even[1] = sticker[1];
        
        for(int i=2; i<sticker.length; i++){
            even[i] = Math.max(even[i-1], even[i-2] + sticker[i]);
        }
        
        answer = Math.max(odd[sticker.length-2], even[sticker.length-1]);
        return answer;
    }
}