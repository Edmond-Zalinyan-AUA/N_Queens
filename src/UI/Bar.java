package UI;

import ActionListeners.ChangeOfNActionListener;
import ActionListeners.SecondAlgorithmActionListener;
import ActionListeners.StartHovosAlgorithmActionListener;
import ActionListeners.ThirdAlgorithmActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Bar extends JMenuBar {

  public Bar() {
    super();
    addNChooser();
    addHovosAlgorithmStarter();
    addSecondAlgorithmStarter();
    addThirdAlgorithmStarter();
  }

  private void addNChooser() {
    JMenuItem size = new JMenuItem("N=");
    JTextField sizeField = new JFormattedTextField();
    size.setFont(new Font(null, Font.PLAIN, 25));
    sizeField.setFont(new Font(null, Font.PLAIN, 25));
    sizeField.addActionListener(new ChangeOfNActionListener());

    this.add(size);
    this.add(sizeField);
  }

//  private void addSizeChooser( ) {
//    JMenuItem NIsEqualTo = new JMenuItem("Size=");
//    JTextField field = new JFormattedTextField();
//    NIsEqualTo.setFont(new Font(null, Font.PLAIN, 25));
//    field.setFont(new Font(null, Font.PLAIN, 25));
//    field.addActionListener(new ChangeOfSizeActionListener());
//    this.add(NIsEqualTo);
//    this.add(field);
//  }

  private void addHovosAlgorithmStarter() {
    JButton start = new JButton("Easy Pattern approach");
    start.setFont(new Font(null, Font.PLAIN, 10));
    start.addActionListener(new StartHovosAlgorithmActionListener());
    this.add(start);
  }

  private void addSecondAlgorithmStarter() {
    JButton start = new JButton("Simulated Annealing");
    start.setFont(new Font(null, Font.PLAIN, 10));
    start.addActionListener(new SecondAlgorithmActionListener());
    this.add(start);
  }

  private void addThirdAlgorithmStarter() {
    JButton start = new JButton("Backtracking");
    start.setFont(new Font(null, Font.PLAIN, 10));
    start.addActionListener(new ThirdAlgorithmActionListener());
    this.add(start);
  }

}
