package Graph;

import java.util.*;

public class Questions {

    //Course Schedule Leetcode 207
    public List<Integer> canFinishCourse(int N,List<List<Integer>> graph){
        int[] indegree=new int[N];
        for(int i=0;i<N;i++){
            for(int e:graph.get(i))
            indegree[e]++;
        }
        List<Integer> ans=new ArrayList<>();
        LinkedList<Integer> que=new LinkedList<>();
        for(int i=0;i<N;i++) {
            if(indegree[i]==0) que.addLast(i);
        }

        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                int rvtx=que.removeFirst();
                ans.add(rvtx);
                for (int e : graph.get(rvtx)){
                    if (--indegree[e] == 0)
                        que.push(e);
                }

            }
        }
        return ans;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(i,new ArrayList<>());
        for(int[] ar:prerequisites){
            graph.get(ar[0]).add(ar[1]);
        }
        return canFinishCourse(numCourses,graph).size()==numCourses;
    }

    //leetcode 210 course schedule

    public List<Integer>  findOrder(int N, List<List<Integer>> graph) {

        int[] indegree=new int[N];

        for(int i=0;i<N;i++){
            for(int e:graph.get(i))
                indegree[e]++;
        }
        System.out.println(Arrays.toString(indegree));

        List<Integer> ans=new ArrayList<>();
        LinkedList<Integer> que=new LinkedList<>();
        for(int i=0;i<N;i++) {
            if(indegree[i]==0) que.addLast(i);
        }
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                int rvtx=que.removeFirst();
                ans.add(rvtx);
                for(int e: graph.get(rvtx)){
                    if(--indegree[e]==0) que.addLast(e);
                }
            }
        }
        return ans;

    }
  
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(i,new ArrayList<>());
        
        for(int[] ar:prerequisites){

            graph.get(ar[0]).add(ar[1]);
    
        }
        List<Integer> ans=findOrder(numCourses,graph);
        Collections.reverse(ans);
        int[] finalAns=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            finalAns[i]=ans.get(i);
        }
        if(finalAns.length!=numCourses) return new int[0];
        return finalAns;
        
    }
 // 207 using dfs topological order
    public boolean canFinish_dfsTopo(int src,List<List<Integer>> graph,int[] vis){

        vis[src]=0;
        boolean res=false;
        for(int e:graph.get(src)){
            if(vis[e]==0) return true;
            else if(vis[e]==-1) res=res||canFinish_dfsTopo(e,graph,vis);
        }
        vis[src]=1;
        return res;          
    }
    public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        int[] vis=new int[numCourses];
        Arrays.fill(vis,-1);
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(i,new ArrayList<>());
        for(int[] ar:prerequisites){
            graph.get(ar[0]).add(ar[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(vis[i]==-1){
                if(canFinish_dfsTopo(i,graph,vis)) return false;
            }
        }
        return true;
    }
    //210 using dfs topological order 
    public boolean canFinish_dfsTopo(int src,List<List<Integer>> graph,int[] vis,List<Integer> ans){
        vis[src]=0;
        boolean res=false;
        for(int e:graph.get(src)){
            if(vis[e]==0) return true;
            else if(vis[e]==-1) res=res||canFinish_dfsTopo(e,graph,vis,ans);
        }
        vis[src]=1;
        ans.add(src);
        return res;          
    }
    public int[] findOrder_dfs(int numCourses, int[][] prerequisites) {

        int[] vis=new int[numCourses];
        Arrays.fill(vis,-1);
        List<List<Integer>> graph=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(i,new ArrayList<>());
        for(int[] ar:prerequisites){
            graph.get(ar[0]).add(ar[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(vis[i]==-1){
                if(canFinish_dfsTopo(i,graph,vis,ans)) return new int[0];
            }
        }
        int[] finalAns=new int[numCourses];
        for(int i=0;i<ans.size();i++){
            finalAns[i]=ans.get(i);
        }
        return finalAns;
    }

    //329. Longest Increasing Path in a Matrix

    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] indegree=new int[n][m];
        int[][] dir={{1,0},{0,1},{0,-1},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int d=0;d<dir.length;d++){
                    int x=i+dir[d][0];
                    int y=j+dir[d][1];
                    if(x>=0 && y>=0 && x<n && y<m && matrix[x][y]>matrix[i][j]){
                        indegree[x][y]++;
                    }}}}
        LinkedList<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(indegree[i][j]==0) que.addLast(i*m+j);
            }}
            int level=0;
            while(que.size()!=0){
                int size=que.size();
                while(size-->0){
                    int idx=que.removeFirst();

                    int r=idx/m;
                    int c=idx%m;
                    for(int d=0;d<dir.length;d++){
                        int x=r+dir[d][0];
                        int y=c+dir[d][1];
                        if(x>=0 && y>=0 && x<n && y<m && matrix[x][y] > matrix[r][c] && --indegree[x][y] ==0){
                            que.addLast(x*m+y);
                    } }}
                level++;
            }
        return level;  
    }

    
}
