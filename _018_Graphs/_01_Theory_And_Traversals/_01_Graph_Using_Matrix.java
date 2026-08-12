package _018_Graphs._01_Theory_And_Traversals;

public class _01_Graph_Using_Matrix {
    public static int[][] buildUndirected(int n, int[][] edge) {
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];

            arr[v1][v2] = 1;
            arr[v2][v1] = 1;
        }
        return arr;
    }

    public static int[][] buildDirected(int n, int[][] edge) {
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];

            arr[v1][v2] = 1;
        }
        return arr;
    }

    public static void printL(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // ! no of vertex
        int n = 5;
        // ! no of edge
        int m = 6;

        // ! Edge array
        int[][] edge = {
                { 1, 2 }, { 1, 3 },
                { 2, 4 }, { 2, 5 },
                { 3, 4 },
                { 4, 5 }
        };

        // * Undirected Build
        int[][] undirected = buildUndirected(n, edge);

        // * print
        printL(undirected);


        System.out.println();
        System.out.println();
        System.out.println();

        // * Directed Build
        int [][] directed = buildDirected(n, edge);

        printL(directed);
    }
}