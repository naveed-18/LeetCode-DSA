class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] isVisited = new boolean[n];
        int completeConnectedComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                int[] res = new int[2];
                dfs(i, adj, isVisited, res);
                int edgesCount = res[0] / 2;
                int nodesCount = res[1];
                if (edgesCount == (nodesCount * (nodesCount - 1) / 2)) {
                    completeConnectedComponents++;
                }
            }
        }

        return completeConnectedComponents;
    }

    public void dfs(int start, List<List<Integer>> adj, boolean[] isVisited, int[] res) {
        isVisited[start] = true;
        res[1]++;

        for (int neighbours : adj.get(start)) {
            res[0]++;
            if (!isVisited[neighbours]) {
                dfs(neighbours, adj, isVisited, res);
            }
        }
    }
}