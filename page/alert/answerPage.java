package page.alert;

import page.difficulty.easyQuizPage;
import problem.PageLoadingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class answerPage extends JFrame {
    private PageLoadingManager pageLoadingManager;

    public answerPage(easyQuizPage easyPage, PageLoadingManager pageLoadingManager) {
        this.pageLoadingManager = pageLoadingManager;

        JFrame frame = new JFrame("정답 화면");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 이미지 로드
        ImageIcon imageIcon = new ImageIcon("img/pingO.png"); // 이미지 경로 설정
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);

        // 텍스트 레이블 생성
        JLabel label = new JLabel("정답이야!!", SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.PLAIN, 16)); // 폰트 설정

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.CENTER); // 이미지 추가
        panel.add(label, BorderLayout.NORTH); // 텍스트를 상단에 배치

        JButton confirmButton = new JButton("확인");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                easyPage.dispose();

                pageLoadingManager.addCnt();
                if (pageLoadingManager.getLoadingCnt() >= easyPage.getProblemLength()) {
                    new EndPage();
                } else {
                    new easyQuizPage(pageLoadingManager);
                }
            }
        });

        panel.add(confirmButton, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
