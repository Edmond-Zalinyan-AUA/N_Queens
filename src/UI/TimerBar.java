package UI;

import static Manager.UIManager.ms;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TimerBar extends JMenuBar {

  JMenuItem timer;

  public TimerBar() {
    super();
    this.timer = new JMenuItem("Time: " + ms + " nanoseconds");
    this.add(timer);
  }

  public void updateTime() {
    timer.setText("Time: " + ms + " nanoseconds");
    System.out.println(ms);
    this.revalidate();
  }


}
