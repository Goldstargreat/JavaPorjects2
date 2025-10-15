package w1015;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckboxTest extends JFrame {
    JCheckBox checkBox;

    public CheckboxTest(){
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setTitle("CheckboxTest");
        checkBox = new JCheckBox("체크박스를 선택하십시오.");
        checkBox.addActionListener(CheckBoxListener);
        add(checkBox);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
// JFrame이 모니터 화면의 정중앙에 오도록 한다.
        CenterFrame cf = new CenterFrame(500, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }
    ActionListener CheckBoxListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "체크박스가 선택되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "체크박스가 해제되었습니다." );
            }
        }
    };

    public static void main(String[] args) {
        new CheckboxTest();
    }
}
