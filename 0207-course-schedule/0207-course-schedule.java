class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count = 0;

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                count++;
                queue.add(i);
            }
        }

        while (queue.size() != 0) {
            int currentCourse = (int) queue.poll();
            for (int i = 0; i < graph[currentCourse].size(); i++) {
                int dependentCourse = (int) graph[currentCourse].get(i);
                degree[dependentCourse]--;
                if (degree[dependentCourse] == 0) {
                    count++;
                    queue.add(dependentCourse);
                }
            }
        }
        return count == numCourses;
    }
}