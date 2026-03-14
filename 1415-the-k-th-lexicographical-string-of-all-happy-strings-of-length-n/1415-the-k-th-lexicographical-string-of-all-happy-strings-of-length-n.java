class Solution {
    private char[] set = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        genHappyStrings(n, new StringBuilder(), happyStrings);
        return happyStrings.size() < k ? "" : happyStrings.get(k - 1);
    }
    
    public void genHappyStrings(int n, StringBuilder currString, List<String> happyStrings) {
        int len = currString.length();
        if (len == n) {
            happyStrings.add(currString.toString());
            return;
        }

        for (char ch : set) {
            if (len > 0 &&
                currString.charAt(len - 1) == ch) continue;
            currString.append(ch);
            genHappyStrings(n, currString, happyStrings);
            currString.deleteCharAt(len);
        }
    }
}