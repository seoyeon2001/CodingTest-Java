import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int colSize = relation[0].length;
        List<Set<Integer>> candidates = new ArrayList<>();

        // 조합 길이 1~colSize까지 생성
        for (int size = 1; size <= colSize; size++) {
            List<Set<Integer>> combinations = new ArrayList<>();
            generateCombinations(0, size, new LinkedHashSet<>(), colSize, combinations);

            for (Set<Integer> comb : combinations) {
                if (isUnique(comb, relation) && isMinimal(comb, candidates)) {
                    candidates.add(comb);
                }
            }
        }

        return candidates.size();
    }

    // 조합 생성
    void generateCombinations(int start, int targetSize, Set<Integer> current, int totalCols, List<Set<Integer>> result) {
        if (current.size() == targetSize) {
            result.add(new HashSet<>(current));
            return;
        }

        for (int i = start; i < totalCols; i++) {
            current.add(i);
            generateCombinations(i + 1, targetSize, current, totalCols, result);
            current.remove(i);
        }
    }

    // 유일성 확인
    boolean isUnique(Set<Integer> cols, String[][] relation) {
        Set<String> seen = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int col : cols) {
                sb.append(row[col]).append("|");
            }
            seen.add(sb.toString());
        }
        return seen.size() == relation.length;
    }

    // 최소성 확인
    boolean isMinimal(Set<Integer> cand, List<Set<Integer>> candidates) {
        for (Set<Integer> key : candidates) {
            if (cand.containsAll(key)) return false;
        }
        return true;
    }
}
