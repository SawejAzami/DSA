import java.util.*;
class Graph{
    public static class Edge{
        int src;
        int dest;
        int weight;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }
    public static void createAdjacencyList(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2,10));

        graph[1].add(new Edge(1,2,4));
        graph[1].add(new Edge(1,3,6));

        graph[2].add(new Edge(2,0,10));
        graph[2].add(new Edge(2,1,4));
        graph[2].add(new Edge(2,3,5));

        graph[3].add(new Edge(3,1,6));
        graph[3].add(new Edge(3,2,5));
    }
    public static void printList(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                System.out.println(e.src+"-"+e.dest+"-"+e.weight);
            }
            System.out.println();
        }
    }

    public static void main(String[] arg){
        int v=4;
        // ArrayList<Edge> graph[]=new ArrayList[v];
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];

        createAdjacencyList(graph);
        printList(graph);
    }
}