/*package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    int[] x = {1, 0, 0, -1};
    int[] y = {0, 1, -1, 0};
    int size = 0;
    boolean[] matrix ;
    WeightedQuickUnionUF result;
    public Percolation(int N) {

        matrix = new boolean[N * N + 2];
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException("N should not be smaller than 0.");
        }
        // index N * N , the item connect
        ed with the first column, N * N + 1 the item connected with the last item;
        for (int i = 0; i < N * N; i++) {
            matrix[i] = false;
        }
        result = new WeightedQuickUnionUF(N * N + 2);

    }
    private int getN() {
        return (int) Math.sqrt(matrix.length - 2);
    }
    private int toOneD(int row, int col) {
        return row * 5 + col;
    }

    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }

        if (!inBound(row, col)) {
            throw new java.lang.IllegalArgumentException("exceded");
        }
        int N = getN();
        int index = toOneD(row, col);
        matrix[index] = true;
        size += 1;
        if (index < N) {
            result.union(index + 1, N * N + 1);
        }
        if (index < N * N && index > (N - 1) * N) {
            result.union(index + 1, N * N + 2);
        }
        for (int i = 0; i < 4; i++) {
            int newRow = row + x[i];
            int newCol = col + y[i];
            if (inBound(newRow, newCol)) {
                if (isOpen(newRow, newCol)) {
                    result.union(index + 1, toOneD(newRow, newCol) + 1);
                }
            }
        }
    }
    private boolean inBound (int row, int col) {
        if (row < getN() && col < getN() && row > -1 && col > -1) {
            return true;
        }
        return false;
    }
    public boolean isOpen(int row, int col) {
        if (!inBound(row, col)) {
            throw new java.lang.IllegalArgumentException("exceded");
        }
        return matrix[toOneD(row,col)];

    }
    public boolean isFull(int row, int col) {
        if (!inBound(row, col)) {
            throw new java.lang.IllegalArgumentException("exceded");
        }
        return result.connected(toOneD(row, col) + 1, getN() * getN() + 1);
    }
    public int numberOfOpenSites() {
        return size;
    }

    public boolean percolates() {
        int N = getN();
        return result.connected(N * N + 1, N * N + 2);
    }
    public static void main(String[] args) {


        Percolation per = new Percolation(6);
        per.open(1,2);
        per.open(0,2);
        per.open(3,2);
        per.open(2,2);
        per.open(4,2);
        per.open(5,3);
        per.open(4,3);
        per.open(5,3);
        if(per.percolates()) System.out.println(per.numberOfOpenSites());

    }


}*/
package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;
    private boolean[][] grid;
    private int openSitesNumber;
    private WeightedQuickUnionUF unionSet;
    private WeightedQuickUnionUF unionSetNoBot;
    private int bottom;
    private int top;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N should be greater than 0");
        }
        this.N = N;
        grid = new boolean[N][N];
        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[i].length; j += 1) {
                grid[i][j] = false;
            }
        }

        openSitesNumber = 0;
        top = 0;
        bottom = N * N + 1;
        unionSet = new WeightedQuickUnionUF(N * N  + 2);
        unionSetNoBot = new WeightedQuickUnionUF(N * N + 2);
    }

    public void open(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new IndexOutOfBoundsException("Invalid numbers for row and col");
        }

        if (grid[row][col]) {
            return;
        }
        grid[row][col] = true;
        openSitesNumber += 1;

        int coord = xyTo1D(row, col);
        if (coord <= N) {
            unionSet.union(top, coord);
            unionSetNoBot.union(top, coord);
        }

        unionTop(row, col);
        unionBottom(row, col);
        unionLeft(row, col);
        unionRight(row, col);

        if (coord >= N * N + 1 - N && coord <= N * N) {
            unionSet.union(bottom, coord);
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new IndexOutOfBoundsException("Invalid numbers for row and col");
        }

        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new IndexOutOfBoundsException("Invalid numbers for row and col");
        }

        int coord = xyTo1D(row, col);
        return isOpen(row, col) && unionSetNoBot.connected(top, coord);
    }

    public int numberOfOpenSites() {
        return openSitesNumber;
    }

    public boolean percolates() {
        return unionSet.connected(top, bottom);
    }

    private int xyTo1D(int row, int col) {
        return row * N + col + 1;
    }

    private void unionTop(int row, int col) {
        try {
            if (isOpen(row - 1, col)) {
                int coord = xyTo1D(row, col);
                int coord1 = xyTo1D(row - 1, col);
                unionSet.union(coord, coord1);
                unionSetNoBot.union(coord, coord1);
            }
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    private void unionBottom(int row, int col) {
        try {
            if (isOpen(row + 1, col)) {
                int coord = xyTo1D(row, col);
                int coord1 = xyTo1D(row + 1, col);
                unionSet.union(coord, coord1);
                unionSetNoBot.union(coord, coord1);
            }
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    private void unionLeft(int row, int col) {
        try {
            if (isOpen(row, col - 1)) {
                int coord = xyTo1D(row, col);
                int coord1 = xyTo1D(row, col - 1);
                unionSet.union(coord, coord1);
                unionSetNoBot.union(coord, coord1);
            }
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    private void unionRight(int row, int col) {
        try {
            if (isOpen(row, col + 1)) {
                int coord = xyTo1D(row, col);
                int coord1 = xyTo1D(row, col + 1);
                unionSet.union(coord, coord1);
                unionSetNoBot.union(coord, coord1);
            }
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    public static void main(String[] args) {
        Percolation test = new Percolation(5);
        test.open(3, 4);
        test.open(2, 4);
        test.open(2, 2);
        test.open(2, 3);
        test.open(0, 2);
        test.open(1, 2);
        test.open(4, 4);
        System.out.println(test.isFull(2, 2));
        System.out.println(test.percolates());
    }
}
