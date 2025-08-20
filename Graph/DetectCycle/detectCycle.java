import java.util.*;
class Graph{
    public static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createAdjacencyList(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));

        // graph[1].add(new Edge(1,2));
        // graph[1].add(new Edge(1,3));
        // graph[1].add(new Edge(1,4));
        // graph[1].add(new Edge(1,5));

        // graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));
        // graph[2].add(new Edge(2,1));

        // graph[3].add(new Edge(3,1));
        // graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));
        
        // graph[4].add(new Edge(4,1));
        // graph[4].add(new Edge(4,3));
        // graph[4].add(new Edge(4,5));

        // graph[5].add(new Edge(5,1));
        // graph[5].add(new Edge(5,4));

        /**
         *   0     3----4
         *    \  /  
         *     2 
         */
        /**
         *   0     3----4
         *    \  /  \  / \
         *     2 ----1----5
         */
    }
   public static boolean detectCycle(ArrayList<Edge> graph[],boolean visit[],int curr,boolean rec[]){
        visit[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(rec[e.dest]==true){
                return true;
            }else if(visit[e.dest]==false){
                if(detectCycle(graph,visit,e.dest,rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;

   }
    

    public static void main(String[] arg){
        int v=6;
        // ArrayList<Edge> graph[]=new ArrayList[v];
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];

        createAdjacencyList(graph);

        boolean visit[]=new boolean[v+1];
       boolean ans= detectCycle(graph,new boolean[v],0,new boolean[v]);
       System.out.println(ans);
        
    }
}