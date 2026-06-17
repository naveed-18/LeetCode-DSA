class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] target = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                target[c - 'a']++;
            }
        }

        String result = null;
        int minLength = Integer.MAX_VALUE;
        for (String word : words) {
            if (isMatch(word, target) && word.length() < minLength) {
                minLength = word.length();
                result = word;
            }
        }
        return result;
    }
    public boolean isMatch(String word, int[] target) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}