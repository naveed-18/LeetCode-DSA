class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLen = 1; 
        int n = s.length();
        int left = 0, right = 0;
        int[] freq = new int[26]; 
        
        while (right < n) {
            char curr = s.charAt(right);
            freq[curr - 'a']++;

            while (freq[curr - 'a'] > 2) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}