import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Islands {



    // Complete the countConnections function below.
    static int countConnections(List<List<Integer>> matrix) {
        Integer[][] a = matrix.stream()
                .map(l -> l.stream().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
        int i = matrix.size();
        int j = matrix.get(0).size();
        return countConnects(a, i , j);
    }

    // No of rows and columns
    static final int ROW = 5, COL = 5;

    // A function to check if a given cell (row, col) can
    // be included in DFS
    static boolean isSafe(Integer M[][], int row, int col,
                          boolean visited[][])
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    static void DFS(Integer M[][], int row, int col, boolean visited[][])
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    static int countConnects(Integer M[][], int i, int j)
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[i][j];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int m = 0; m < ROW; ++m)
            for (int n = 0; n < COL; ++n)
                if (M[m][n] == 1 && !visited[m][n]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, m, n, visited);
                    ++count;
                }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int matrixRows = Integer.parseInt(bufferedReader.readLine().trim());
        int matrixColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, matrixRows).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = countConnections(matrix);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
