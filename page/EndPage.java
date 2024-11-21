package page;

import javax.swing.*;

public class EndPage extends JFrame{
    private JLabel result;
    private JLabel score;
    private JButton restart;
    private JButton goToMenu;

    public EndPage() {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }
}
