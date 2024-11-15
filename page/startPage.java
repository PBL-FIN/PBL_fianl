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
        
        endButton = new JButton("종료");
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                        "종료하시겠습니까?",
                        "종료 확인",
                        JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });      
        gamePanel = new JLabel("도형 넓이 구하기 게임");

        // JLabel 텍스트 크기 조정 (굵기 없음)
        gamePanel.setFont(new Font(null, Font.PLAIN, 50)); // 폰트 설정 (글꼴, 일반, 크기)

        startButton.setBounds(900, 600, 300, 50);
        endButton.setBounds(900, 700, 300, 50);
        gamePanel.setBounds(320, 200, 600, 60);      
       
        add(startButton);
        add(endButton);
        add(gamePanel);
        add(gamePanel);

        setVisible(true);
    }      
}
