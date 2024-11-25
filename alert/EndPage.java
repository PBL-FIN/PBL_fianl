package page.alert;

import javax.swing.*;

import page.startPage;
import problem.scoreManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndPage extends JFrame{
    private JLabel result;
    private JLabel score;
    private JButton restart;
    private JButton goToMenu;
    private scoreManager scoreManager;
    public EndPage() {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        scoreManager = new scoreManager();
        result = new JLabel("고생했어요");
        result.setBounds(100,100,100,100);
        add(result);
        score = new JLabel(scoreManager.getScore() + "점 입니다");
        score.setBounds(200,200,200,200);
        add(score);
        goToMenu = new JButton("메뉴로");
        goToMenu.setBounds(300,300,300,300);
        goToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new startPage();
                scoreManager.resetScore();
            }
        });
        add(goToMenu);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
