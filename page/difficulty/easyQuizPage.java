package page.difficulty;

import page.alert.answerPage;
import page.alert.inCorrectAnswerPage;
import problem.PageLoadingManager;
import problem.scoreManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class easyQuizPage extends JFrame {
    private JLabel scoreLabel;
    private scoreManager scoreManager;
    private double answer;
    private String solutionProcess;
    private Random random;
    private String[] options;
    private String[] shapes = {"사각형", "사각형_2", "삼각형", "삼각형_2", "원"};
    private JLabel shapeLabel;
    private JLabel sizeLabel;
    private PageLoadingManager pageLoadingManager;
    private JButton hint;
    private String hintMessage;


    public easyQuizPage(PageLoadingManager pageLoadingManager) {
        this.pageLoadingManager = pageLoadingManager;

        setTitle("쉬움 난이도");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("img/bg 6.png"); // 배경 이미지 경로 설정
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
        sizeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30)); // 폰트 크기 설정
        sizeLabel.setBounds(750, 550, 700, 40);
        add(sizeLabel);
        displayRandomShape(shapeLabel, sizeLabel);

        JLabel questionLabel = new JLabel("이 도형의 넓이는 얼마일까?");
        questionLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50)); // 폰트 크기 설정
        questionLabel.setBounds(560, 120, 700, 100);
        add(questionLabel);

        JButton option1 = new JButton(options[0]);
        JButton option2 = new JButton(options[1]);
        JButton option3 = new JButton(options[2]);

        option1.addActionListener(e -> checkAnswer(Double.parseDouble(options[0])));
        option2.addActionListener(e -> checkAnswer(Double.parseDouble(options[1])));
        option3.addActionListener(e -> checkAnswer(Double.parseDouble(options[2])));

        option1.setBounds(600, 650, 130, 60);
        option1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        option2.setBounds(800, 650, 130, 60);
        option2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        option3.setBounds(1000, 650, 130, 60);
        option3.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        add(option1);
        add(option2);
        add(option3);

        hint = new JButton(new ImageIcon("img/ping5.png"));
        hint.setBounds(1100, 280, 260, 260);
        hint.setBorderPainted(false);

        // 어댑터 클래스를 사용하여 힌트 버튼의 동작 정의
        hint.addMouseListener(new HintButtonAdapter());
        add(hint);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public int getProblemLength() {
        return shapes.length;
    }

    public void displayRandomShape(JLabel shapeLabel, JLabel sizeLabel) {
        random = new Random();
        String imagePath = "";
        String sizeText = "";
        String selectedShape = shapes[random.nextInt(shapes.length)];

        switch (selectedShape) {
            case "삼각형":
                imagePath = "img/triangle 2.png";
                int base = (random.nextInt(4) + 1) * 2;
                int height = (random.nextInt(4) + 1) * 2;
                sizeText = "밑변: " + base + ", 높이: " + height;
                answer = (double) (base * height) / 2;
                solutionProcess = "넓이 = (밑변 " + base + " * 높이 " + height + ") / 2";
                hintMessage = "삼각형 넓이는 ( □ x □ ) / 2 야~ ";
                break;
            case "삼각형_2":
                imagePath = "img/triangle 2.png";
                int base_2 = (random.nextInt(4) + 1) * 2;
                int height_2 = (random.nextInt(4) + 1) * 2;
                sizeText = "밑변: " + base_2 + ", 높이: " + height_2;
                answer = (double) (base_2 * height_2) / 2;
                solutionProcess = "넓이 = (밑변 " + base_2 + " * 높이 " + height_2 + ") / 2";
                hintMessage = "삼각형 넓이는 ( 밑변 x 높이 ) / 2 야~ ";
                break;
            case "사각형":
                imagePath = "img/rectangle.png";
                int side1 = random.nextInt(4) + 1;
                int side2 = random.nextInt(4) + 1;
                sizeText = "한변: " + side1 + ", 한변: " + side2;
                answer = side1 * side2;
                solutionProcess = "넓이 = (한변 " + side1 + " * 한변 " + side2 + ")";
                hintMessage = "사각형의 넓이는 ( 밑변 x 높이 ) 야~ ";
                break;
            case "사각형_2":
                imagePath = "img/rectangle.png";
                int side3 = random.nextInt(4) + 1;
                int side4 = random.nextInt(4) + 1;
                sizeText = "한변: " + side3 + ", 한변: " + side4;
                answer = side3 * side4;
                solutionProcess = "넓이 = (한변 " + side3 + " * 한변 " + side4 + ")";
                hintMessage = "사각형의 넓이는 ( 밑변 x 높이 ) 야~ ";
                break;
            case "원":
                imagePath = "img/one 2.png";
                int r = random.nextInt(3) + 1;
                sizeText = "원의 넓이를 구하고 소수 둘째자리에서 반올림하세요. 반지름: " + r;
                answer = Math.round((r * r * 3.14) * 100.0) / 100.0;
                solutionProcess = "원 넓이 = (3.14 * 반지름 x 반지름)";
                hintMessage = "원의 넓이는 (반지름 x 반지름 x 3.14) 야~ ";
                break;
        }

        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        shapeLabel.setIcon(new ImageIcon(scaledImage));
        sizeLabel.setText(sizeText);

        generateOptions(selectedShape);
    }

    public void generateOptions(String selectedShape) {
        options = new String[3];
        int correctIndex = random.nextInt(3);
        options[correctIndex] = String.valueOf(answer);
        for (int i = 0; i < options.length; i++) {
            if (i != correctIndex) {
                options[i] = String.valueOf(answer + random.nextInt(5) + 2);
            }
        }
    }

    public void checkAnswer(double answerValue) {
        if (answer == answerValue) {
            scoreManager.addScore(20);
            new answerPage(this, pageLoadingManager);
        } else {
            new inCorrectAnswerPage(solutionProcess, answer, this, pageLoadingManager);
        }
    }

    // AdapterClass 사용
    public class HintButtonAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            showHint();
        }
    }

    public void showHint() {
        JOptionPane.showMessageDialog(this, hintMessage, "힌트핑", JOptionPane.INFORMATION_MESSAGE);
    }
}


