package w1112;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RadioButtonPainter extends JFrame {
    private Color selectedColor = Color.BLACK;
    private DrawPanel drawPanel;
    private String drawMode = "선";

    public RadioButtonPainter() {
        setTitle("라디오 버튼을 활용하여 간단한 그림판");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());

        //1. 상단 패널에 라디오 버튼 추가
        JPanel topPanel = new JPanel();
        JRadioButton redButton = new JRadioButton("선", true);
        JRadioButton blueButton = new JRadioButton("사각형");
        JRadioButton greenButton = new JRadioButton("타원");

        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(blueButton);
        group.add(greenButton);

        topPanel.add(redButton);
        topPanel.add(blueButton);
        topPanel.add(greenButton);

        // 2. 색상 선택 이벤트
        redButton.addActionListener(e -> drawMode = "선");
        blueButton.addActionListener(e -> drawMode = "사각형");
        greenButton.addActionListener(e -> drawMode = "타원");

        // 3. 그림판 패널
        drawPanel = new DrawPanel();
        drawPanel.setBackground(Color.WHITE);

        // 4. 레이아웃 설정
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    class DrawPanel extends JPanel {
        private int startX, startY;

        public DrawPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    startX = e.getX();
                    startY = e.getY();
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (drawMode.equals("선")) {
                        Graphics g = getGraphics();
                        g.setColor(selectedColor);
                        g.drawLine(startX, startY, e.getX(), e.getY());
                        startX = e.getX();
                        startY = e.getY();
                    }
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (drawMode.equals("사각형") || drawMode.equals("타원")) {
                        Graphics g = getGraphics();
                        g.setColor(selectedColor);
                        int x = Math.min(startX, e.getX());
                        int y = Math.min(startY, e.getY());
                        int width = Math.abs(e.getX() - startX);
                        int height = Math.abs(e.getY() - startY);
                        if (drawMode.equals("사각형")) g.drawRect(x, y, width, height);
                        else if (drawMode.equals("타원")) g.drawOval(x, y, width, height);

                    }
                }
            });
        }

        }
    public static void main(String[] args) {
        new RadioButtonPainter();
    }
}

