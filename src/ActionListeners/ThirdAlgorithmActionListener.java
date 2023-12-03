package ActionListeners;

import static Manager.UIManager.matrix;
import static Manager.UIManager.updateBoard;

import Manager.AlgorithmManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThirdAlgorithmActionListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    matrix = AlgorithmManager.callThirdAlgorithm();
    updateBoard();
  }
}
