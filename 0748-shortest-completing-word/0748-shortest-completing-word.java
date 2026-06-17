class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = "";
        int resLen = Integer.MAX_VALUE;
        for (String word : words) {
            if (isCompletingWord (word, licensePlate) && word.length() < resLen) {
                result = word;
                resLen = word.length();
            }
        }
        return result;
    }

    public boolean isCompletingWord(String word, String lp) {
        int[] freq = new int[26];
        for (char c : lp.toCharArray()) {
            if (c == ' ' || Character.isDigit(c)) continue;
            freq[Character.toLowerCase(c) - 'a']++;
        }
        for (char c : word.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) return false;
        }
        return true;
    }
}