package page.alert;

import page.difficulty.normalDifficultyPage;
import problem.PageLoadingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class normalAnswerPage extends JFrame {
    private PageLoadingManager pageLoadingManager;

    public normalAnswerPage(normalDifficultyPage normalDifficultyPage, PageLoadingManager pageLoadingManager) {
        this.pageLoadingManager = pageLoadingManager;

        JFrame frame = new JFrame("정답 화면");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("정답!!", SwingConstants.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        JButton confirmButton = new JButton("확인");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                normalDifficultyPage.dispose();

                pageLoadingManager.addCnt();
                if (pageLoadingManager.getLoadingCnt() >= normalDifficultyPage.getLength()) {
                    new EndPage();
                } else {
                    new normalDifficultyPage(pageLoadingManager);
                }
            }
        });

        panel.add(confirmButton, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
