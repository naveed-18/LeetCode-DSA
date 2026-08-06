class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char c1 = word[i];
            char c2 = word[j];
            
            if (isVowel(c1) && isVowel(c2)) {
                char temp = word[i];
                word[i] = word[j];
                word[j] = temp;
                i++;
                j--;
            } else if (isVowel(c1)) {
                j--;
            } else {
                i++;
            }
        }

        return new String(word);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}