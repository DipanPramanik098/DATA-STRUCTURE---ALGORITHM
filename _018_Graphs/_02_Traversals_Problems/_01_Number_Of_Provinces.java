package _018_Graphs._02_Traversals_Problems;

public class _01_Number_Of_Provinces {

    public static void dfs(
            int node,
            int[][] adj,
            boolean[] visited) {

        // Mark current city visited
        visited[node] = true;

        // Visit all connected cities
        for (int i = 0; i < adj.length; i++) {

            if (adj[node][i] == 1 && !visited[i]) {
                dfs(i, adj, visited);
            }
        }
    }

    public static int numProvinces(int[][] adj) {

        int n = adj.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                provinces++;

                dfs(i, adj, visited);
            }
        }

        return provinces;
    }

    public static void main(String[] args) {

        int[][] adj = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        System.out.println(numProvinces(adj));
    }
}