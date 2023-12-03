package UI;

import javax.swing.*;
import java.awt.*;

import static Manager.UIManager.matrix;
import static Manager.UIManager.boardDimensions;
import static Manager.UIManager.boardSquareSize;
import static Manager.UIManager.N;
import static Manager.UIManager.isValid;

public class Board extends JPanel {

  public static String greenQueenImagePath = "images\\green.png";
  public static String redQueenImagePath = "images\\red.png";
  public static String blackQueenImagePath = "images\\original.png";

  public Board() {
    updateDimensions();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    paint(g);
  }

  public void paint(Graphics g) {
//    Manager.GlobalManager.matrix[0][1] = 1;
//    Manager.GlobalManager.matrix[1][5] = 1;
//    Manager.GlobalManager.matrix[2][7] = 1;
//    Manager.GlobalManager.matrix[3][0] = 1;
//    Manager.GlobalManager.matrix[4][3] = 1;
//    Manager.GlobalManager.matrix[5][6] = 1;
//    Manager.GlobalManager.matrix[6][4] = 1;
//    Manager.GlobalManager.matrix[0][1] = 1;
    validateMatrix();

    // Drawing the Manager.GlobalManager.matrix
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if ((i + j) % 2 == 0) //chess texture of the board
        {
          g.setColor(new Color(112, 69, 40));
        } else {
          g.setColor(new Color(238, 220, 210));
        }
        g.fillRect(i * boardSquareSize, j * boardSquareSize,
            boardSquareSize, boardSquareSize);

        //draw queens (1=green queen, 2 = red queen, 3 black)
        switch (matrix[i][j]) {
          case 1 -> drawGreenQueen(g, i, j);
          case 2 -> drawRedQueen(g, i, j);
          case 3 -> drawBlackQueen(g, i, j);
        }
      }
    }
  }

  /**
   * In the Matrix Puts 2 in place of Queens if they attack each other, leaves 1 if they do not
   * attack each other
   */
  public void validateMatrix() {
    int queenCounter = 0;
    isValid = true; //innocent until proved guilty
    int[] is = new int[N * N];
    int[] js = new int[N * N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        //extract the coordinates of the queen
        if (matrix[i][j] == 1) {
          is[queenCounter] = i;
          js[queenCounter] = j;
          queenCounter++;
        }
      }
    }

    for (int x = 0; x < queenCounter; x++) {
      for (int y = x + 1; y < queenCounter; y++) {
        if (is[x] == is[y] || //same row
            js[x] == js[y] || //same column
            is[x] + js[x] == is[y] + js[y] || //same diagonal
            is[x] - is[y] == js[x] - js[y]    //same diagonal
        ) {
          matrix[is[x]][js[x]] = 2;
          matrix[is[y]][js[y]] = 2;
          isValid = false;
        }
      }
    }
  }

  public void updateDimensions() {
    this.setSize(new Dimension(boardDimensions, boardDimensions));
    this.setMaximumSize(
        new Dimension(boardDimensions, boardDimensions));
    this.setMinimumSize(
        new Dimension(boardDimensions, boardDimensions));
    this.setPreferredSize(
        new Dimension(boardDimensions, boardDimensions));
  }

  private void drawGreenQueen(Graphics g, int i, int j) {
    Image greenQueen = new ImageIcon(greenQueenImagePath).getImage();
    g.drawImage(greenQueen, i * boardSquareSize,
        j * boardSquareSize, boardSquareSize,
        boardSquareSize, null);
  }

  private void drawRedQueen(Graphics g, int i, int j) {
    Image redQueen = new ImageIcon(redQueenImagePath).getImage();
    g.drawImage(redQueen, i * boardSquareSize,
        j * boardSquareSize, boardSquareSize,
        boardSquareSize, null);
  }

  private void drawBlackQueen(Graphics g, int i, int j) {
    Image blackQueen = new ImageIcon(blackQueenImagePath).getImage();
    g.drawImage(blackQueen, i * boardSquareSize,
        j * boardSquareSize, boardSquareSize,
        boardSquareSize, null);
  }
}