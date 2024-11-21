import java.awt.event.ActionListener;

public class hintPage extends JFrame {
    private JLabel tip;
    private JButton start;

    public hintPage() {
        setTitle("도형 넓이 구하는 게임!");
        setSize(1980, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        tip = new JLabel("Tip) 캐릭터를 클릭하면 힌트가 나와요~ 문제를 풀기 어렵다면 클릭하세요!");
        tip.setFont(new Font(null, Font.PLAIN, 50));
        tip.setBounds(200, 400, 1500, 50);
        start = new JButton("게임시작");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new easyQuizPage();
            }
        });
        start.setBounds(500, 500, 100, 100);

        add(tip);
        add(start);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
