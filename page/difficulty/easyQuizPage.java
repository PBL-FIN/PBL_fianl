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
        sizeLabel.setBounds(150, 260, 500, 25);
        add(sizeLabel);
        displayRandomShape(shapeLabel, sizeLabel);

        JLabel questionLabel = new JLabel("이 도형의 넓이는 얼마인가요?");
        questionLabel.setBounds(400, 50, 300, 25);
        add(questionLabel);

        JButton option1 = new JButton(options[0]);
        JButton option2 = new JButton(options[1]);
        JButton option3 = new JButton(options[2]);

        option1.addActionListener(e -> checkAnswer(Double.parseDouble(options[0])));
        option2.addActionListener(e -> checkAnswer(Double.parseDouble(options[1])));
        option3.addActionListener(e -> checkAnswer(Double.parseDouble(options[2])));

        option1.setBounds(300, 150, 80, 40);
        option2.setBounds(400, 150, 80, 40);
        option3.setBounds(500, 150, 80, 40);

        add(option1);
        add(option2);
        add(option3);

        hint = new JButton(new ImageIcon("img/ping.png"));
        hint.setBounds(1000, 150, 300, 300);
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
                imagePath = "img//triangle.png";
                int base = (random.nextInt(4) + 1) * 2;
                int height = (random.nextInt(4) + 1) * 2;
                sizeText = "밑변: " + base + ", 높이: " + height;
                answer = (double) (base * height) / 2;
                solutionProcess = "넓이 = (밑변 " + base + " * 높이 " + height + ") / 2";
                hintMessage = "삼각형 넓이는 ( □ x □ ) / 2 야~ ";
                break;
            case "삼각형_2":
                imagePath = "img//triangle 2.png";
                int base_2 = (random.nextInt(4) + 1) * 2;
                int height_2 = (random.nextInt(4) + 1) * 2;
                sizeText = "밑변: " + base_2 + ", 높이: " + height_2;
                answer = (double) (base_2 * height_2) / 2;
                solutionProcess = "넓이 = (밑변 " + base_2 + " * 높이 " + height_2 + ") / 2";
                hintMessage = "삼각형 넓이는 ( 밑변 x 높이 ) / 2 야~ ";
                break;
            case "사각형":
                imagePath = "img//rectangle.png";
                int side1 = random.nextInt(4) + 1;
                int side2 = random.nextInt(4) + 1;
                sizeText = "한변: " + side1 + ", 한변: " + side2;
                answer = side1 * side2;
                solutionProcess = "넓이 = (한변 " + side1 + " * 한변 " + side2 + ")";
                hintMessage = "사각형의 넓이는 ( 밑변 x 높이 ) 야~ ";
                break;
            case "사각형_2":
                imagePath = "img//rectangle 3.png";
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
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
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


