package page.description;

import page.ShapeSelectionPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class triangleInfo {
    private JFrame frame;

    public triangleInfo() {
        // 프레임 생성
        frame = new JFrame();
        frame.setSize(650, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 패널 생성 및 추가
        JPanel panel = new JPanel();
        panel.setLayout(null); // 절대 레이아웃 사용
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        // 제목 라벨
        JLabel titleLabel = new JLabel();
        titleLabel.setBounds(200, 10, 230, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 16));  // 글씨 크기 및 폰트 설정
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        // 캐릭터 이미지
        ImageIcon characterIcon = new ImageIcon("img/ping4.png"); // 캐릭터 이미지 경로 설정 필요
        Image characterImg = characterIcon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        JLabel characterLabel = new JLabel(new ImageIcon(characterImg));
        characterLabel.setBounds(30, 30, 200, 300);
        panel.add(characterLabel);

        // 삼각형 이미지
        ImageIcon triangleIcon = new ImageIcon("img/triangle.png"); // 이미지 경로 설정 필요
        Image triangleImg = triangleIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        JLabel circleLabel = new JLabel(new ImageIcon(triangleImg));
        circleLabel.setBounds(270, -20, 200, 200);
        panel.add(circleLabel);

        // 설명 텍스트
        JLabel descriptionLabel = new JLabel("<html>삼각형이란 뭘까~?<br>세 개의 변과 세 개의 각을 가지고 있는 도형이야~<br>" +
                "<br>삼각형의 넓이를 구하는 공식은 어떻게 될까? 바로~ <br>밑변 x 높이 x 1/2이야~</html>");

        descriptionLabel.setBounds(250, 150, 350, 150);
        descriptionLabel.setFont(new Font(null, Font.PLAIN, 15));  // 글씨 크기 및 폰트 설정
        descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(descriptionLabel);

        // 뒤로 가기 버튼
        JButton backButton = new JButton("뒤로 가기");
        backButton.setBounds(250, 320, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ShapeSelectionPage(); // ShapeSelectionPage로 돌아가기
            }
        });
        panel.add(backButton);

        frame.setLocationRelativeTo(null);  //화면 중앙 배치
        frame.setVisible(true);  // 프레임(창)을 화면에 표시
    }
}
