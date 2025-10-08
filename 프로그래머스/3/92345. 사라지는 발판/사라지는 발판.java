class Result {
    private boolean isWin; // 승리 여부
    private int moveCnt; // 움직임 횟수

    public Result(boolean isWin, int moveCnt) {
        this.isWin = isWin;
        this.moveCnt = moveCnt;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public boolean getIsWin() {
        return isWin;
    }
}

class Solution {

    private int row, col;

    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        row = board.length;
        col = board[0].length;

        return move(board, aloc[0], aloc[1], bloc[0], bloc[1]).getMoveCnt(); // A부터 시작
    }

    private Result move(int[][] board, int ar, int ac, int br, int bc) {
        
        // 현재 플레이어가 이동할 수 없는 경우 -> 현재 플레이어가 지는 걸 의미
        if (isEnded(board, ar, ac)) {
            return new Result(false, 0);
        }

        // 같은 위치에 두 플레이어가 모인 경우, 현재 플레이어가 이기는 것을 의미
        if (ar == br && ac == bc) {
            return new Result(true, 1);
        }

        boolean canWin = false; // 승리하는 경우가 하나라도 존재하는지 체크하기 위함
        int maxValue = -1; // 승리하는 경우가 존재하지 않으면 최대한 오래 버티기
        int minValue = Integer.MAX_VALUE; // 승리하는 경우가 존재하면 최대한 빨리 끝내기
        
        board[ar][ac] = 0; // 현재 위치의 발판 없애기

        for (int i = 0; i < 4; i++) {
            int nr = ar + dr[i];
            int nc = ac + dc[i];

            // 다음 발판으로 갈 수 있는지 체크
            if (!inRange(nr, nc) || board[nr][nc] == 0) continue;

            Result nextResult = move(board, br, bc, nr, nc);

            if (nextResult.getIsWin()) { // 상대 플레이어가 이기면 현재 플레이어는 짐.
                // 다음 갈 수 있는 모든 경로 중 승리하는 경우가 하나도 존재하지 않는 경우
                // 최대한 오래 버티기 위해서 이동 횟수를 최대로 선택.
                maxValue = Math.max(maxValue, nextResult.getMoveCnt());
            } else { // 상대 플레이어가 지면 현재 플레이어는 이김.
                // 다음 갈 수 있는 모든 경로 중 승리하는 경우가 하나라도 존재하는 경우
                // 최대한 빨리 끝내기 위해서 이동 횟수를 최소로 선택.
                canWin = true;
                minValue = Math.min(minValue, nextResult.getMoveCnt());
            }
        }

        board[ar][ac] = 1; // 재귀를 빠져나가기 위해서 없앴던 발판 돌려기
        
        // canWin이 true면 이길 수 있기에 minValue 값 이용.
        // canWin이 false면 이길 수 없기에 maxValue 값 이용.
        return new Result(canWin, (canWin ? minValue : maxValue) + 1);
    }

    private boolean isEnded(int[][] board, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (inRange(nr, nc) && board[nr][nc] == 1) return false;
        }
        return true;
    }

    // 범위 내에 있는가?
    private boolean inRange(int r, int c) {
        return 0 <= r && r < row && 0 <= c && c < col;
    }
}