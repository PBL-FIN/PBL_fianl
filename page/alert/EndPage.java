package page.alert;

import javax.swing.*;
import page.startPage;
import problem.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndPage extends JFrame {
    private JLabel result;
    private JLabel score;
    private JButton goToMenu;
    private scoreManager scoreManager;
    private lifeManager lifeManager;
    private PageLoadingManager pageLoadingManager;

    public EndPage() {
        setTitle("게임 오버");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("img/end1.jpg"); //
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        scoreManager = new scoreManager();
        lifeManager = new lifeManager();
        pageLoadingManager = new PageLoadingManager();


        //result = new JLabel("수고했어!");
        //result.setFont(new Font("맑은 고딕", Font.BOLD, 50));
        //result.setBounds(100, 100, 600, 100);
        //result.setForeground(Color.WHITE); // 글자색 설정
        //add(result);


        score = new JLabel("최종 점수는 " + scoreManager.getScore() + "점이야~");
        score.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        score.setBounds(100, 250, 600, 100);
        score.setForeground(Color.WHITE); //
        add(score);

        // 메뉴로 가기 버튼
        goToMenu = new JButton("메뉴로");
        styleButton(goToMenu);
        goToMenu.setFont(new Font("맑인 고딕",Font.BOLD,30));
        goToMenu.setBounds(1300, 700, 300, 60);
        goToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new startPage();
                scoreManager.resetScore();
                lifeManager.resetLife();
                pageLoadingManager.resetLoadingCnt();
            }
        });
        add(goToMenu);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("맑은 고딕", Font.PLAIN, 25)); // 폰트 설정
        button.setFocusPainted(false); // 포커스 시 테두리 없애기
        button.setBackground(new Color(175, 243, 126, 255)); // 반투명 흰색 배경
        button.setForeground(new Color(0, 0, 0)); // 글자색 설정
        button.setOpaque(true); // 배경색을 보이게 하려면 true로 설정
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 마우스 커서 변경

    }
}
