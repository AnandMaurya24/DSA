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
    
    
}
