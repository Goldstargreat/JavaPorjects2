package w1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseFindXY extends JFrame {
    JTextField tfX, tfY;

    public MouseFindXY(){
        setLayout(new FlowLayout());
        addMouseListener(mouseListener);
        tfX = new JTextField(10);
        tfY = new JTextField(10);
        JLabel lblX = new JLabel("X좌표");
        JLabel lblY = new JLabel("Y좌표");
        add(lblX); add(tfX);
        add(lblY); add(tfY);

        setTitle("MouseEvent Find location");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료
        CenterFrame cf = new CenterFrame(500,400);
        cf.centerXY();  // 창을 화면 중앙에 배치
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh()); // 창의 위치와 크기 설정
        setVisible(true); // JFrame 화면에 표시
    }

    MouseListener mouseListener = new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e){
          tfX.setText(e.getX() + "");
          tfY.setText(e.getY() + "");
      }
    };

    public static void main(String[] args) {
        new MouseFindXY();
    }
}


