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
                easyPage.dispose();

                pageLoadingManager.addCnt();
                if (pageLoadingManager.getLoadingCnt() >= 2) {
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
