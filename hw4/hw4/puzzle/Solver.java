package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class Solver {

    List<WorldState> solution;
    public Solver(WorldState initial) {
        solution = new ArrayList<>();
        MinPQ<searchNode> minPQ = new MinPQ<>();
        searchNode ini = new searchNode(initial, 0, null);
        minPQ.insert(ini);

        while(!minPQ.min().getWorldState().isGoal()) {
            searchNode node = minPQ.delMin();
            for (WorldState ws : node.getWorldState().neighbors()) {
                if (node.prev == null || !(ws.equals(node.prev.getWorldState()))) {
                    searchNode newNode = new searchNode(ws, node.numOfMoves + 1, node);
                    minPQ.insert(newNode);
                }
            }
        }
        searchNode x = minPQ.min();
        while(x != null) {
            solution.add(0, x.getWorldState());
            x = x.prev;
        }




    }


    private class searchNode implements Comparable<searchNode> {
        private WorldState ws;
        private int numOfMoves;
        private searchNode prev;

        private searchNode(WorldState ws, int numOfMoves, searchNode prev) {
            this.ws = ws;
            this.numOfMoves = numOfMoves;
            this.prev = prev;
        }
        public WorldState getWorldState() {
            return ws;
        }
        public int getMoves() {
            return numOfMoves;
        }
        public searchNode getPrev() {
            return prev;
        }
         @Override
        public int compareTo(searchNode sn) {
            return ((this.numOfMoves + ws.estimatedDistanceToGoal() - (sn.numOfMoves + sn.ws.estimatedDistanceToGoal())));
        }

    }

    public int moves() {
        return solution.size() - 1;
    }
    public Iterable<WorldState> solution() {
        return solution;
    }
}
