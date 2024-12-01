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
        setLayout(null); // FlowLayout 사용

        questionLabel = new JLabel("도형의 넓이 구하는 공식을 아시나요?");
        yesButton = new JButton("네");
        noButton = new JButton("아니오");

        // 버튼 클릭 시 이벤트 설정
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "알겠습니다! 바로 문제로~.");
                dispose();
                new difficultyPage();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "좋습니다! 도형의 넓이에 대해 알아보겠습니다.");
                dispose();
                new ShapeSelectionPage();
            }
        });
        questionLabel.setFont(new Font(null, Font.PLAIN, 50));
        questionLabel.setBounds(200, 400, 1000, 50);
        yesButton.setBounds(500, 500, 100, 40);
        noButton.setBounds(700, 500, 100, 40);
        // 컴포넌트 추가
        add(questionLabel);
        add(yesButton);
        add(noButton);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

