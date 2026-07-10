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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DisjointSet dsu = new DisjointSet(n);

        for (int i = 1; i < n; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            if (diff <= maxDiff) {
                dsu.unionBySize(i, i - 1);
            }
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (dsu.findParent(start) == dsu.findParent(end)) {
                result[i] = true;
            }
        }

        return result;
    }
}