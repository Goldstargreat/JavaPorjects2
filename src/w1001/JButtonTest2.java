package w1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonTest2 extends JFrame {
    JTextField tf;

    public JButtonTest2(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JButtonTest2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton btn = new JButton("확인");
        tf = new JTextField(20);
        add(btn);
        add(tf);
        btn.addActionListener(btnListener);
        // 프레임의 너비와 높이
        int frameWidth = 500;
        int frameHeight = 200;

// 화면 해상도 가져오기
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

// 화면 중앙 좌표 계산
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        setBounds(x, y, frameWidth, frameHeight);
        setVisible(true);
        }

    ActionListener btnListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // 눌린 버튼 텍스트를 가져와 메시지 출력
            JOptionPane.showMessageDialog(null, tf.getText()  + " (이)가 입력되었습니다.");
        }
    };

    public static void main(String[] args) {
        new JButtonTest2();
    }
}
