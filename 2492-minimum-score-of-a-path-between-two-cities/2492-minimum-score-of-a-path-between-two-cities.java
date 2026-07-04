class DisjointSet {
    List<Integer> parent;
    List<Integer> size;
    public DisjointSet (int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent (int node) {
        if (node == parent.get(node)) return node;
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV) return;

        if (size.get(parentU) < size.get(parentV)) {
            parent.set(parentU, parentV);
            size.set(parentV, size.get(parentU) + size.get(parentV));
        } else {
            parent.set(parentV, parentU);
            size.set(parentU, size.get(parentU) + size.get(parentV));
        }
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        return minScoreBFS(n, roads);
    }

    public int minScoreBFS(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1]=true;

        int result = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(int[] edge :adj.get(curr)) {
                int v = edge[0];
                int wt = edge[1];

                result = Math.min(result, wt);
                if(!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        return result;
    }

    public int minScoreDFS(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        boolean[] isVisisted = new boolean[n + 1];
        return dfs(1, adj, isVisisted);
    }

    public int dfs(int node, ArrayList<ArrayList<int[]>> adj, boolean[] isVisited) {
        isVisited[node] = true;
        int result = Integer.MAX_VALUE;
        for (int[] edge : adj.get(node)) {
            int v = edge[0];
            int wt = edge[1];
            result = Math.min(result, wt);
            if(!isVisited[v]) {
                result = Math.min(result, dfs(v, adj, isVisited));
            }
        }
        return result;
    }

    public int minScoreDSU(int n, int[][] roads) {
        DisjointSet ds = new DisjointSet(n + 1);
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            ds.unionBySize(u, v);
        }

        int minScore = Integer.MAX_VALUE;
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            if (ds.findParent(u) == ds.findParent(1)) {
                minScore = Math.min(minScore, dist);
            }
        }

        return minScore;
    }

}