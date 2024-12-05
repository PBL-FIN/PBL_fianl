package page.difficulty;

import page.alert.normalIncorrectAnswerPage;
import page.alert.normalAnswerPage;
import problem.PageLoadingManager;
import problem.scoreManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import problem.lifeManager;

public class normalDifficultyPage extends JFrame {
    public JLabel shapeLabel;
    public JLabel sizeLabel;
    private scoreManager scoreManager;
    private JLabel scoreLabel;
    private JLabel h1;
    private JLabel h2;
    private JLabel h3;
    private String[] shapes = {"사각형", "삼각형", "원", "삼각형2", "사각형2"};
    private double answer;
    private String solutionProcess;
    private PageLoadingManager pageLoadingManager;
    private lifeManager lifeManager;
    public normalDifficultyPage(PageLoadingManager pageLoadingManager, lifeManager lifeManager) {
        this.pageLoadingManager = pageLoadingManager;
        this.lifeManager = lifeManager;
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel difficultyLabel = new JLabel("난이도 : 보통");
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
        sizeLabel.setBounds(150, 260, 500, 25);
        add(sizeLabel);

        h1 = new JLabel();
        h1.setBounds(230, 0, 60, 60);
        h2 = new JLabel();
        h2.setBounds(280, 0, 60, 60);
        h3 = new JLabel();
        h3.setBounds(330, 0, 60, 60);

        ImageIcon heartIcon = new ImageIcon("img/heart.jpg");
        h1.setIcon(heartIcon);
        h2.setIcon(heartIcon);
        h3.setIcon(heartIcon);
        if (lifeManager.getLifeCnt() == 2) {
            h3.setVisible(false);
        } else if (lifeManager.getLifeCnt() == 1) {
            h3.setVisible(false);
            h2.setVisible(false);
        } else if (lifeManager.getLifeCnt() == 0) {
            h3.setVisible(false);
            h2.setVisible(false);
            h1.setVisible(false);
        }
        add(h1);
        add(h2);
        add(h3);

        displayRandomShape(shapeLabel, sizeLabel);

        JLabel answerLabel = new JLabel("정답: ");
        answerLabel.setBounds(300, 300, 200, 25);
        add(answerLabel);

        JTextField jTextField = new JTextField(10);
        jTextField.setBounds(400, 300, 100, 25);
        add(jTextField);

        JButton submitButton = new JButton("제출");
        submitButton.setBounds(520, 300, 80, 25);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(Double.parseDouble(jTextField.getText()));
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void displayRandomShape(JLabel shapeLabel, JLabel sizeLabel) {
        Random random = new Random();
        String imagePath = "";
        String sizeText = "";
        int randomIndex = random.nextInt(shapes.length);
        String selectedShape = shapes[randomIndex];

        switch (selectedShape) {
            case "삼각형":
                imagePath = "img/triangle 2.png";
                int base = (random.nextInt(5) + 1) * 2;
                int height = (random.nextInt(5) + 1) * 2;
                sizeText = "삼각형의 넓이를 구하시오. 밑변 a: " + base + ", 높이 h: " + height;
                answer = (double) (base * height) / 2;
                solutionProcess = "삼각형 넓이 = (밑변 x 높이) ÷ 2";
                break;

            case "삼각형2":
                imagePath = "img/triangle 3.png";
                sizeText = "삼각형의 높이(h)를 구하시오. 넓이 :9";
                answer = 6;
                solutionProcess = "삼각형 넓이 = (밑변 x 높이) ÷ 2";
                break;

            case "사각형":
                imagePath = "img/rectangle 2.png";
                int side1 = random.nextInt(4) + 1;
                int side2 = random.nextInt(4) + 1;
                sizeText = "사각형의 넓이를 구하시오. 가로 a: " + side1 + ", 세로 b: " + side2;
                answer = side1 * side2;
                solutionProcess = "사각형 넓이 = (가로 x 세로)";
                break;

            case "사각형2":
                imagePath = "img/rectangle 3.png";
                sizeText = "사각형의 세로(b)를 구하시오. 넓이 : 35";
                answer = 7;
                solutionProcess = "사각형 넓이 = (가로 x 세로)";
                break;

            case "원":
                imagePath = "img/one 2.png";
                int r = random.nextInt(10) + 1;
                sizeText = "원의 넓이를 구하고 소수 둘째자리에서 반올림하시오. 반지름 r: " + r;
                answer = Math.round((r * r * 3.14) * 100.0) / 100.0;
                solutionProcess = "원 넓이 = (3.14 * 반지름 x 반지름)";
                break;
        }
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        shapeLabel.setIcon(new ImageIcon(scaledImage));
        sizeLabel.setText(sizeText);
    }

    public int getLength() {
        return shapes.length;
    }

    public void checkAnswer(double userAnswer) {
        if (Math.abs(userAnswer - answer) < 0.01) {
            scoreManager.addScore(20);
            new normalAnswerPage(this, pageLoadingManager, lifeManager);
        } else {
            System.out.println(lifeManager.getLifeCnt());
            new normalIncorrectAnswerPage(solutionProcess, answer, this, pageLoadingManager, lifeManager);
        }
    }
}
