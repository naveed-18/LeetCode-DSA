class Solution {
    String[] keyPad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        letterComb (0, digits, sb, result);
        return result;
    }

    public void letterComb (int idx, String digits, 
        StringBuilder sb, List<String> result) {

        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        char currNum = digits.charAt(idx);
        String mappedKey = keyPad[(currNum - '0') - 2];

        for (char ch : mappedKey.toCharArray()) {
            letterComb (idx + 1, digits, sb.append(ch), result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}