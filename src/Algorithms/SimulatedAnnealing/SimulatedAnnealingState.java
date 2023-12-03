package Algorithms.SimulatedAnnealing;

import java.util.Random;

/**
 *
 * @author Rumal
 */
public class SimulatedAnnealingState{

    int boardSize;
    int cost;
    protected Queen q[];

    Random randomGenerator = new Random();

    public SimulatedAnnealingState(int boardSize) {
        this.boardSize = boardSize;
        q = new Queen[boardSize];
        cost = 0;
        for (int i = 0; i < boardSize; i++) {
            q[i] = new Queen(i, randomGenerator.nextInt(boardSize));
        }
    }

    public SimulatedAnnealingState(int boardSize, Queen q[]) {
        this.boardSize = boardSize;
        this.q = q;
        cost = 0;
    }


    public SimulatedAnnealingState getNextState() {
        int i;
        Queen nextStateQueen[] = new Queen[boardSize];
        //randomly pick a queen we want to change at a time.
        int rand = randomGenerator.nextInt(boardSize);

        for (i = 0; i < boardSize; i++) {
            nextStateQueen[i] = new Queen(q[i].getIndexOfX(),
                    q[i].getIndexOfY());
            //we only change that randomly picked queen in this state. 
            //if the current queen is not the queen we picked
            //the next state of that queen will be same as the previos queen.
            if (rand == i) {
                int temp = randomGenerator.nextInt(boardSize);
                //this is to ensure that the new state will not be the same as the 
                //previoius state
                while (temp == q[i].getIndexOfY()) {
                    temp = randomGenerator.nextInt(boardSize);
                }
                //new state will be added to the new state
                nextStateQueen[i] = new Queen(q[i].getIndexOfX(), temp);
            }
        }

        return new SimulatedAnnealingState(boardSize, nextStateQueen);
    }

    public void calculateCost() {
        int i, j;
        cost = 0;

        for (i = 0; i < boardSize; i++) {
            for (j = 0; j < boardSize; j++) {
                if (i==j) continue;
                if (q[i].getIndexOfX() == q[j].getIndexOfX() // same row
                    || q[i].getIndexOfY() == q[j].getIndexOfY() //same column
                    || (q[i].getIndexOfX() - q[j].getIndexOfX() == q[i].getIndexOfY() - q[j].getIndexOfY()) // same diagonal
                    || (q[i].getIndexOfX() - q[j].getIndexOfX() == q[j].getIndexOfY() - q[i].getIndexOfY())) { //same counter diagonal
                    cost++;
                }
            }
        }
        //this is due to double counting
        cost = cost / 2;

    }

    public int getCost() {
        calculateCost();
        return cost;
    }

    public Queen[] getQueens() {
        return q;
    }

}
