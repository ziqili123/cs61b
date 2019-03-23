
package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
public class PercolationStats {
    private double[] result;
    public PercolationStats(int N, int T, PercolationFactory pf) {

        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("they can not be zero.");
        }
        result = new double[T];
        for (int i = 0; i < T; i++) {

            Percolation matrix = pf.make(N);
            while (!matrix.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                matrix.open(row, col);
            }
            result[i] = matrix.numberOfOpenSites() / (N * N);
        }
    }
    public double mean() {
        return StdStats.mean(result);

    }
    public double stddev() {

        return StdStats.stddev(result);
    }
    public double confidenceLow() {
        return (mean() - (1.96 * stddev() / Math.sqrt(result.length)));
    }
    public double confidenceHigh() {
        return (mean() + (1.96 * stddev() / Math.sqrt(result.length)));
    }

}
