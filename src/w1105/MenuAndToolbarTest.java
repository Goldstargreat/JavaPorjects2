package w1105;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAndToolbarTest extends JFrame {
    JLabel label = new JLabel("툴바의 항목을 선택하십시오.", JLabel.CENTER);
    JButton btnNew = new JButton(new ImageIcon("./toolbar_icons/new.png"));
    JButton btnOpen = new JButton(new ImageIcon("./toolbar_icons/open.png"));
    JButton btnClose = new JButton(new ImageIcon("./toolbar_icons/close.png"));

    public MenuAndToolbarTest(){
        JToolBar toolBar = new JToolBar();
        add(toolBar, BorderLayout.NORTH);
        add(label);

        toolBar.add(btnNew);
        toolBar.add(btnOpen);
        toolBar.addSeparator();
        toolBar.add(btnClose);

        miNew.addActionListener(itemListener);
        miOpen.addActionListener(itemListener);
        miClose.addActionListener(itemListener);

        setTitle("툴바 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료
        CenterFrame cf = new CenterFrame(500, 400);
        cf.centerXY();  // 창을 화면 중앙에 배치
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh()); // 창의 위치와 크기 설정
        setVisible(true);
    }
    ActionListener itemListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = null;
            JMenuItem item = null;
            if(e.getSource() instanceof JButton){
                button = (JButton) e.getSource();
            }else {
                item = (JMenuItem) e.getSource();
            }

            if(button == btnNew || item = miNew) {
                label.setText("[새 문서] 항목을 선택했습니다.");
            }else if(button == btnOpen || item == miOpen) {
                label.setText("[열기] 항목을 선택하셨습니다.");
            }else {
                System.exit(0);
            }
        }
    };

    public static void main(String[] args) {
        new MenuAndToolbarTest();
    }
}
