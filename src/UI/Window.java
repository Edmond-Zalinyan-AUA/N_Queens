package UI;

import static Manager.UIManager.boardDimensions;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

  public Window(String windowName) {
    super(windowName);
    setDefaultDimensions();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.setIconImage(new ImageIcon("images\\green.png").getImage());
    this.setUndecorated(true);
//    this.setBackground(new Color(112, 69, 40, 244));
  }

  private void setDefaultDimensions() {
    this.setSize(new Dimension(boardDimensions, boardDimensions));
    this.setResizable(false);
    this.setLocationRelativeTo(new Component() {
    });
  }

}
