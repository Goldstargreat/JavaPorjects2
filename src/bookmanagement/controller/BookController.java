package bookmanagement.controller;

import bookmanagement.domain.BookVO;
import bookmanagement.repository.BookRepository;
import bookmanagement.view.BookInsertView;
import bookmanagement.view.BookSearchView;
import bookmanagement.view.BookUpdateView;
import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BookController extends JFrame {
    BookSearchView searchPan;
    BookInsertView insertPan;
    BookUpdateView updatePan;
    BookRepository bookRepository;
    ArrayList<BookVO> bookVOList;
    JComboBox<String> combo;
    JButton btnSearch, btnInsert, btnUpdate, btnDelete;
    JTable tableUpdate;
    JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);

    public BookController(){
        // 도서 검색에 사용할 BookSearchView 인스턴스를 생성
        searchPan = new BookSearchView();
        combo = searchPan.getCombo();
        bookRepository = new BookRepository();
        bookVOList = bookRepository.select("", combo.getSelectedIndex());
        searchPan.setBookVOList(bookVOList);
        searchPan.initView();
        btnSearch = searchPan.getBtnSearch();
        btnSearch.addActionListener(btnSearchL);

        tab.add("도서 검색", searchPan);


        // 도서 추가
        insertPan = new BookInsertView();
        bookVOList = bookRepository.select("", 0);
        insertPan.setBookVOList(bookVOList);
        insertPan.initView();
        btnInsert = insertPan.getBtnAdd();
        btnInsert.addActionListener(btnInsertL);
        tab.add("도서 추가", insertPan);

        // 도서 수정 및 삭제
        updatePan = new BookUpdateView();
        bookVOList = bookRepository.select("", 0);
        updatePan.setBookVOList(bookVOList);
        updatePan.initView();
        btnUpdate = updatePan.getBtnUpdate();
        btnUpdate.addActionListener(btnUpdateL);
        tableUpdate = updatePan.getTable();
        tableUpdate.addMouseListener(tableUpdateL);
        tab.add("도서 수정 및 삭제", updatePan);

        // 탭 추가
        add(tab);
        tab.addMouseListener(tabL);

        setTitle("도서 관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(600,500);
        cf.centerXY();
        setBounds(cf.getX(),cf.getY(),cf.getFw(),cf.getFh());
        setVisible(true);
    }

    ActionListener btnSearchL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            bookVOList = bookRepository.select(searchPan.getSearchWord(), combo.getSelectedIndex());
            searchPan.setBookVOList(bookVOList);
            searchPan.putSearchResult();
        }
    };

    ActionListener btnInsertL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            BookVO vo = insertPan.neededInsertData();
            bookRepository.insert(vo);
            bookVOList = bookRepository.select("",0); // 변경된 결과행을 화면(table)에 보여주기 위하여
            insertPan.setBookVOList(bookVOList);
            insertPan.putSearchResult();
            insertPan.initInsertData(); // 관리자가 도서 추가 후에 다시 입력할 수 있도록 초기화하는 메서드
        }
    };
    MouseAdapter tableUpdateL = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

           if(e.getClickCount() == 1) {
               int rowIndex = tableUpdate.getSelectedRow();
               updatePan.setTextField(rowIndex);
           }
            if(e.getClickCount() == 2){
                int result = JOptionPane.showConfirmDialog(
                        BookController.this,
                        "정말 삭제하시겠습니까?",
                        "삭제 확인",
                        JOptionPane.YES_NO_OPTION
                );

                if(result == JOptionPane.YES_OPTION){
                    BookVO vo = updatePan.neededInsertData();
                    bookRepository.delete(vo);
                    bookVOList = bookRepository.select("",0);
                    updatePan.setBookVOList(bookVOList);
                    updatePan.putSearchResult();
                }
            }
        }
    };
    ActionListener btnUpdateL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            BookVO vo = updatePan.neededInsertData();
            bookRepository.update(vo);
            bookVOList = bookRepository.select("",0);

            updatePan.setBookVOList(bookVOList);
            updatePan.putSearchResult();
        }
    };


    MouseAdapter tabL = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          int tabIndex = tab.getSelectedIndex();
          if(tabIndex == 0){
              bookVOList = bookRepository.select("",0);
              searchPan.setBookVOList(bookVOList);
              searchPan.putSearchResult();
          }
            else if(tabIndex == 1){
                bookVOList = bookRepository.select("",0);
                insertPan.setBookVOList(bookVOList);
                insertPan.putSearchResult();
            } else {
              bookVOList = bookRepository.select("",0);
              updatePan.setBookVOList(bookVOList);
              updatePan.putSearchResult();
          }
        }
    };
    public static void main(String[] args) {
        new BookController();
    }
}
