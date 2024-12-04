package page.difficulty;

import page.hintPage;
import problem.PageLoadingManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class difficultyPage extends JFrame {
    private JLabel difficulty;
    private JButton normal;
    private JButton easy;
    private PageLoadingManager pageLoadingManager = new PageLoadingManager();

    public difficultyPage() {

        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon icon = new ImageIcon("img/ping2.png");
        Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(1000, 50, 500, 500);
        add(imageLabel);

        difficulty = new JLabel("게임 난이도를 골라보소");
        normal = new JButton("보통");
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDifficulty = e.getActionCommand();
                int response = JOptionPane.showConfirmDialog(null, selectedDifficulty + "으로 결정하겠습니까?", "난이도 선택", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    new normalDifficultyPage(pageLoadingManager);
                }
            }
        });

        easy = new JButton("쉬움");
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDifficulty = e.getActionCommand();
                int response = JOptionPane.showConfirmDialog(null, selectedDifficulty + "으로 결정하겠습니까?", "난이도 선택", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    dispose();
                    new hintPage();
                }
            }
        });

        difficulty.setFont(new Font(null, Font.PLAIN, 50));
        difficulty.setBounds(200, 400, 1000, 50);
        normal.setBounds(500, 500, 150, 100);
        easy.setBounds(300, 500, 150, 100);
        add(difficulty);
        add(normal);
        add(easy);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}


