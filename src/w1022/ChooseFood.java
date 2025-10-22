package w1022;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseFood extends JFrame {

    // 콤보박스에 들어갈 음식 이름
    String[] foodList = {"감자탕", "돼지갈비", "아이스크림", "왕만두", "족발", "탕수육"};

    // 상단 구성요소
    JLabel lblTitle = new JLabel("Food: ");
    JComboBox<String> cbFood = new JComboBox<>(foodList);
    JButton btnSelect = new JButton("음식을 선택하십시오");

    // 이미지 표시할 JLabel
    JLabel lblImage = new JLabel("", JLabel.CENTER);

    public ChooseFood() {
        // ▶ 상단 패널 (FlowLayout)
        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(lblTitle);
        northPanel.add(cbFood);
        northPanel.add(btnSelect);

        // ▶ 중앙 JLabel (이미지 표시용)
        lblImage.setOpaque(true);
        lblImage.setBackground(Color.WHITE);

        //  BorderLayout 배치
        add(northPanel, BorderLayout.NORTH);
        add(lblImage, BorderLayout.CENTER);

        // ▶ 버튼 이벤트 처리
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) cbFood.getSelectedItem();
                ImageIcon icon = new ImageIcon("./imgs_root/food_imgs/" + selected + ".jpg");
                lblImage.setIcon(icon);
                JOptionPane.showMessageDialog(null, selected + "가(이) 선택되었습니다!");
            }
        });

        // ▶ 기본 프레임 설정
        setTitle("Choose Food");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // JFrame 화면 중앙 배치
        CenterFrame cf = new CenterFrame(500, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());

        setVisible(true);
    }

    public static void main(String[] args) {
        new ChooseFood();
    }
}
