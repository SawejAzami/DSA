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

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,4));
        graph[1].add(new Edge(1,5));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));
        
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,1));
        graph[5].add(new Edge(5,4));

        /**
         *   0     3----4
         *    \  /  \  / \
         *     2 ----1----5
         */
    }
    public static void printList(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                System.out.println(e.src+"-"+e.dest);
            }
            System.out.println();
        }
    }
    public static void bfs(ArrayList<Edge> graph[],int v){
        Queue<Integer> q=new LinkedList<>();
        boolean visit[]=new boolean[v+1];
        // take 0 as a starting point
        q.add(0);

        while(!q.isEmpty()){
            int curr=q.remove();
            if(visit[curr]==false){
            System.out.print(curr+" ");
                visit[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    if(visit[e.dest]==false){
                        q.add(e.dest);
                    }
                }
            }
        }

    }

    public static void main(String[] arg){
        int v=6;
        // ArrayList<Edge> graph[]=new ArrayList[v];
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];

        createAdjacencyList(graph);
        bfs(graph,v);
        // printList(graph);
    }
}