package w1112.simple_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class newPaintingPanel extends JPanel implements MouseListener, MouseMotionListener {
    public static String polygon;

    // 도형의 시작점과 끝점 좌표를 저장할 변수
    private int x1, y1, x2, y2;

    public newPaintingPanel(String polygon){
        this.polygon = polygon;
        setBackground(Color.yellow);

        // 마우스 리스너 추가
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        // x1, y1, x2, y2가 초기값(0)이 아니며, 유효한 좌표일 때만 그림
        if (x1 != 0 || y1 != 0 || x2 != 0 || y2 != 0) {
            g.setColor(Color.RED);

            // 도형을 그릴 시작 좌표와 폭(width), 높이(height) 계산
            // 사각형과 타원은 (시작 x, 시작 y, 폭, 높이)를 사용하므로,
            // 드래그 방향에 관계없이 항상 좌측 상단 좌표와 양수 폭/높이를 계산해야 함
            int startX = Math.min(x1, x2);
            int startY = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            // 선택된 도형에 따라 그리기
            switch (polygon){
                case "선":
                    g.drawLine(x1, y1, x2, y2);
                    break;
                case "사각형":
                    g.fillRect(startX, startY, width, height);
                    break;
                case "타원":
                    g.fillOval(startX, startY, width, height);
                    break;
            }
        }
    }

    // --- MouseListener 구현 ---
    @Override
    public void mousePressed(MouseEvent e) {
        // 마우스 버튼을 눌렀을 때 시작 좌표 저장
        x1 = e.getX();
        y1 = e.getY();
        x2 = x1; // 드래그 시작 시 끝점도 시작점으로 설정
        y2 = y1;
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
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    // --- MouseMotionListener 구현 ---
    @Override
    public void mouseDragged(MouseEvent e) {
        // 마우스를 드래그하는 동안 끝 좌표 업데이트 및 실시간으로 다시 그리기
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    // 사용하지 않는 MouseMotionListener 메서드
    @Override
    public void mouseMoved(MouseEvent e) {}
}