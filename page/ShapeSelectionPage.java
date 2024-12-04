package page;

import page.description.*;
import page.difficulty.difficultyPage;

import javax.swing.*;
import java.awt.*;

public class ShapeSelectionPage {
    private JFrame frame;

    public ShapeSelectionPage() {
        // 프레임 생성
        frame = new JFrame("도형 선택 화면");
        frame.setSize(800, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 패널 생성
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        panel.setLayout(null);

        // 이미지 라벨 생성 (왼쪽)
        ImageIcon icon = new ImageIcon("img/ping4.png");
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(20, 50, 300, 300); // 이미지 크기 및 위치 조정
        panel.add(imageLabel);

        // 텍스트 라벨 생성 (오른쪽 위)
        JLabel instructionLabel = new JLabel("면적 구하는 공식을 모르는 도형을 클릭해봐~");
        instructionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        instructionLabel.setFont(new Font(null, Font.PLAIN, 21)); // 폰트 설정 (null, plain, 크기 20)
        instructionLabel.setBounds(350, 30, 600, 50); // 위치 및 크기 조정
        panel.add(instructionLabel);


        // 도형 버튼 생성
        JButton triangleButton = new JButton("▲");
        JButton squareButton = new JButton("■");
        JButton circleButton = new JButton("●");

        Font buttonFont = new Font(null, Font.PLAIN, 20); // null, plain, 크기 20
        triangleButton.setFont(buttonFont);
        squareButton.setFont(buttonFont);
        circleButton.setFont(buttonFont);

        triangleButton.setFocusPainted(false);
        squareButton.setFocusPainted(false);
        circleButton.setFocusPainted(false);

        triangleButton.setBounds(400, 100, 80, 50);
        squareButton.setBounds(500, 100, 80, 50);
        circleButton.setBounds(600, 100, 80, 50);

        panel.add(triangleButton);
        panel.add(squareButton);
        panel.add(circleButton);

        // "다음으로" 버튼 생성 (하단 중앙)
        JButton nextButton = new JButton("다음으로");
        nextButton.setFocusPainted(false);
        nextButton.setBounds(600, 350, 150, 50);
        panel.add(nextButton);

        // 삼각형 버튼 클릭 이벤트
        triangleButton.addActionListener(e -> {
            frame.dispose();
            new triangleInfo();
        });

        // 사각형 버튼 클릭 이벤트
        squareButton.addActionListener(e -> {
            frame.dispose();
            new squareInfo();
        });

        // 원 버튼 클릭 이벤트
        circleButton.addActionListener(e -> {
            frame.dispose();
            new circleInfo();
        });

        // "다음으로" 버튼 클릭 이벤트
        nextButton.addActionListener(e -> {
            frame.dispose();
            new difficultyPage();
        });

        // 창을 화면 중앙에 위치
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
