package page.alert;

import page.difficulty.easyQuizPage;
import problem.PageLoadingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inCorrectAnswerPage extends JFrame {
    private PageLoadingManager pageLoadingManager;

    public inCorrectAnswerPage(String solutionProcess, double correctAnswer, easyQuizPage easyPage, PageLoadingManager pageLoadingManager) {
        this.pageLoadingManager = pageLoadingManager; // pageLoadingManager 초기화

        setTitle("오답");
        setSize(800, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // 이미지 로드
        ImageIcon imageIcon = new ImageIcon("img/hansum.png"); // 이미지 경로 설정
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);

        // 오답 메시지 레이블 생성
        JLabel label = new JLabel("다시 생각해보자! 정답은 " + correctAnswer + "이고 풀이 과정은 " + solutionProcess + "야");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 16)); // 폰트 설정

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // BorderLayout으로 설정
        panel.add(imageLabel, BorderLayout.CENTER); // 이미지 추가
        panel.add(label, BorderLayout.NORTH); // 텍스트를 상단에 배치

        JButton confirmButton = new JButton("확인");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                easyPage.dispose();

                pageLoadingManager.addCnt();
                if (pageLoadingManager.getLoadingCnt() >= easyPage.getProblemLength()) {
                    new EndPage();
                } else {
                    new easyQuizPage(pageLoadingManager);
                }
            }
        });

        panel.add(confirmButton, BorderLayout.SOUTH); // 확인 버튼 추가
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
