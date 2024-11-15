import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame {
  
    private JButton startButton;
    private JButton endButton;
    private JLabel gamePanel;

    public StartPage () {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1280, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  
}
