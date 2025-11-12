package w1112;

import center_frame.CenterFrame;
import javax.swing.*;

public class InputDialogTest extends JFrame {
    public InputDialogTest(){
        setTitle("InuptDialog 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300,250);
        cf.centerXY();
        setBounds(cf.getX(),cf.getY(),cf.getFw(),cf.getFh());
        setVisible(true);
     String name = JOptionPane.showInputDialog(null, "이름을 입력하세요", "홍길동");
     int age =  Integer.parseInt(JOptionPane.showInputDialog(null,"나이를 입력하세요",20));
        JOptionPane.showMessageDialog(null, "이름: " + name + "\n나이: " + age + "세", "입력 결과", JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        new InputDialogTest();
    }

}
