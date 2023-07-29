package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int N = 8;

    @SuppressWarnings("unchecked")
    // public static ArrayList<Edge>[] graph = new ArrayList[N];
    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static void display() {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.v + ", " + e.w + ") ");
            }
            System.out.println();
        }
    }

    public static int findEdge(int u, int v) {
        int idx = -1;
        for (int i = 0; i < graph[u].size(); i++) {
            if (graph[u].get(i).v == v) {
                idx = i;
                break;
            }
        }

        return idx;
    }

    public static void removeEdge(int u, int v) {
        int idx1 = findEdge(u, v);
        int idx2 = findEdge(v, u);

        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVtx(int u) {
        for (int i = graph[u].size() - 1; i >= 0; i--) {
            int v = graph[u].get(i).v;
            removeEdge(u, v);
        }
    }

    public static class heavyPair {
        int weight = 0;
        String path = "";

        heavyPair(int weight, String path) {
            this.weight = weight;
            this.path = path;
        }
    }

    // heavy Path -> print : path and weight

    public static heavyPair heavyPath(int src, int dest, boolean[] vis) {
        if (src == dest) {
            heavyPair base = new heavyPair(0, dest + "");
            return base;
        }

        vis[src] = true;

        heavyPair myAns = new heavyPair(-(int) 1e8, "");

        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                heavyPair recAns = heavyPath(e.v, dest, vis);
                if (recAns.weight != -1e8 && recAns.weight + e.w > myAns.weight) {
                    myAns.weight = recAns.weight + e.w;
                    myAns.path = src + " " + recAns.path;
                }
            }
        }

        vis[src] = false;
        return myAns;
    }

    public static void  BFS_Cycle(int src,  boolean[] vis)
{
    LinkedList<Integer> que=new LinkedList<>();
    que.add(src);

    int dest = 6;
    int atLevel = -1;

    boolean isCycle = false;
    int level = 0;

    while (que.size() != 0)
    {
        int size = que.size();
        System.out.print( level + " -> ");
        while (size-- > 0)
        {
            int rvtx = que.removeFirst();
            

            
            if (vis[rvtx])
            {
                isCycle = true;
                continue;
            }

            if (rvtx == dest)
            {
                atLevel = level;
            }
            System.out.print( rvtx + " ");
            vis[rvtx] = true;
            for (Edge e : graph[rvtx])
            {
                if (!vis[e.v])
                    que.addLast(e.v);

            }
        }
        level++;
        System.out.println();
    }

    System.out.println( dest +" present at : " + atLevel );
    System.out.println(  "isCycle : " + (isCycle?"true":"false"));
}


    

    public static void  constructGraph() {
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 40);
        addEdge(3, 4, 2);
        addEdge(4, 5, 2);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
    }
    public static void main(String[] args) {
        constructGraph();
        
        boolean[] arr=new boolean[7];
        BFS_Cycle(0,arr);
    }

}