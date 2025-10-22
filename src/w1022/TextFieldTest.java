package w1022;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldTest extends JFrame {
    JTextField tf; // 한 줄 입력
    JTextArea ta; // 여러 줄 입력
    JPasswordField pf; // 암호 입력

    public TextFieldTest(){
        tf = new JTextField(10);
        ta = new JTextArea(5,10);
        pf = new JPasswordField(10);
        JButton btn = new JButton("Show Message");

        // 버튼을 클릭했을 때 3개의 컴포넌트에 입력된 값을 대화상자에 출력해주세요.

        btn.addActionListener(btnListener);

        setLayout(new FlowLayout());

        add(tf);
        JScrollPane sp = new JScrollPane(ta);
        add(sp);
        add(pf);
        add(btn);

        setTitle("텍스트 입력 가능 컴포넌트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(200,250);
        cf.centerXY();
        setBounds(cf.getX(),cf.getY(),cf.getFw(),cf.getFh());
        setVisible(true);
    }
    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 각 입력 필드에서 값을 가져오기
            String tfText = tf.getText(); // JTextField 값
            String taText = ta.getText(); // JTextArea 값
            String pwText = String.copyValueOf(pf.getPassword()); // JPasswordField 값 pf.getText로 해도 된다.

            // 대화상자에 출력
            JOptionPane.showMessageDialog(null, tfText + "\n" + taText + "\n" + pwText);
        }
    };

    public static void main(String[] args) {
        new TextFieldTest();
    }
}
