class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int minDis = Integer.MAX_VALUE;
        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (target.equals(words[i])) {
                int frwdDis = Math.abs(i - startIndex);
                int backwrdDis = n - frwdDis;

                minDis = Math.min(minDis, Math.min(frwdDis, backwrdDis));
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
}