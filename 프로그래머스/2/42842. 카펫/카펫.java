// 14분
// class Solution {
//     public int[] solution(int brown, int yellow) {
//         int[] answer = new int[2];
        
//         int row = 1;
//         int col = 1;
        
//         for(int i = 1; i < (brown - 4) / 2; i++) {
//             row = i;
//             col = (brown - 4) / 2 - i;
//             // System.out.println(row + " " + col);
            
//             if(row * col == yellow) {
//                 answer[0] = Math.max(row + 2, col + 2);
//                 answer[1] = Math.min(row + 2, col + 2);
//                 break;
//             }
//         }
//         return answer;
//     }
// }

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int height = 1; height * height <= yellow; height++) {
            if (yellow % height != 0) continue;

            int width = yellow / height;

            // 테두리 갈색 개수 확인
            if ((width + height) * 2 + 4 == brown) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }

        return answer;
    }
}

/*
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 2a + 2b = brown + 4
        // a + b = brown/2 + 2
        
        for (int a = 1; a < brown/2 + 2; a++) {
            int b = brown/2 + 2 - a;
            
            if ((a-2) * (b-2) == yellow) {
                if (a > b) {
                    answer[0] = a;
                    answer[1] = b;
                } else {
                    answer[0] = b;
                    answer[1] = a;
                }
                
                break;
            }
        }
        return answer;
    }
}
*/