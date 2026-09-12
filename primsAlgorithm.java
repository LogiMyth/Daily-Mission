import java.util.*;

public class primsAlgorithm{
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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;  // ascending order
        }
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0,0));

        int finalCost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]  = true;

                finalCost += curr.cost;

                for(int i = 0; i < graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dist]){
                        pq.add(new Pair(e.dist, e.weight));
                    }
                }
            }
        }
        System.out.println(finalCost);
    }
    public static void main(String[] args) {
        int x = 4;
        ArrayList<Edge> graph[] = new ArrayList[x];

        createGraph(graph);
        primsAlgo(graph, x);
    }
}
