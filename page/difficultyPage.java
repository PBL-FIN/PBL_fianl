package page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class difficultyPage extends JFrame {
    
    private JLabel difficulty;
    private JButton normal;
    private JButton easy;
    
    public difficultyPage() {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        difficulty = new JLabel("게임 난이도");
        normal = new JButton("보통");
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String difficulty = e.getActionCommand();
                JOptionPane.showMessageDialog(null, difficulty + "으로 결정하겠습니까?");
                dispose();
                new hintPage();
            }
        });        
        
        easy = new JButton("쉬움");
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String difficulty = e.getActionCommand();
                JOptionPane.showMessageDialog(null, difficulty + "으로 결정하겠습니까?");
                dispose();
                new hintPage();
            }
        });  
        
        difficulty.setFont(new Font(null, Font.PLAIN, 50));
        difficulty.setBounds(200, 400, 1000, 50);
        normal.setBounds(500, 500, 100, 100);
        easy.setBounds(700, 700, 200, 200);
        add(difficulty);
        add(normal);
        add(easy);        
}
