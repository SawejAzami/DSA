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
        graph[1].add(new Edge(1,5));

        // graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));
        // graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,1));
        // graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));
        
        // graph[4].add(new Edge(4,1));
        // graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        // graph[5].add(new Edge(5,1));
        // graph[5].add(new Edge(5,4));

        /**
         *   0     3---->4
         *    \  /  \   \
         *     2     1---->5
         */
    }
   
    public static void sortingUtil(ArrayList<Edge> graph[],int curr,boolean visit[],Stack<Integer> stack){
            visit[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    if(visit[e.dest]==false){
                        sortingUtil(graph,e.dest,visit,stack);
                    }
                }
                stack.push(curr);
    }
    public static void sort(ArrayList<Edge> graph[],int v){
        Stack<Integer> stack=new Stack<>();
        boolean visit[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visit[i]){
                sortingUtil(graph,i,visit,stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
   

    public static void main(String[] arg){
        int v=6;
        // ArrayList<Edge> graph[]=new ArrayList[v];
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];

        createAdjacencyList(graph);
        sort(graph,v);
        
        
    }
}