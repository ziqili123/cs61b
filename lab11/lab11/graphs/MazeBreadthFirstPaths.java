package lab11.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {

    private int s;
    private int t;
    private boolean targetfound = false;
    private Maze maze;


    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        // Add more variables here!
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            marked[temp] = true;
            announce();
            if (temp == t) {
                targetfound = true;
            }
            if (targetfound == true) {
                return;
            }
            for (int w : maze.adj(temp)) {
                if (!marked[w]) {
                    queue.offer(w);
                    edgeTo[w] = temp;
                    announce();
                    distTo[w] = distTo[temp] + 1;
                    if (targetfound) {
                        return;
                    }
                }


            }

        }

    }


    @Override
    public void solve() {
        bfs(s);
    }
}

