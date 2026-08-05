class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] isVisited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adj =  new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] invocation : invocations) {
            int a = invocation[0];
            int b = invocation[1];

            adj.get(a).add(b);
        }

        dfs(k, adj, isVisited);

        for (int[] invocation : invocations) {
            int a = invocation[0];
            int b = invocation[1];

            if (!isVisited[a] && isVisited[b]) {
                for (int i = 0; i < n; i++) result.add(i);

                return result;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) result.add(i);
        }

        return result;
    }

    public void dfs (int node, List<List<Integer>> adj, boolean[] isVisited) {
        isVisited[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!isVisited[neighbour]) {
                dfs(neighbour, adj, isVisited);
            }
        }
    }
}