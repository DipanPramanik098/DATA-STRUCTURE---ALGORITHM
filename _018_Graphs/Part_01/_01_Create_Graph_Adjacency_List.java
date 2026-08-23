package _018_Graphs.Part_01;

import java.util.ArrayList;

public class _01_Create_Graph_Adjacency_List {

    // Edge represents a connection:
    // src  -> source vertex
    // dest -> destination vertex
    // wt   -> weight of the edge
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {

        int v = 5; // Number of vertices: 0, 1, 2, 3, 4

        /*
         * Adjacency List
         *
         * Graph[i] stores all the edges
         * starting from vertex i.
         *
         * Initially:
         *
         * Graph[0] = null
         * Graph[1] = null
         * ...
         */
        ArrayList<Edge>[] Graph = new ArrayList[v];

        // Create an empty ArrayList for every vertex
        for (int i = 0; i < v; i++) {
            Graph[i] = new ArrayList<>();
        }

        /*
         * Creating this weighted undirected graph:
         *
         *        5
         *   0 -------- 1
         *   |          |
         *  2|          |1
         *   |          |
         *   2 -------- 3
         *       3      |
         *              |4
         *              |
         *              4
         */

        // Edge: 0 <-> 1, weight = 5
        Graph[0].add(new Edge(0, 1, 5));
        Graph[1].add(new Edge(1, 0, 5));

        // Edge: 0 <-> 2, weight = 2
        Graph[0].add(new Edge(0, 2, 2));
        Graph[2].add(new Edge(2, 0, 2));

        // Edge: 1 <-> 3, weight = 1
        Graph[1].add(new Edge(1, 3, 1));
        Graph[3].add(new Edge(3, 1, 1));

        // Edge: 2 <-> 3, weight = 3
        Graph[2].add(new Edge(2, 3, 3));
        Graph[3].add(new Edge(3, 2, 3));

        // Edge: 3 <-> 4, weight = 4
        Graph[3].add(new Edge(3, 4, 4));
        Graph[4].add(new Edge(4, 3, 4));


        // Print the complete adjacency list
        for (int i = 0; i < v; i++) {

            System.out.print(i + " -> ");

            for (Edge edge : Graph[i]) {
                System.out.print(
                        "(" + edge.dest + ", wt=" + edge.wt + ") "
                );
            }

            System.out.println();
        }
    }
}