package page.alert;

import page.difficulty.normalDifficultyPage;
import problem.PageLoadingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import problem.lifeManager;

public class normalAnswerPage extends JFrame {
    private PageLoadingManager pageLoadingManager;
    private lifeManager lifeManager;
    public normalAnswerPage(normalDifficultyPage normalDifficultyPage, PageLoadingManager pageLoadingManager,
                            lifeManager lifeManager) {
        this.pageLoadingManager = pageLoadingManager;

        JFrame frame = new JFrame("정답 화면");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 이미지 로드
        ImageIcon imageIcon = new ImageIcon("img/pingO.png"); // 이미지 경로 설정
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);

        // 텍스트 레이블 생성
        JLabel label = new JLabel("정답이야!", SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 24)); // 폰트 설정

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(label, BorderLayout.NORTH); // 텍스트를 상단에 배치

        JButton confirmButton = new JButton("확인");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                normalDifficultyPage.dispose();

                pageLoadingManager.addCnt();
                if (pageLoadingManager.getLoadingCnt() >= normalDifficultyPage.getLength() || lifeManager.getLifeCnt() == 0) {
                    new EndPage();
                } else {
                    new normalDifficultyPage(pageLoadingManager, lifeManager);
                }
            }
        });

        panel.add(confirmButton, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
