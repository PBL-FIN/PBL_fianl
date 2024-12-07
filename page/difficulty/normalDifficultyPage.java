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
    private JLabel info;
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

        setTitle("보통 난이도");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("img/bg 6-2.png"); // 배경 이미지 경로 설정
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel); // JFrame의 콘텐츠 팬을 배경 패널로 설정


        scoreManager = new scoreManager();
        scoreLabel = new JLabel("점수 : " + scoreManager.getScore());
        scoreLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30)); // 폰트 크기 설정
        scoreLabel.setBounds(20, 10, 200, 40);
        add(scoreLabel);

        shapeLabel = new JLabel();
        shapeLabel.setBounds(730, 220, 300, 300);
        add(shapeLabel);

        sizeLabel = new JLabel();
        sizeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40)); // 폰트 크기 설정
        sizeLabel.setBounds(500, 140, 1000, 70);
        add(sizeLabel);

        h1 = new JLabel();
        h1.setBounds(260, 0, 60, 60);
        h2 = new JLabel();
        h2.setBounds(310, 0, 60, 60);
        h3 = new JLabel();
        h3.setBounds(360, 0, 60, 60);

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

        JLabel difficultyLabel = new JLabel("생명 : ");
        difficultyLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
        difficultyLabel.setBounds(170, 12, 100, 35);
        add(difficultyLabel);

        JLabel answerLabel = new JLabel("정답 :");
        answerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        answerLabel.setBounds(600, 575, 200, 35);
        add(answerLabel);

        JTextField jTextField = new JTextField(10);
        jTextField.setFont(new Font("맑은 고딕", Font.BOLD, 25)); // 입력창 글씨 크기 설정
        jTextField.setBounds(700, 580, 200, 35);
        add(jTextField);

        JButton submitButton = new JButton("제출");
        submitButton.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        submitButton.setBounds(950, 580, 140, 35);
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
                sizeText = "삼각형의 넓이를 구하시오.";
                info = new JLabel("밑변 a: " + base + ", 높이 h: " + height);
                info.setBounds(500,500,1000,50);
                add(info);
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
                sizeText = "사각형의 넓이를 구하시오.";
                info = new JLabel("가로 a: " + side1 + ", 세로 b: " + side2);
                info.setBounds(500,500,1000,50);
                add(info);
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
                sizeText = "원의 넓이를 구하고 소수 둘째자리에서 반올림하시오.";
                info = new JLabel("반지름 r: " + r);
                info.setBounds(500,500,1000,50);
                add(info);
                answer = Math.round((r * r * 3.14) * 100.0) / 100.0;
                solutionProcess = "원 넓이 = (3.14 * 반지름 x 반지름)";
                break;
        }

        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
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
