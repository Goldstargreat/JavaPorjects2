package w1015;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonTest extends JFrame {
    String[] rbStrArr = {"아이브", "뉴진스", "블랙핑크"};
    String[] imgNameArr = {"Ive", "Newjeans", "BlackPink"};
    JRadioButton[] rbArr = new JRadioButton[rbStrArr.length];
    JLabel lbl = new JLabel("", JLabel.CENTER);

    public RadioButtonTest(){
        JPanel panel = new JPanel();
        ButtonGroup bg = new ButtonGroup();
        int i = 0;
        for(String str: rbStrArr) {
            rbArr[i] = new JRadioButton(str);
            rbArr[i].addActionListener(radioListener);
            bg.add(rbArr[i]);
            panel.add(rbArr[i]);
            i++;
        }
        lbl.setOpaque(true);
        lbl.setBackground(Color.GREEN);
        add(panel, "North");
        add(lbl, "Center");

        setTitle("RadioButtonTest");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
// JFrame이 모니터 화면의 정중앙에 오도록 한다.
        CenterFrame cf = new CenterFrame(500, 300);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }
    ActionListener radioListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = 0;

            for(JRadioButton rb : rbArr) {
                if(rb.isSelected()) {
                    ImageIcon imageIcon = new ImageIcon("./imgs_root/"+imgNameArr[i]+".jpg");
                    lbl.setIcon(imageIcon);
                    JOptionPane.showMessageDialog(null, rb.getText() + "가 선택되었습니다.");
                }
                i++;
            }
        }
    };
    public static void main(String[] args) {
        new RadioButtonTest();
    }
}
