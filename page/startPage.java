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
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon("img/bg 1-test.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(-140, -70, 1980, 1080);
        add(backgroundLabel);

        // 시작 이미지 설정
        ImageIcon icon = new ImageIcon("img/start.png");
        Image img = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(310, 400, 500, 500);
        backgroundLabel.add(imageLabel);


        // 게임 시작 버튼
        startButton = new JButton("게임 시작");
        styleButton(startButton);
        startButton.setBounds(310, 370, 250, 70);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new questionPage(); // QuestionPage 클래스가 정의되어 있어야 합니다.
            }
        });
        backgroundLabel.add(startButton);

        // 종료 버튼
        endButton = new JButton("종료");
        styleButton(endButton);
        endButton.setBounds(650, 370, 250, 70);
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                        "종료할거야?",
                        "ㅠㅠ",
                        JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        backgroundLabel.add(endButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 버튼 스타일링 메서드
    private void styleButton(JButton button) {
        button.setFont(new Font("맑은 고딕", Font.PLAIN, 30)); // 폰트 설정
        button.setFocusPainted(false); // 포커스 시 테두리 없애기
        button.setBackground(new Color(255, 255, 255, 180)); // 반투명 흰색 배경
        button.setForeground(new Color(0, 0, 0)); // 글자색 설정
        button.setOpaque(true); // 배경색을 보이게 하려면 true로 설정
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 변경

        button.setContentAreaFilled(false); // 기본 배경 제거
        button.setFocusPainted(false); // 포커스 효과 제거
        button.setRolloverEnabled(false); // 롤오버 효과 제거
    }
    public static void main(String[] args) {
        new startPage();
    }
}
