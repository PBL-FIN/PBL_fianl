package page;

import page.difficulty.difficultyPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class questionPage extends JFrame {
    private JLabel questionLabel;
    private JButton yesButton;
    private JButton noButton;

    public questionPage() {
        setTitle("넓이 구하는 게임");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon("img/bg 3-test.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(-130, -140, 1920, 1080);
        add(backgroundLabel);

        // 버튼 설정
        yesButton = new JButton("응");
        styleButton(yesButton);
        yesButton.setBounds(850, 650, 200, 60);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "좋아! 그럼 바로 문제로~!");
                dispose();
                new difficultyPage();
            }
        });
        backgroundLabel.add(yesButton);

        noButton = new JButton("아니");
        styleButton(noButton);
        noButton.setBounds(1250, 650, 200, 60);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "괜찮아~ 그럼 도형의 넓이에 대해 알아보러 가볼까?");

                dispose();
                new ShapeSelectionPage();
            }
        });
        backgroundLabel.add(noButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void styleButton(JButton button) {
        button.setFont(new Font("맑은 고딕", Font.PLAIN, 30)); // 폰트 설정
        button.setFocusPainted(false); // 포커스 시 테두리 없애기
        button.setBackground(new Color(175, 219, 239, 255));
        button.setForeground(new Color(0, 0, 0)); // 글자색 설정
        button.setOpaque(true); // 배경색을 보이게 하려면 true로 설정
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 변경

        //button.setContentAreaFilled(false); // 기본 배경 제거
        button.setFocusPainted(false); // 포커스 효과 제거
        button.setRolloverEnabled(false); // 롤오버 효과 제거
    }
        public static void main(String[] args) {
            new startPage();
        }
    }
