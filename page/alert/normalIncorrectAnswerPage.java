package page.alert;

import page.difficulty.normalDifficultyPage;
import problem.PageLoadingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class normalIncorrectAnswerPage extends JFrame {
    private PageLoadingManager pageLoadingManager;
    public normalIncorrectAnswerPage(String solutionProcess, double correctAnswer, normalDifficultyPage normalDifficultyPage, PageLoadingManager pageLoadingManager) {
        setTitle("오답 화면");
        setSize(800, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel("틀렸습니다. 정답은: " + correctAnswer + "풀이 과정: " + solutionProcess);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        panel.add(label);

        JButton confirmButton = new JButton("확인");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                normalDifficultyPage.dispose();

                pageLoadingManager.addCnt();
                if (pageLoadingManager.getLoadingCnt() > normalDifficultyPage.getLength()) {
                    new EndPage();
                } else {
                    new normalDifficultyPage(pageLoadingManager);
                }
            }
        });

        panel.add(confirmButton, BorderLayout.SOUTH);
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
