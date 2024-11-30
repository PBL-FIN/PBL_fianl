package page;

import page.description.*;
import page.difficulty.difficultyPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeSelectionPage {
    private JFrame frame;

    public ShapeSelectionPage() {
        // 프레임 생성
        frame = new JFrame("도형 선택 화면");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 패널 생성 및 추가
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // 창을 화면 중앙에 위치
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // 프레임 표시
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new BorderLayout());

        // 라벨 생성
        JLabel instructionLabel = new JLabel("면적 구하는 공식을 모르는 도형을 클릭하세요", SwingConstants.CENTER);
        // 폰트 생성 자리

        panel.add(instructionLabel, BorderLayout.NORTH);

        // 도형 버튼 생성
        JPanel shapePanel = new JPanel();
        shapePanel.setLayout(new FlowLayout());

        JButton triangleButton = new JButton("▲");
        JButton squareButton = new JButton("■");
        JButton circleButton = new JButton("●");

        triangleButton.setFocusPainted(false);
        squareButton.setFocusPainted(false);
        circleButton.setFocusPainted(false);


        // 삼각형 버튼 클릭 이벤트 - TriangleInfoScreen으로 전환
        triangleButton.addActionListener(e -> {
            frame.dispose();
            new triangleInfo();
        });

        // 사각형 버튼 클릭 이벤트 - SquareInfoScreen으로 전환
        squareButton.addActionListener(e -> {
            frame.dispose();
            new squareInfo();
        });

        // 원 버튼 클릭 이벤트 - circleInfoScreen으로 전환
        circleButton.addActionListener(e -> {
            frame.dispose();
            new circleInfo();
        });

        // 다른 도형 버튼은 예시로 유지
        shapePanel.add(triangleButton);
        shapePanel.add(squareButton);
        shapePanel.add(circleButton);

        panel.add(shapePanel, BorderLayout.CENTER);

        // "다음으로" 버튼 생성
        JButton nextButton = new JButton("다음으로");
        nextButton.setFocusPainted(false);
        panel.add(nextButton, BorderLayout.SOUTH);

        // "다음으로" 버튼 클릭 이벤트 - GameDifficultyScreen으로 전환
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new difficultyPage();
            }
        });
    }
}
