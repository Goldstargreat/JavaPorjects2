package w1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonTest extends JFrame {
    public JButtonTest(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JButtonTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 버튼에 들어갈 문자열 배열
        String[] lblTexts = {"클릭", "인공지능소프트웨어과", "Hello", "Java", "ROK Airbourne"};
        JButton[] btns = new JButton[lblTexts.length];

        // 버튼 생성과 추가를 반복문으로 처리
        for(int i = 0; i < btns.length; i++){
            btns[i] = new JButton(lblTexts[i]);
            btns[i].addActionListener(btnListener);
            add(btns[i]);
        }

        setBounds(200, 200, 600, 250);
        setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // 눌린 버튼 텍스트를 가져와 메시지 출력
            JOptionPane.showMessageDialog(null, e.getActionCommand() + " 버튼을 선택했습니다.");
        }
    };

    public static void main(String[] args) {
        new JButtonTest();
    }
}
