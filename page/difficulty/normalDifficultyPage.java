package page.difficulty;

import page.alert.EndPage;
import problem.PageLoadingManager;
import problem.scoreManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class normalDifficultyPage extends JFrame {
    private scoreManager scoreManager;
    private JLabel scoreLabel;
    private JLabel shapeLabel;
    private JLabel sizeLabel;
    private String[] shapes = {"사각형", "삼각형", "원"};
    private double answer;
    private String solutionProcess;
    private int questionCount = 0;

    public normalDifficultyPage(PageLoadingManager pageLoadingManager) {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

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
        sizeLabel.setBounds(150, 260, 350, 25);
        add(sizeLabel);

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
                try {
                    double userAnswer = Double.parseDouble(jTextField.getText());
                    if (Math.abs(userAnswer - answer) < 0.01) {
                        JOptionPane.showMessageDialog(null, "정답입니다!");
                        JOptionPane.showMessageDialog(null, solutionProcess);
                        scoreManager.addScore(20);
                        scoreLabel.setText("점수 : " + scoreManager.getScore());
                        questionCount++;

                        if (questionCount < 6) {
                            displayRandomShape(shapeLabel, sizeLabel);
                            jTextField.setText("");

                        } else {
                            dispose();
                            new EndPage();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "틀렸습니다. 다시 시도하세요.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "유효한 숫자를 입력하세요.");
                }
            }
        });

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
                imagePath = "img/triangle 2.png";
                int base = (random.nextInt(5) + 1) * 2;
                int height = (random.nextInt(5) + 1) * 2;
                sizeText = "삼각형의 넓이를 구하시오. a: " + base + ", h: " + height;
                answer = (double) (base * height) / 2;
                solutionProcess = "삼각형 넓이 = (a * h) / 2";
                break;

            case "사각형":
                imagePath = "img/rectangle 2.png";
                int side1 = random.nextInt(4) + 1;
                int side2 = random.nextInt(4) + 1;
                sizeText = "사각형의 넓이를 구하시오. a: " + side1 + ", b: " + side2;
                answer = side1 * side2;
                solutionProcess = "사각형 넓이 = (a * b)";
                break;

            case "원":
                imagePath = "img/one 2.png";
                int r = random.nextInt(10) + 1; //
                sizeText = "원의 넓이를 구하고 소수 둘째자리에서 반올림하시오. r: " + r;
                answer = Math.round((r * r * 3.14) * 100.0) / 100.0;
                solutionProcess = "원 넓이 = (π * r ^ 2)";
                break;

        }
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        shapeLabel.setIcon(new ImageIcon(scaledImage));
        sizeLabel.setText(sizeText);
    }
}
