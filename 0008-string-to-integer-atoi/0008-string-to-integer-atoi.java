class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        String str = s.trim();
        int n = str.length();
        if(n == 0) return 0;
        int sign = 1;
        long ans = 0;
        if(str.charAt(0) == '-') sign = -1;
        int i = (str.charAt(0) == '-' || str.charAt(0) == '+')? 1 : 0;
        int mini = Integer.MIN_VALUE, maxi = Integer.MAX_VALUE;
        while(i < n) {
            if(str.charAt(i) == ' ' || !Character.isDigit(str.charAt(i))) break;
            ans = ans * 10 + (str.charAt(i) - '0');
            if(sign == -1 && -1 * ans < mini) return mini;
            if(sign == 1 && ans > maxi) return maxi;
            i++;
        }
        return sign == -1? -1 * (int)ans : (int) ans;
    }
}