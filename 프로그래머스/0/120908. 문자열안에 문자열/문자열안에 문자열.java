class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        for (int i = 0; i < str1.length() - str2.length()+1; i++) {
            String tmp = str1.substring(i, i+str2.length());
            System.out.println(tmp);
            if (tmp.equals(str2)) {
                return 1;
            }
        }
        // str1.startswith(str2)
        return 2;
    }
}