package page.difficulty;

import page.hintPage;
import problem.PageLoadingManager;
import problem.lifeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class difficultyPage extends JFrame {
    private JLabel difficulty;
    private JButton normal;
    private JButton easy;
    private PageLoadingManager pageLoadingManager = new PageLoadingManager();
    private lifeManager lifeManager = new lifeManager();

    public difficultyPage() {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon backgroundIcon = new ImageIcon("img/bg 4-tset.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(-90, -70, 1980, 1080);
        add(backgroundLabel);

        // 보통 버튼 생성
        normal = new JButton("보통");
        styleButton(normal);
        normal.setBounds(630, 660, 400, 70);
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDifficulty = e.getActionCommand();
                int response = JOptionPane.showConfirmDialog(null, selectedDifficulty + "으로 가볼까?", "난이도 선택", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    new normalDifficultyPage(pageLoadingManager, lifeManager);
                }
            }
        });
        backgroundLabel.add(normal); // 배경에 추가

        // 쉬움 버튼 생성
        easy = new JButton("쉬움");
        styleButton(easy);
        easy.setBounds(630, 550, 400, 70);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDifficulty = e.getActionCommand();
                int response = JOptionPane.showConfirmDialog(null, selectedDifficulty + "으로 가볼까?", "난이도 선택", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    new hintPage();
                }
            }
        });
        backgroundLabel.add(easy); // 배경에 추가

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 버튼 스타일링 메서드
    private void styleButton(JButton button) {
        button.setFont(new Font("맑은 고딕", Font.PLAIN, 30)); // 폰트 설정
        button.setFocusPainted(false); // 포커스 시 테두리 없애기
        button.setBackground(new Color(255, 255, 255, 255)); // 반투명 흰색 배경
        button.setForeground(new Color(0, 0, 0)); // 글자색 설정
        button.setOpaque(true); // 배경색을 보이게 하려면 true로 설정
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 변경
    }

    public static void main(String[] args) {
        new difficultyPage();
    }

}