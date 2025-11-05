package w1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawLineMouseTest extends JFrame {
  public int x1, y1, x2, y2;
    DrawPanel dp = new DrawPanel(Color.yellow);

    public DrawLineMouseTest() {

        dp.addMouseListener(mouseListener);
        add(dp);

        setTitle("DrawLineWithMouse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();  // 창을 화면 중앙에 배치
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh()); // 창의 위치와 크기 설정
        setVisible(true);
    }
        public static void main(String[] args) {
            new DrawLineMouseTest();
        }

        MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                x1 = e.getX();
                y1 = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                // 마우스를 뗄 때 끝점을 저장하고 화면을 다시 그리기
                x2 = e.getX();
                y2 = e.getY();
                dp.repaint(); // 화면 새로고침
            }
        };
    class DrawPanel extends JPanel {
        DrawPanel(Color color){
            setBackground(color);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
