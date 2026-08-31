// import java.nio.file.Path;
import java.util.*;

public class AllPathfromSrcToTraget {
    static class Edge{  
        int src;
        int dist;

        public Edge(int s, int d){
            this.src = s;
            this.dist = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        // graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // O(V+E)
    public static void BFS(ArrayList<Edge> graph[] , int V, boolean[] vis, int start){
        Queue <Integer> q = new LinkedList<>();

        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dist);
                }
            }
        }
    }
     // O(V+E)
    public static void DFS(ArrayList<Edge> graph [], int curr, boolean vis[]){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dist] == false){
            DFS(graph, e.dist, vis);}
        }
    }

    // O(V^V)
    public static void AllPthfrmSrctoTarget(ArrayList<Edge> graph[], boolean vis[], int curr, String Path, int target){

        if(curr == target){
            System.out.print(Path + " ");
            System.out.println();
            return;
        }

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[curr] == false){
                vis[curr] = true;
                AllPthfrmSrctoTarget(graph, vis, e.dist, Path+e.dist, target);
                vis[curr] = false;
            }
        }
    }
    public static void main(String[] args) {

        int V = 7;
        int target = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        boolean vis[] = new boolean[V];
        // for(int i = 0; i < graph.length; i++){
        //     if(vis[i] == false){
        //         DFS(graph, i, vis);
        //     }
        // }
        String Path = "";
        AllPthfrmSrctoTarget(graph, vis, 0, "0", target);


        
        System.out.println();
    }
}
