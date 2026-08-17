class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                provinces++;
                dfs (i, isConnected, isVisited, n);
            }
        }
        return provinces;
    }

    public void dfs (int node, int[][] isConnected, boolean[] isVisited, int n) {
        isVisited[node] = true;
        for (int j = 0; j < n; j++) {
            if (!isVisited[j] && isConnected[node][j] == 1) {
                dfs(j, isConnected, isVisited, n);
            }
        }
    }
}