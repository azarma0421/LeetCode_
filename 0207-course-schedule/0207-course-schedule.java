class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        Queue queue = new LinkedList();
        int course = 0;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() == 0) {
                course++;
                queue.add(i);
            }
        }

        while (queue.size() != 0) {
            int finish = (int) queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[i].contains(finish)) {
                    graph[i].remove(Integer.valueOf(finish));
                    if (graph[i].size() == 0) {
                        course++;
                        queue.add(i);
                    }
                }
            }
        }

        if (course == numCourses)
            return true;

        return false;
    }
}