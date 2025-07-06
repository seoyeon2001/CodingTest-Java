class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;

        int maxRow = 0;
        int maxCol = 0;
        
        for (int i = 0; i < n; i++) {
            int[] size = sizes[i];
            
            int row = Math.max(size[0], size[1]);
            int col = Math.min(size[0], size[1]);
            
            if (row > maxRow) {
                maxRow = row;
            }
            
            if (col > maxCol) {
                maxCol = col;
            }
        }
        
        
        return maxRow * maxCol;
    }
}