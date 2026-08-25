
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _02_Prims_Algorithm {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Pair for PriorityQueue
    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        // Minimum cost comes first
        @Override
        public int compareTo(Pair other) {
            return this.cost - other.cost;
        }
    }

    // Create weighted undirected graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *        1
         *   0 -------- 1
         *   |          |
         *  3|          |2
         *   |          |
         *   2 -------- 3
         *        4
         */

        // 0 <-> 1
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        // 0 <-> 2
        graph[0].add(new Edge(0, 2, 3));
        graph[2].add(new Edge(2, 0, 3));

        // 1 <-> 3
        graph[1].add(new Edge(1, 3, 2));
        graph[3].add(new Edge(3, 1, 2));

        // 2 <-> 3
        graph[2].add(new Edge(2, 3, 4));
        graph[3].add(new Edge(3, 2, 4));
    }

    // Prim's Algorithm
    static int prims(ArrayList<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start from node 0 with cost 0
        pq.offer(new Pair(0, 0));

        int mstCost = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            // Skip if node is already included in MST
            if (visited[curr.node]) {
                continue;
            }

            // Include node in MST
            visited[curr.node] = true;

            // Add selected edge cost
            mstCost += curr.cost;

            // Explore neighbours
            for (Edge e : graph[curr.node]) {

                if (!visited[e.dest]) {
                    pq.offer(new Pair(e.dest, e.wt));
                }
            }
        }

        return mstCost;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int mstCost = prims(graph);

        System.out.println("Minimum Spanning Tree Cost = " + mstCost);
    }
}