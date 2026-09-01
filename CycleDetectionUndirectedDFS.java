import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionUndirectedDFS {
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
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 4));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        // graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));
        // graph[3].add(new Edge(3, 5));
        // graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));

        // graph[6].add(new Edge(6, 5));
    }

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

    public static boolean DFS(ArrayList<Edge> graph [], int curr, boolean vis[] ,int par){
        // System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){

            Edge e = graph[curr].get(i);

                if(vis[e.dist] == true && par != e.dist){
                    return true;
                }
                if(!vis[e.dist]){
                    if(DFS(graph, e.dist, vis, curr)){
                        return true;
                    }
                }
        }
        return false;

    }
    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        boolean vis[] = new boolean[V];
        for(int i = 0; i < graph.length; i++){
            if(vis[i] == false){
                boolean istrue = DFS(graph, 0, vis, 0);
                if(istrue){
                    System.out.println(istrue);
                    break;
                }
            }
        }
        
        System.out.println();
    }
}
