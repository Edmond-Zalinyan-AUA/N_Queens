package Manager;

import Algorithms.BackTracking;
import Algorithms.HovosAlgorithm;
import Algorithms.SimulatedAnnealing.SimulatedAnnealing;

import static Manager.UIManager.N;
import static Manager.UIManager.ms;

public class AlgorithmManager {

  public static int[][] callHovosAlgorithm() {
    long startTime = System.nanoTime();
    int[][] result = HovosAlgorithm.n_queens();
    long endTime = System.nanoTime();
    ms = endTime - startTime;
    return result;
  }

  public static int[][] callSecondAlgorithm() {
    long startTime = System.nanoTime();

    SimulatedAnnealing nq;
    nq = new SimulatedAnnealing(N, 0, 1500);
    nq.solve();
    int[][] result = nq.convertIntoMatrix();
    long endTime = System.nanoTime();
    ms = endTime - startTime;
    return result;
  }

  public static int[][] callThirdAlgorithm() {
    long startTime = System.nanoTime();
    int[][] result = BackTracking.solveNQ();
    long endTime = System.nanoTime();
    ms = endTime - startTime;
    return result;
  }


}
