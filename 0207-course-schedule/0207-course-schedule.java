class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] corse = new int[numCourses];
        Queue queue = new LinkedList<>();
        int finish = 0;

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            corse[prerequisites[i][0]]++;
        }

        for (int i = 0; i < corse.length; i++) {
            if (corse[i] == 0) {
                finish++;
                queue.add(i);
            }
        }

        while (queue.size() != 0) {
            int current = (int) queue.poll();
            for (int i = 0; i < graph[current].size(); i++) {
                int point = (int) graph[current].get(i);
                corse[point]--;
                if (corse[point] == 0) {
                    finish++;
                    queue.add(point);
                }
            }
        }

        return finish == numCourses;
    }
}