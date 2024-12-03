package page;

import page.difficulty.easyQuizPage;
import problem.PageLoadingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hintPage extends JFrame {
    private JButton start;
    private JLabel tip;
    public hintPage() {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        tip = new JLabel("<html>Tip) 캐릭터를 클릭하면 힌트가 나와요~<br>문제를 풀기 어렵다면 클릭하세요!</html>");
        tip.setFont(new Font(null, Font.PLAIN, 50));
        tip.setBounds(200, 400, 1500, 200); // 높이를 늘려 텍스트가 잘리지 않도록 조정


        start = new JButton("게임시작");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PageLoadingManager pageLoadingManager = new PageLoadingManager();
                new easyQuizPage(pageLoadingManager);
            }
        });
        start.setBounds(500, 800, 100, 100);

        add(tip);
        add(start);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
