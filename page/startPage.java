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
       
        // 게임 시작 버튼
        startButton = new JButton("게임 시작");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new startGame();
            }
        });      
}
