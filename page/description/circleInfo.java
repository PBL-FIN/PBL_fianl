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
        frame = new JFrame("원 정보");
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

        // 프레임 표시
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new BorderLayout());

        // 상단 라벨 생성
        JLabel titleLabel = new JLabel("원이란? 모든 점이 중심에서 같은 거리에 있는 도형", SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);


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
