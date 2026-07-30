class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        int count = 0;
        int increment = 1;
        for (int i = 0; i < word.length(); i++) {
            result += increment;
            count++;
            if (count == 8){
                count = 0;
                increment++;
            }
        }
        return result;
    }
}