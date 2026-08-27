package Part_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _01_Cheapest_Flight_With_K_Stops {

    // Represents one flight / directed edge
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Create graph using HashMap + Adjacency List
    public static void createGraph(
            int[][] flights,
            int n,
            HashMap<Integer, ArrayList<Edge>> graph) {

        // Create empty adjacency list for every city
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // flights[i] = {from, to, price}
        for (int i = 0; i < flights.length; i++) {

            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];

            graph.get(from).add(
                    new Edge(from, to, price)
            );
        }
    }

    // Stores current city, total cost and stops/edges used
    static class Pair {
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // Modified BFS for cheapest flight within K stops
    public static int cheapestFlight(
            int n,
            int[][] flights,
            int src,
            int dest,
            int k,
            int[] dist,
            HashMap<Integer, ArrayList<Edge>> graph) {

        // Initially all cities are unreachable
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source to source cost = 0
        dist[src] = 0;

        /*
         * Queue stores:
         * (node, currentCost, edges/stops used)
         *
         * Since normal Queue is used,
         * states are processed level-wise by number of flights.
         */
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, 0, 0));

        while (!q.isEmpty()) {

            Pair curr = q.remove();

            /*
             * K stops means maximum K + 1 flights/edges.
             *
             * We can expand a node only while
             * curr.stops <= K.
             */
            if (curr.stops > k) {
                break;
            }

            // Explore all flights from current city
            for (Edge nbr : graph.get(curr.node)) {

                int v = nbr.dest;
                int price = nbr.wt;

                /*
                 * Relaxation:
                 *
                 * If reaching v through curr is cheaper,
                 * update its minimum cost.
                 */
                if (curr.cost + price < dist[v]
                        && curr.stops <= k) {

                    dist[v] = curr.cost + price;

                    // Move to next city
                    // Number of used flights increases by 1
                    q.offer(
                            new Pair(
                                    v,
                                    dist[v],
                                    curr.stops + 1
                            )
                    );
                }
            }
        }

        // Destination unreachable
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dest];
    }

    public static void main(String[] args) {

        int n = 4;

        /*
         * Flight:
         *
         * 0 --100--> 1
         *            |
         *           100
         *            ↓
         *            2 --200--> 3
         *
         * 1 --------600-------> 3
         *
         * 2 --100--> 0
         */
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };

        int src = 0;
        int dest = 3;

        // Maximum intermediate stops allowed
        int k = 1;

        // Graph
        HashMap<Integer, ArrayList<Edge>> graph =
                new HashMap<>();

        createGraph(flights, n, graph);

        // dist[i] = cheapest cost from src to city i
        int[] dist = new int[n];

        int ans = cheapestFlight(
                n,
                flights,
                src,
                dest,
                k,
                dist,
                graph
        );

        System.out.println(
                "Cheapest Flight Cost = " + ans
        );
    }
}