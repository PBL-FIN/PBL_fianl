package page.difficulty;

import problem.PageLoadingManager;
import problem.scoreManager;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class normalDifficultyPage extends JFrame {
    private scoreManager scoreManager;
    private JLabel scoreLabel;
    private JLabel shapeLabel;
    private JLabel sizeLabel;
    private String[] shapes = {"사각형", "삼각형"};
    private double answer;
    private String solutionProcess;
    
    public normalDifficultyPage(PageLoadingManager pageLoadingManager) {

        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel difficultyLabel = new JLabel("보통");
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
