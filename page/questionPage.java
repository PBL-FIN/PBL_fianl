import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class questionPage extends JFrame {
    private JLabel questionLabel;
    private JButton yesButton;
    private JButton noButton;
    
    public questionPage() {
        setTitle("넓이 구하는 게임");
        setSize(1280, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // FlowLayout 사용

        questionLabel = new JLabel("도형의 넓이 구하는 공식을 아시나요?");
        yesButton = new JButton("네");
        noButton = new JButton("아니오");  
}
