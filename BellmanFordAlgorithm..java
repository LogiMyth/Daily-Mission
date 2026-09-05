import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BellmanFordAlgorithm {
    static class Edge{
        int src;
        int dist;
        int weight;

        public Edge(int s , int d, int w){
            this.src = s;
            this.dist = d;
            this.weight = w;
        }
    }

    // public static boolean visited (int curr){

    // }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        graph[1].add(new Edge(1, 3, 7));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3, 2));
        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4, 4));
        // graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 1, -1));
        // graph[4].add(new Edge(4, 5, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));

        // graph[6].add(new Edge(6, 5));
    }

    public static void BFS(ArrayList<Edge> graph[], int V){
        Queue <Integer> q = new LinkedList<>();
        boolean vis[] =  new boolean[V];
        q.add(0);

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


    static class pair implements Comparable<pair>{
        int node;
        int dis;
        public pair (int n, int d){
            this.node = n;
            this.dis = d;
        }

        @Override
        public int  compareTo(pair p2){
            return this.dis - p2.dis; // asending order me change ho jata hai
            // for the desending order it will be p2.dis - this.dis
        }
    }


    public static void DijkstraAl(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for(int i = 0; i < V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];
        pq.add(new pair(0, 0)); 


        while (!pq.isEmpty()) {
            pair curr =  pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(Edge e : graph[curr.node]){
                    // Edge e = graph[curr].get(i);
                    int u = e.src;
                    int v = e.dist;

                    if(dist[u] + e.weight < dist[v]){
                        dist[v] = e.weight + dist[u];

                        pq.add(new pair(v, dist[v]));
                    }
                }
            }            
        }
        for(int i = 0; i < V; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }


    public static void BellmanFordAlgo(ArrayList <Edge> graph[], int src, int V){
        int dist[] = new int[V];
        for(int i = 0; i < V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int k = 0; k < V - 1; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < graph[i].size(); j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dist;

                    if(dist[u] + e.weight < dist[v] && dist[u] != Integer.MAX_VALUE){
                        dist[v] = dist[u] + e.weight;
                    

                    }
                }
            }
        }
        for(int j=0; j<graph.length; j++) {
            for(int k=0; k<graph[j].size(); k++) {
                Edge e = graph[j].get(k);
                int u = e.src;
                int v = e.dist;
                int wt = e.weight;
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                    System.out.println("negative weight cycle exists");
                    break;
                }
            }
        }
        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");              
        }
    }
    public static void main(String[] args) {
        int x = 5;
        ArrayList<Edge> graph[] = new ArrayList[x];

        createGraph(graph);
        BellmanFordAlgo(graph, 0, x);

        // DijkstraAl(graph, 0, x);
        // BFS(graph, x);
        // System.out.println();

        // printing 2's Graph neighbours----
        // for(int i = 0; i < graph[2].size(); i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.src + "->" + e.dist);
        // }
    }
}
