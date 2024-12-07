package page.difficulty;

import page.alert.answerPage;
import page.alert.inCorrectAnswerPage;
import problem.PageLoadingManager;
import problem.scoreManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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
    private JLabel circleLabel;
    private PageLoadingManager pageLoadingManager;
    private JButton hint;
    private JLabel hintClick;
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

        circleLabel = new JLabel("원의 넓이를 구하고 소수 둘째자리에서 반올림해봐.");
        circleLabel.setBounds(300,300, 1000, 100);
        circleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));

        hintClick = new JLabel("힌트가 필요하면 날 클릭해");
        hintClick.setBounds(1200, 600, 500, 50);
        add(hintClick);

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
        sizeLabel.setBounds(750, 550, 1000, 80);
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
        opt건
        switch (selectedShape) {
            case "삼각형":
                imagePath = "img/triangle 2.png";
                int base = (random.nextInt(4) + 1);
                int height = (random.nextInt(4) + 1);
                sizeText = "밑변: " + base + ", 높이: " + height;
                answer = (double) (base * height) / 2;
                solutionProcess = "넓이 = (밑변 " + base + " * 높이 " + height + ") / 2";
                hintMessage = "삼각형 넓이는 ( □ x □ ) / 2 야~ ";
                break;
            case "삼각형_2":
                imagePath = "img/triangle 2.png";
                int base_2 = (random.nextInt(4) + 1);
                int height_2 = (random.nextInt(4) + 1);
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
                sizeText = "반지름: " + r;
                answer = Math.round((r * r * 3.14) * 100.0) / 100.0;
                solutionProcess = "원 넓이 = (3.14 * 반지름 x 반지름)";
                hintMessage = "원의 넓이는 (반지름 x 반지름 x 3.14) 야~ ";
                add(circleLabel);
                break;
        }

        ImageIcon originalIcon = new ImageIcon(imagePath);
        // 이미지를 자연스럽게 늘려줌
        Image scaledImage = originalIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        //늘려진 이미지를 추가
        shapeLabel.setIcon(new ImageIcon(scaledImage));
        sizeLabel.setText(sizeText);

        generateOptions(selectedShape);
    }
    // 버튼을 생성하는 메소드
    public void generateOptions(String selectedShape) {
        options = new String[3]; //String type 을 저장하는 길이 3인 리스트 생성
        int correctIndex = random.nextInt(3); // 정답이 위치할 인덱스를 무작위로 선택
        options[correctIndex] = String.valueOf(answer); // 정답 값을 해당 인덱스에 설정

        // 중복 방지를 위해 HashSet 사용
        HashSet<String> usedOptions = new HashSet<>();
        usedOptions.add(options[correctIndex]); // 정답 추가
        // 3개의 옵션 중 정답을 제외한 나머지 2개의 옵션 생성하는 로직
        for (int i = 0; i < options.length; i++) {
            if (i != correctIndex) { // 정답 인덱스가 아닐경우
                String generatedOption = ""; // 새로 생성할 옵션 값 초기화
                // 새로운 값이 중복되지 않을 때까지 반복
                while (generatedOption.isEmpty() || usedOptions.contains(generatedOption)) {
                    // 원의 경우
                    if ("원".equals(selectedShape)) {
                        double randomValue = (answer + (random.nextInt(5) + 1) + random.nextInt(5) + 2);
                        generatedOption = String.format("%.2f", randomValue);
                    }
                     // 삼각형/사각형의 경우
                    else {    
                        double randomValue = ((answer + random.nextInt(5) + 1));
                        generatedOption = String.valueOf(randomValue);
                    }
                }
                // 중복되지 않은 값을 옵션에 추가하고 HashSet에도 추가
                options[i] = generatedOption;
                usedOptions.add(generatedOption);
            }
        }
    }

    public void checkAnswer(double answerValue) {
        // answerValue는 반올림 값이여서 기존 값과 차이가 있음 그 차이값을 최대 0.01로 잡음
        if ((answerValue - answer) < 0.01) {
            // score에 20을 추가
            scoreManager.addScore(20);
            new answerPage(this, pageLoadingManager);
        } else {
            //this란 현재 패이지를 말함함
            new inCorrectAnswerPage(solutionProcess, answer, this, pageLoadingManager);
        }
    }

    // AdapterClass 사용
    // 마우스 클릭시 이벤트 발생
    public class HintButtonAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            showHint();
        }
    }
    // 힌트 출력하는 메소드
    public void showHint() {
        JOptionPane.showMessageDialog(this, hintMessage, "힌트핑", JOptionPane.INFORMATION_MESSAGE);
    }
}
