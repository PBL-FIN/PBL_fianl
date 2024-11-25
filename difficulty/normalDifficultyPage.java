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
