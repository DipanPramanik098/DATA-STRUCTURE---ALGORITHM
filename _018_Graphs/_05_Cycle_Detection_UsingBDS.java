package _018_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _05_Cycle_Detection_UsingBDS {
    public static boolean isCycle(HashMap<Integer, ArrayList<Integer>> graph, int V){
        HashSet<Integer> vis = new HashSet<>();
        for(int i=0;i<V;i++){
            if(!vis.contains(i)){
                if(bfs(graph, i, vis)) return true;
            }
        }
        return false;
    }
    public static boolean bfs(HashMap<Integer, ArrayList<Integer>> graph, int v, HashSet<Integer>vis){
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{v, -1});
        vis.add(v);
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int val = curr[0];
            int par = curr[1];
            for(int nbrs : graph.getOrDefault(val, new ArrayList<>())){
                if(!vis.contains(nbrs)){
                    vis.add(nbrs);
                    q.offer(new int[]{nbrs, val}); //here val is nbrs parent
                }else if(nbrs != par){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int V = 6;
        for(int i=0; i<V; i++){
            graph.put(i, new ArrayList<>());
        }

        addEdge(0, 1, graph);
        addEdge(0, 2, graph);
        addEdge(3, 4, graph);
        addEdge(3, 5, graph);
        addEdge(4, 5, graph);

        System.out.println(isCycle(graph, V));

    }
    public static void addEdge(int u, int v, HashMap<Integer, ArrayList<Integer>> graph){
        graph.get(u).add(v);
        graph.get(v).add(u); // remove if directed
    }
}
