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
        frame = new JFrame("삼각형 정보");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 패널 생성 및 추가
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        panel.setBackground(Color.WHITE); // 배경색을 흰색으로 설정

        // 창을 화면 중앙에 위치
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new BorderLayout());

        // 상단 라벨 생성
        JLabel titleLabel = new JLabel("삼각형이란? 세 개의 점과 세 개의 선분으로 이루어진 다각형", SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        // 삼각형 이미지와 공식 설명

        // 하단 뒤로 가기 버튼
        JButton backButton = new JButton("뒤로 가기");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ShapeSelectionPage();
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);
    }
}
