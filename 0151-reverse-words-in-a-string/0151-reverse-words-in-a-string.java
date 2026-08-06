class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        int i = 0, j = words.length - 1;

        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }

        StringBuilder result = new StringBuilder();
        boolean space = false;
        for (String word : words) {
            if (!word.isEmpty()) {
                if (space) result.append(" ");
                result.append(word);
                space = true;
            }
        }

        return result.toString();
    }
    public String reverseWordsApproach1(String s) {
        String[] words = s.trim().split("\\s+");
        Stack<String> st = new Stack<>();

        for (String word : words) {
            st.push(word);
        }
        
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop() + " ");
        }

        return result.toString().trim();
    }
}