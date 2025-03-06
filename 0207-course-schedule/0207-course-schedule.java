class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [bi, ai]
        ArrayList[] graph = new ArrayList[numCourses];
        // [ai, num of bi]
        int[] corse = new int[numCourses];
        Queue queue = new LinkedList<>();
        int finished = 0;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            corse[p[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (corse[i] == 0) {
                finished++;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = (int) queue.poll();

            for (int i = 0; i < graph[cur].size(); i++) {
                int point = (int) graph[cur].get(i);
                corse[point]--;
                if (corse[point] == 0) {
                    finished++;
                    queue.add(point);
                }
            }
        }

        return finished == numCourses;
    }

    private void dfs() {

    }
}