class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> course = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            course.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            course.get(p[0]).add(p[1]);
        }

        for (List<Integer> cur : course) {
            if (!dfs(visited, cur, course))
                return false;
        }
        return true;
    }

    private boolean dfs(boolean[] visited, List<Integer> current, List<List<Integer>> allCourse) {
        for (Integer c : current) {
            if (visited[c])
                return false;

            visited[c] = true;
            if (!dfs(visited, allCourse.get(c), allCourse)) {
                return false;
            }
            visited[c] = false;
        }
        return true;
    }
}