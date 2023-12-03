package ActionListeners;

import static Manager.UIManager.updateBoard;

import Manager.AlgorithmManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Manager.UIManager.matrix;

public class StartHovosAlgorithmActionListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    matrix = AlgorithmManager.callHovosAlgorithm();
    updateBoard();
  }
}
