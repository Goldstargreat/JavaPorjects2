package w1112.simple_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class newPaintingPanel extends JPanel implements MouseListener {
    public static String polygon;
    private int x1, y1, x2, y2;    // 도형의 시작점과 끝점 좌표를 저장할 변수

    public newPaintingPanel(String polygon) {
        this.polygon = polygon;
        setBackground(Color.yellow);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 선택된 도형에 따라 그리기
        switch (polygon) {
            case "선":
                g.drawLine(x1, y1, x2, y2);
                break;
            case "사각형":
                g.setColor(Color.GREEN);
                g.fillRect(x1, y1, x2-x1, y2-y1);
                break;
            case "타원":
                g.setColor(Color.YELLOW);
                g.fillOval(x1, y1, x2-x1, y2-y1);
                break;
        }
        x1 = x2 = y1 = y2 = 0;
    }

    // --- MouseListener 구현 ---
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 마우스 버튼을 놓았을 때 끝 좌표 저장 및 다시 그리기
        x1 = e.getX();
        y1 = e.getY();

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // 마우스 버튼을 놓았을 때 끝 좌표 저장 및 다시 그리기
        x2 = e.getX();
        y2 = e.getY();
        repaint();

    }

    // 사용하지 않는 MouseListener 메서드

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}


