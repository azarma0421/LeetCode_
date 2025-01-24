class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, visited, graph))
                ans.add(i);
        }
        return ans;
    }

    private boolean dfs(int index, int[] visited, int[][] graph) {
        if (visited[index] == 2)
            return true;
        if (visited[index] == 1)
            return false;
        visited[index] = 1;

        for (int i = 0; i < graph[index].length; i++) {
            if (!dfs(graph[index][i], visited, graph))
                return false;
        }

        visited[index] = 2;
        return true;
    }
}