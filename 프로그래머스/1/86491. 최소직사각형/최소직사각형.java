class Solution {
    public int solution(int[][] sizes) {        
        int fMax = 0;
        int sMax = 0;
        
        for(int[] size : sizes) {
            int w = size[0];
            int h = size[1];
            
            fMax = Math.max(fMax, Math.min(w, h));
            sMax = Math.max(sMax, Math.max(w, h));
        }
        return fMax * sMax;
    }
}