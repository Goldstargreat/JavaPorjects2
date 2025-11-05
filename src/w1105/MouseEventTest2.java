package w1105;

import center_frame.CenterFrame;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventTest2 extends JFrame {
    public MouseEventTest2(){
        addMouseListener(mouseListener);

        setTitle("MouseEventTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료
        CenterFrame cf = new CenterFrame(250,250);
        cf.centerXY();  // 창을 화면 중앙에 배치
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh()); // 창의 위치와 크기 설정
        setVisible(true); // JFrame 화면에 표시
    }

    // 마우스 이벤트를 처리할 MouseListener 객체
    MouseAdapter mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (e.getButton()) {
                case MouseEvent.BUTTON1:
                    JOptionPane.showMessageDialog(null, "왼쪽 버튼을 클릭했습니다.");
                    break;
                case MouseEvent.BUTTON2: // 가운데 버튼 (휠 클릭)
                    JOptionPane.showMessageDialog(null, "가운데 버튼을 클릭했습니다.");
                    break;
                case MouseEvent.BUTTON3:
                    JOptionPane.showMessageDialog(null, "오른쪽 버튼을 클릭했습니다.");
                    break;
            }
        }
    };

    public static void main(String[] args) {
        new MouseEventTest2();
    }
}

