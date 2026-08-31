import java.util.*;

public class CycleDetectionDFS {
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

        // graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        // graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 5));
        // graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));

        // graph[6].add(new Edge(6, 5));
    }

    // public static void BFS(ArrayList<Edge> graph[] , int V, boolean[] vis, int start){
    //     Queue <Integer> q = new LinkedList<>();

    //     q.add(start);

    //     while(!q.isEmpty()){
    //         int curr = q.remove();
    //         if(vis[curr] == false){
    //             System.out.print(curr + " ");
    //             vis[curr] = true;

    //             for(int i = 0; i < graph[curr].size(); i++){
    //                 Edge e = graph[curr].get(i);
    //                 q.add(e.dist);
    //             }
    //         }
    //     }
    // }

    // public static void DFS(ArrayList<Edge> graph [], int curr, boolean vis[]){
    //     System.out.print(curr + " ");
    //     vis[curr] = true;

    //     for(int i = 0; i < graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         if(vis[e.dist] == false){
    //         DFS(graph, e.dist, vis);}
    //     }
    // }

    public static boolean CycleDetection(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){

        vis[curr] = true;
        rec[curr] =  true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dist]){
                return true;
            }
            else if(!vis[e.dist]){
                if(CycleDetection(graph, vis, e.dist, rec)){
                    return true;
                }
            }

        }
        rec[curr] = false;
        return false;
    }
    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        for(int i = 0; i < graph.length; i++){
            if(vis[i] == false){
                boolean iscycle = CycleDetection(graph, vis, 0, rec);
                if(iscycle){
                    System.out.println(iscycle);
                    break;
                }
                else{
                    System.out.println(iscycle);
                }
            }
        }
        // DFS(graph, 0, vis);
        // System.out.println();

    }
}
