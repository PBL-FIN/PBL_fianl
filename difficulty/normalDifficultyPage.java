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

        JLabel answerLabel = new JLabel("정답: ");
        answerLabel.setBounds(300,300,200,300);
        JTextField jTextField = new JTextField(10);
        jTextField.setBounds(600,600,100,100);
        add(answerLabel);
        add(jTextField);

        setLocationRelativeTo(null);
        setVisible(true);
    }
        public void displayRandomShape(JLabel shapeLabel, JLabel sizeLabel) {
        Random random = new Random();
        String imagePath = "";
        String sizeText = "";
        String selectedShape = shapes[random.nextInt(shapes.length)];

        switch (selectedShape) {
            case "삼각형":
                imagePath = "src//img//triangle.png";
                int base = (random.nextInt(4) + 1) * 2;
                int height = (random.nextInt(4) + 1) * 2;
                sizeText = "밑변: " + base + ", 높이: " + height;
                answer = (double) (base * height) / 2;
                solutionProcess = "넓이 = (밑변 " + base + " * 높이 " + height + ") / 2";
                break;
            case "사각형":
                imagePath = "src//img//rectangle.png";
                int side1 = random.nextInt(4) + 1;
                int side2 = random.nextInt(4) + 1;
                sizeText = "한변: " + side1 + ", 한변: " + side2;
                answer = side1 * side2;
                solutionProcess = "넓이 = (한변 " + side1 + " * 한변 " + side2 + ")";
                break;
            }
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        shapeLabel.setIcon(new ImageIcon(scaledImage));
        sizeLabel.setText(sizeText);
    }
}
