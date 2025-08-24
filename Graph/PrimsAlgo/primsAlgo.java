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
        graph[1].add(new Edge(1,3,1));
        graph[1].add(new Edge(1,4,1));
        graph[1].add(new Edge(1,5,2));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,3,4));
        graph[2].add(new Edge(2,1,3));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,2,4));
        graph[3].add(new Edge(3,4,5));
        
        graph[4].add(new Edge(4,1,1));
        graph[4].add(new Edge(4,3,5));
        graph[4].add(new Edge(4,5,4));

        graph[5].add(new Edge(5,1,2));
        graph[5].add(new Edge(5,4,4));

        /**
         *   0     3----4
         *    \  /  \  / \
         *     2 ----1----5
         */
    }
   public static class Pair{
    int node;
    int cost;
    Pair(int n,int c){
        this.node=n;
        this.cost=c;
    }
   }
   public static void primsAlgo(ArrayList<Edge> graph[],int src,int V){
    PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.cost-b.cost);
    q.add(new Pair(src,0));
    boolean visit[]=new boolean[V];
    int mstCost=0;
    while(!q.isEmpty()){
        Pair curr=q.remove();
        if(!visit[curr.node]){
            mstCost+=curr.cost;
            System.out.print("("+curr.node+", "+curr.cost+")  ");
            visit[curr.node]=true;
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);
                if(!visit[e.dest]){
                    q.add(new Pair(e.dest,e.wt));
                }
            }
        }
    }
    System.out.println();
    System.out.println("Minimum Spanning Tree Cost: "+mstCost);
   }

    public static void main(String[] arg){
        int v=6;
        // ArrayList<Edge> graph[]=new ArrayList[v];
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];

        createAdjacencyList(graph);
        primsAlgo(graph,5,v);
    }
}