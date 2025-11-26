package bookmanagement.view;

import bookmanagement.domain.BookVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class BookInsertView extends JPanel {
    JTable table;
    DefaultTableModel model;
    ArrayList<BookVO> bookVOList;
    String[] header = {"도서번호", "도서명", "출판사", "저자명", "도서가격", "카테고리"};
    String[] categoryNames = {"IT도서", "소설", "비소설", "경제", "사회"};

    JPanel panS;
    JLabel[] lbls = new JLabel[header.length];
    JTextField[] tf = new JTextField[header.length - 1];
    JComboBox<String> categoryCombo;
    JButton btnAdd;

    public BookInsertView(){
        setLayout(new BorderLayout());
        categoryCombo = new JComboBox(categoryNames);
        btnAdd = new JButton("도서 추가");
        panS = new JPanel(new GridLayout(4,4));
        for(int i = 0; i < header.length; i ++){
            lbls[i] = new JLabel(header[i]);
            panS.add(lbls[i]);
            if(i < header.length - 1){
                tf[i] = new JTextField();
                panS.add(tf[i]);
            }else {
                panS.add(categoryCombo);
            }
        }
        for(int i = 0; i < 3; i++){
            panS.add(new JLabel(" "));
        }
        panS.add(btnAdd);
    }
    // Jtable과 DefaultTableModel을 연결하고 테이블과 관련된 내용을 초기화하는 메서드
    public void initView(){
        model = new DefaultTableModel(header, bookVOList.size()){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table = new JTable(model);
        // 테이블의 컬럼 너비
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);

        // 테이블의 행의 개수가 많을 때 스크롤바를 이용한다
        JScrollPane scrollPane = new JScrollPane(table);

        // 각각의 셀에 리스트에 저장된 BookVO 객체가 가지고 있는 값을 설정한다
        putSeartchResult();

        // 현재 패널에 North에는 panN, Center에는 scrollbar가 있는 table을 추가했다
        add(scrollPane, BorderLayout.CENTER);
        add(panS, BorderLayout.SOUTH);
    }
    // DefaultTableModel에 도서 정보들을 반환받아서 설정한다
    public void putSeartchResult(){
        // model의 행 개수를 설정
        model.setRowCount(bookVOList.size());
        BookVO vo = null;
        for(int i = 0; i < bookVOList.size(); i++){
            vo = bookVOList.get(i);
            model.setValueAt(vo.getIsbn(), i,0);
            model.setValueAt(vo.getName(), i,1);
            model.setValueAt(vo.getPublish(), i,2);
            model.setValueAt(vo.getAuthor(), i,3);
            model.setValueAt(vo.getPrice(), i,4);
            model.setValueAt(vo.getCategoryName(), i,5);
        }
    }
}
