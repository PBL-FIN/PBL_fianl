package page.difficulty;

import page.alert.answerPage;
import page.alert.inCorrectAnswerPage;
import problem.PageLoadingManager;
import problem.scoreManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class easyQuizPage extends JFrame {
    private JLabel scoreLabel;
    private scoreManager scoreManager;
    private double answer;
    private String solutionProcess;
    private Random random;
    private String[] options;
    private String[] shapes = {"사각형", "삼각형"};
    private JLabel shapeLabel;
    private JLabel sizeLabel;
    private PageLoadingManager pageLoadingManager;

    public easyQuizPage(PageLoadingManager pageLoadingManager) {
        this.pageLoadingManager = pageLoadingManager;

        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel difficultyLabel = new JLabel("쉬움");
        difficultyLabel.setBounds(20, 10, 100, 25);
        add(difficultyLabel);
        
        scoreManager = new scoreManager();
        scoreLabel = new JLabel("점수 : " + scoreManager.getScore());
        scoreLabel.setBounds(140, 10, 100, 25);
        add(scoreLabel);

        shapeLabel = new JLabel();
        shapeLabel.setBounds(150, 50, 200, 200);
        add(shapeLabel);

        sizeLabel = new JLabel();
        sizeLabel.setBounds(150, 260, 200, 25);
        add(sizeLabel);
        displayRandomShape(shapeLabel, sizeLabel);

        JLabel questionLabel = new JLabel("이 도형의 넓이는 얼마인가요?");
        questionLabel.setBounds(400, 50, 300, 25);
        add(questionLabel);

        JButton option1 = new JButton(options[0]);
        JButton option2 = new JButton(options[1]);
        JButton option3 = new JButton(options[2]);

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(Double.parseDouble(options[0]));
            }
        });
