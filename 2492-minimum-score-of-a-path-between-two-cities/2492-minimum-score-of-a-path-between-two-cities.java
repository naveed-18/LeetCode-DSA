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