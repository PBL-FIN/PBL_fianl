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
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(Double.parseDouble(options[1]));
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(Double.parseDouble(options[2]));
            }
        });
       
        option1.setBounds(300, 150, 80, 40);
        option2.setBounds(400, 150, 80, 40);
        option3.setBounds(500, 150, 80, 40);

        add(option1);
        add(option2);
        add(option3);
        
        hint = new JButton(new ImageIcon("img/ping.png"));
        hint.setBounds(1000, 150, 300, 300);
        hint.setBorderPainted(false);
        hint.addActionListener(e -> showHint());
        add(hint);

        setLocationRelativeTo(null);
        setVisible(true);
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
           
            case "사각형":
                imagePath = "img//rectangle.png";
                int side1 = random.nextInt(4) + 1;
                int side2 = random.nextInt(4) + 1;
                sizeText = "한변: " + side1 + ", 한변: " + side2;
                answer = side1 * side2;
                solutionProcess = "넓이 = (한변 " + side1 + " * 한변 " + side2 + ")";
                hintMessage = "사각형의 넓이는 ( □ x □ ) 야~ ";
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
            scoreManager.addScore(10);
            new answerPage(this, pageLoadingManager);
        } else {
            new inCorrectAnswerPage(solutionProcess, answer, this, pageLoadingManager);
        }
    }

    public void showHint() {
        JOptionPane.showMessageDialog(this, hintMessage, "힌트핑", JOptionPane.INFORMATION_MESSAGE);
    }
}




