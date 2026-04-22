class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String word : queries) {
            for (String dictWord : dictionary) {
                if (matches(word, dictWord)) {
                    result.add(word);
                    break;
                }
            }
        }

        return result;
    }

    public boolean matches (String word, String dictWord) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != dictWord.charAt(i)) count++;
            if (count > 2) return false;
        }
        return true;
    }
}