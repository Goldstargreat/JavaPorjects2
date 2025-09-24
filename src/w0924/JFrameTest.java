package w0924;

import javax.swing.*;

public class JFrameTest extends JFrame {

    public JFrameTest(){
        setTitle("처음 만드는 프레임");
        setSize(500,500);
        setVisible(true);
        setLocation(200,200);
    }

    public static void main(String[] args) {
        new JFrameTest();
    }
}
