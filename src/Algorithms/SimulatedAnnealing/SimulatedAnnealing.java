package Algorithms.SimulatedAnnealing;

/**
 *
 * @author Rumal
 */
public class SimulatedAnnealing{

    double temperature;
    int boardSize;

    protected int tollerenceCost;

    protected SimulatedAnnealingState currentState, nextState;


    public SimulatedAnnealing(int boardSize, int tollerence, double temperature) {
        this.boardSize = boardSize;
        this.tollerenceCost = tollerence;
        this.temperature = temperature;
        currentState = new SimulatedAnnealingState(boardSize);
    }

    public void solve() {
        while (!isSolvedPossition(currentState)) {
            double temperature;
            double delta;
            double probability;
            double rand;


            for (temperature = this.temperature; (temperature > 0) && (currentState.getCost() != 0); temperature--) {
                nextState = currentState.getNextState();
                delta = currentState.getCost() - nextState.getCost();
                probability = Math.exp(delta / temperature);
                rand = Math.random();

                if (delta > 0) {
                    currentState = nextState;
                } else if (rand <= probability) {
                    currentState = nextState;
                }
            }
        }
    }

    public int[][] convertIntoMatrix() {
        int[][] matrix = new int[boardSize][boardSize];
        Queen[] q = currentState.getQueens();

        for (int i = 0; i < boardSize; i++) {
            matrix[q[i].getIndexOfX()][q[i].getIndexOfY()] = 1;
        }

        return matrix;

    }

    protected boolean isSolvedPossition(SimulatedAnnealingState s) {
        if (s.getCost() <= tollerenceCost) {
            return true;
        }
        return false;
    }
}
