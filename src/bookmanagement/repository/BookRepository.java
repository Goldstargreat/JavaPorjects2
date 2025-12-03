package bookmanagement.repository;

import bookmanagement.domain.BookVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepository {
    ArrayList<BookVO> bookVOList;

    public ArrayList<BookVO> select(String searchWord, int selectedIndex) {
        Connection con = JDBCConnector.getConnection();
        bookVOList = new ArrayList<BookVO>();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        String[] columnName = {"name", "publish", "author"};
        String sql = "select isbn, name, publish, author, price, category_name from book, category where book.category "
                + "= category.category_id and " + columnName[selectedIndex] + " like ?";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "%" + searchWord + "%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                BookVO bookVO = new BookVO();
                bookVO.setIsbn(rs.getInt("isbn"));
                bookVO.setName(rs.getString("name"));
                bookVO.setPublish(rs.getString("publish"));
                bookVO.setAuthor(rs.getString("author"));
                bookVO.setPrice(rs.getInt("price"));
                bookVO.setCategoryName(rs.getString("category_name"));
                bookVOList.add(bookVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psmt != null) {
                    psmt.close();
                }
                if (con != null)
                    con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookVOList;
    }


    public void insert(BookVO vo) {
        Connection con = JDBCConnector.getConnection();
        // book 테이블에 isbn, name, publish, author, price, category(ID)를 삽입하는 쿼리
        String sql = "INSERT INTO book (isbn, name, publish, author, price, category) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, vo.getIsbn()); // 1. isbn
            psmt.setString(2, vo.getName()); // 2. name
            psmt.setString(3, vo.getPublish()); // 3. publish
            psmt.setString(4, vo.getAuthor()); // 4. author
            psmt.setInt(5, vo.getPrice()); // 5. price
            int categoryId = 0;

            switch (vo.getCategoryName()) {
                case "IT도서":
                    categoryId = 10;
                    break;
                case "소설":
                    categoryId = 20;
                    break;
                case "비소설":
                    categoryId = 30;
                    break;
                case "경제":
                    categoryId = 40;
                    break;
                case "사회":
                    categoryId = 50;
                    break;
            }
            psmt.setInt(6, categoryId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) {
                    psmt.close();
                }
                if (con != null)
                    con.close();

            } catch (SQLException e) {
                System.out.println("insert close 문제 발생");
                e.printStackTrace();
            }
        }
    }

    public void update(BookVO vo) {
        Connection con = JDBCConnector.getConnection();
        String sql = "update book set name = ?, publish = ?, author = ?, price = ?, category = ? WHERE isbn = ?";
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, vo.getName());      // 1. name
            psmt.setString(2, vo.getPublish());   // 2. publish
            psmt.setString(3, vo.getAuthor());    // 3. author
            psmt.setInt(4, vo.getPrice());        // 4. price
            int categoryId = 0;
            switch (vo.getCategoryName()) {
                case "IT도서":
                    categoryId = 10;
                    break;
                case "소설":
                    categoryId = 20;
                    break;
                case "비소설":
                    categoryId = 30;
                    break;
                case "경제":
                    categoryId = 40;
                    break;
                case "사회":
                    categoryId = 50;
                    break;
            }
            psmt.setInt(5, categoryId);           // 5. category

            psmt.setInt(6, vo.getIsbn());         // 6. WHERE isbn

            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) {
                    psmt.close();
                }
                if (con != null)
                    con.close();

            } catch (SQLException e) {
                System.out.println("update close 문제 발생");
                e.printStackTrace();
            }
        }
    }

    public void delete(BookVO vo) {
        Connection con = JDBCConnector.getConnection();
        String sql = "delete from book WHERE isbn = ?";
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, vo.getIsbn());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psmt != null) {
                    psmt.close();
                }
                if (con != null)
                    con.close();

            } catch (SQLException e) {
                System.out.println("delete close 문제 발생");
                e.printStackTrace();
            }
        }
    }
}

