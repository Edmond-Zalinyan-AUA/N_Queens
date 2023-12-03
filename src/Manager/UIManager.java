package Manager;

import UI.Bar;
import UI.Board;
import UI.TimerBar;
import UI.Window;
import javax.swing.JMenuBar;

public class UIManager {

  public static int N = 8;
  public static int boardSquareSize;
  public static int boardDimensions = 600;
  public static int[][] matrix = new int[N][N];
  public static Window window;
  public static Board board;
  public static Bar bar;
  public static TimerBar timer;
  public static long ms;
  public static boolean isValid = true;

  public static void init() {
    window = new Window("N-Queens");
    board = new Board();
    bar = new Bar();
    timer = new TimerBar();
    window.add(bar);
    window.add(board);
    window.add(timer);
    window.pack();
    window.setVisible(true);
    ms = 0;
  }

  public static void updateParameters() {
    //adjusting square and board sizes
    boardDimensions = 600;
    boardSquareSize = (int) ((boardDimensions * 1.) / N + 0.5);
    boardDimensions = boardSquareSize * N;
  }

  public static void clearMatrix() {
    //clear the matrix (the board and queen locations)
    matrix = new int[N][N];
  }

  /**
   * Updated Parameters and redraws the board
   */
  public static void updateBoard() {
    updateParameters();
    board.updateDimensions();
    board.repaint();
    timer.updateTime();
    window.pack();
    window.revalidate();
  }
}
