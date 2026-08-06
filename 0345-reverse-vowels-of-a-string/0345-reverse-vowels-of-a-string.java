class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) vowels.append(c);
        }

        StringBuilder result = new StringBuilder();
        int idx = vowels.length() - 1;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.charAt(idx));
                idx--;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}