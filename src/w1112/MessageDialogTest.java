package w1112;

import center_frame.CenterFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageDialogTest extends JFrame implements ActionListener {
    String[] btnStrs = {"Plain", "Warning", "Information"};
    JButton[] buttons = new JButton[btnStrs.length];

    public MessageDialogTest(){
        JPanel panel = new JPanel();
        add(panel, "North");
        for(int i = 0; i < btnStrs.length; i++){
            buttons[i] = new JButton(btnStrs[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        setTitle("Message Dialogbox 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(300,250);
        cf.centerXY();
        setBounds(cf.getX(),cf.getY(),cf.getFw(),cf.getFh());
        setVisible(true);
    }


    public static void main(String[] args) {
        new MessageDialogTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eBtnStr = e.getActionCommand();
        switch (eBtnStr){
            case "Plain":
                JOptionPane.showMessageDialog(null, "일반 메시지 대화상자","Plain option", JOptionPane.PLAIN_MESSAGE);
                break;
            case "Warning":
                JOptionPane.showMessageDialog(null, "경고 메시지 대화상자","Warning option", JOptionPane.WARNING_MESSAGE);
                break;
            case "Information":
                JOptionPane.showMessageDialog(null, "정보 메시지 대화상자","Information option", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
}
