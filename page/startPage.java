package page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startPage extends JFrame {

    private JButton startButton;
    private JButton endButton;
    private JLabel gameLabel;

    public startPage() {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon icon = new ImageIcon("img/start.png");
        Image img = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(1150, 50, 500, 500);
        add(imageLabel);

        // 게임 라벨
        gameLabel = new JLabel("도형 넓이 구하기 게임");
        gameLabel.setFont(new Font(null, Font.PLAIN, 50)); // 폰트 설정
        gameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameLabel.setBounds(380, 300, 900, 60); // 라벨을 화면 중간에 배치

        // 게임 시작 버튼
        startButton = new JButton("게임 시작");
        startButton.setFont(new Font(null , Font.PLAIN, 30)); // 버튼 폰트 설정
        startButton.setBounds(490, 500, 300, 70); // 라벨 바로 아래에 위치
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new questionPage();
            }
        });

        // 종료 버튼
        endButton = new JButton("종료");
        endButton.setFont(new Font(null, Font.PLAIN, 30)); // 버튼 폰트 설정
        endButton.setBounds(890, 500, 300, 70); // 시작 버튼 아래에 위치
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

        // 컴포넌트 추가
        add(gameLabel);
        add(startButton);
        add(endButton);

        // 창을 화면 중앙에 위치
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
