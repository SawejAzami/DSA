import java.util.*;
class Graph{
    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createAdjacencyList(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,3));
        graph[1].add(new Edge(1,3,2));
        graph[1].add(new Edge(1,4,1));
        graph[1].add(new Edge(1,5,5));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,3,4));
        graph[2].add(new Edge(2,1,3));

        graph[3].add(new Edge(3,1,2));
        graph[3].add(new Edge(3,2,4));
        graph[3].add(new Edge(3,4,5));
        
        graph[4].add(new Edge(4,1,1));
        graph[4].add(new Edge(4,3,5));
        graph[4].add(new Edge(4,5,4));

        graph[5].add(new Edge(5,1,5));
        graph[5].add(new Edge(5,4,4));

        /**
         *   0     3----4
         *    \  /  \  / \
         *     2 ----1----5
         */
    }
   public static class Pair{
    int node;
    int dist;
    Pair(int n,int d){
        this.node=n;
        this.dist=d;
    }
   }
   public static void dijkstraAlgo(ArrayList<Edge> graph[],int src,int vSize){
    PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.dist-b.dist);
    q.add(new Pair(0,0));
    boolean visit[]=new boolean[vSize];
    int dist[]=new int[vSize];
    for(int i=0;i<vSize;i++){
        if(i!=src){
            dist[i]=Integer.MAX_VALUE;
        }
    }
    while(!q.isEmpty()){
        Pair newPair=q.remove();
        visit[newPair.node]=true;
        for(int i=0;i<graph[newPair.node].size();i++){
            Edge e=graph[newPair.node].get(i);
            int u=e.src;
            int v=e.dest;
            int wt=e.wt;
            if(dist[v]>dist[u]+wt){
                dist[v]=dist[u]+wt;
                q.add(new Pair(v,dist[v]));
            }
        }
    }
    for(int i=0;i<vSize;i++){
        System.out.print(dist[i]+" ");
    }

   }

    public static void main(String[] arg){
        int v=6;
        // ArrayList<Edge> graph[]=new ArrayList[v];
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];

        createAdjacencyList(graph);
        dijkstraAlgo(graph,0,v);
    }
}