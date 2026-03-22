class Solution {
    public String countAndSay(int n) {
        return rle(n);
    }

    public String rle (int n) {
        if (n == 1) return "1";

        String temp = rle (n - 1);

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, count = 0;
        while (i < temp.length() && j < temp.length()) {
            if (temp.charAt(i) == temp.charAt(j)) {
                j++;
                count++;
            } else {
                sb = sb.append(Integer.toString(count)).append(temp.charAt(i));
                count = 0;
                i = j;
            }
        }
        sb = sb.append(Integer.toString(count)).append(temp.charAt(j - 1));

        return sb.toString();
    }
}