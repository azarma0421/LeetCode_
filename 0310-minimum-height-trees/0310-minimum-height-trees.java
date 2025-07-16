class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1)
                leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                for (int j : adj.get(i)) {
                    if (--degree[j] == 1)
                        newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}