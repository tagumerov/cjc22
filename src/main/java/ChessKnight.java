import java.util.ArrayList;

public class ChessKnight {

    public static int countMoves(
            int width, int height,
            int startCol, int startRow,
            int endCol, int endRow) {

        int[][] desk = new int[height][width];
        int point = 1;
        desk[startRow - 1][startCol - 1] = point;
        int[] dx = {2, -2, 2, -2, 1, 1, -1, -1};
        int[] dy = {1, 1, -1, -1, 2, -2, 2, -2};
        startCol--;
        startRow--;
        endCol--;
        endRow--;
        ArrayList<Integer> vertexX;
        ArrayList<Integer> vertexY;
        ArrayList<Integer> newVertexX = new ArrayList<>();
        ArrayList<Integer> newVertexY = new ArrayList<>();
        newVertexX.add(startCol);
        newVertexY.add(startRow);
        boolean stop = false;

        do {
            stop = true;
            vertexX = newVertexX;
            vertexY = newVertexY;
            newVertexX = new ArrayList<>();
            newVertexY = new ArrayList<>();
            for (int i = 0; i < vertexY.size(); i++) {
                for (int k = 0; k < dx.length; k++)
                    if (vertexX.get(i) + dx[k] < width && vertexX.get(i) + dx[k] >= 0 && vertexY.get(i) + dy[k] >= 0 && vertexY.get(i) + dy[k] < height) {
                        if (desk[vertexY.get(i) + dy[k]][vertexX.get(i) + dx[k]] == 0) {
                            stop = false;
                            desk[vertexY.get(i) + dy[k]][vertexX.get(i) + dx[k]] = point + 1;
                            newVertexX.add(vertexX.get(i) + dx[k]);
                            newVertexY.add(vertexY.get(i) + dy[k]);
                        }
                    }
            }
            point++;
        } while (!stop && desk[endRow][endCol] == 0);
        if (desk[endRow][endCol] == 0)
            return -1;
        return desk[endRow][endCol] - 1;
    }
}
