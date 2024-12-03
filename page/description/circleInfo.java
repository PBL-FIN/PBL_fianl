package page.description;

import page.ShapeSelectionPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class circleInfo {
    private JFrame frame;

    public circleInfo() {
        // 프레임 생성
        frame = new JFrame();
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 패널 생성 및 추가
        JPanel panel = new JPanel();
        panel.setLayout(null); // 절대 레이아웃 사용
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // 제목 라벨
        JLabel titleLabel = new JLabel();
        titleLabel.setBounds(200, 10, 200, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 16));  // 글씨 크기 및 폰트 설정
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        // 캐릭터 이미지// 캐릭터 이미지 경로 설정 필요
        ImageIcon characterIcon = new ImageIcon("img/ping4.png"); // 캐릭터 이미지 경로 설정 필요
        Image characterImg = characterIcon.getImage().getScaledInstance(170, 300, Image.SCALE_SMOOTH);
        JLabel characterLabel = new JLabel(new ImageIcon(characterImg));
        characterLabel.setBounds(30, 30, 200, 300);
        panel.add(characterLabel);

        // 원 이미지
        ImageIcon circleIcon = new ImageIcon("img/circle.png"); // 이미지 경로 설정 필요
        Image circleImg = circleIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        JLabel circleLabel = new JLabel(new ImageIcon(circleImg));
        circleLabel.setBounds(270, 0, 200, 200);
        panel.add(circleLabel);

        // 설명 텍스트
        JLabel descriptionLabel = new JLabel("<html>원이 무엇일까요?<br>한 점에서 같은 거리에 있는 점을 이은 도형<br><br>원의 넓이를 구하는 공식은 어떻게 구할까요?<br>반지름(r) × 반지름(r) × 3.14</html>");
        descriptionLabel.setBounds(250, 150, 300, 150);
        descriptionLabel.setFont(new Font("Serif", Font.PLAIN, 15));  // 글씨 크기 및 폰트 설정

        JLabel descriptionLabel = new JLabel("<html>원이 무엇일까요?<br>한 점에서 같은 거리에 있는 점을 이은 도형<br>" +
                "<br>원의 넓이를 구하는 공식은 어떻게 구할까요?<br>반지름 × 반지름 × 3.14</html>");
        descriptionLabel.setBounds(250, 150, 300, 150);
        descriptionLabel.setFont(new Font(null, Font.PLAIN, 15));  // 글씨 크기 및 폰트 설정
        descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(descriptionLabel);

        // 뒤로 가기 버튼
        JButton backButton = new JButton("뒤로 가기");
        backButton.setBounds(250, 300, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ShapeSelectionPage(); // ShapeSelectionPage로 돌아가기
            }
        });
        panel.add(backButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

