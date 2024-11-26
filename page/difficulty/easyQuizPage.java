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
