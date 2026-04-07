class Solution {
    public int reverse(int x) {
        int num = x, rev = 0,preRev = 0;
        if(x < 0) {
            num = -num;
        }
        while(num > 0){
            int last = num % 10;
            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10){
                return 0;
            }
            rev = rev * 10 + last;
            num /= 10;
        }
        
        if(x < 0) {
            return -rev;
        } else {
            return rev;
        }
    }
}