package ActionListeners;

import Manager.UIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Manager.UIManager.N;
import static Manager.UIManager.ms;

public class ChangeOfNActionListener implements ActionListener {


  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
    try {
      int n = Integer.parseInt(e.getActionCommand());
      if (n == 2 || n == 3) {
        throw new Exception();
      }
      N = n;
      ms = 0;
      UIManager.clearMatrix();
      UIManager.updateBoard();
    } catch (Exception ex) {
      System.out.println("N must be 1 or an integer greater than 3");
    }
  }
}

