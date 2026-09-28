class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int res[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                res[i][j] = smoothen(img, i, j, n, m);
            }
        }
        return res;
    }
    
    int smoothen(int[][] img, int x, int y, int n, int m) {
        int sum = 0;
        int count = 0;

        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                sum += img[newX][newY];
                count++;
            }
        }
        return sum/count;
        
    }
}