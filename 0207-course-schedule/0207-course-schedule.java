class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            adj[pre[0]].add(pre[1]);
        }


        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adj,visited)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, ArrayList<Integer>[] adj,int[] visited){

        // already been here
        if(visited[node] == 1){
            return false;
        }

        // already finish
        if(visited[node] == 2){
            return true;
        }

        visited[node] = 1;
        for(int j : adj[node]){
            if(!dfs(j,adj,visited)){
                return false;
            }
        }

        visited[node] = 2;
        return true;

    }
}