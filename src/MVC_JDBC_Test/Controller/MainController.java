package MVC_JDBC_Test.Controller;

import jdbc_test.JDBCConnector;
import MVC_JDBC_Test.Entity.Customer;
import MVC_JDBC_Test.Entity.Order;
import MVC_JDBC_Test.View.CustomerView;
import MVC_JDBC_Test.View.InputCustomerInfoView;
import MVC_JDBC_Test.View.OrdersView;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Connection con = JDBCConnector.getConnection();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= 고객 관리 시스템 =========");
            System.out.println("1. 고객 목록 조회");
            System.out.println("2. 고객 정보 입력");
            System.out.println("3. 고객 정보 수정"); // ★ 추가
            System.out.println("4. 고객 정보 삭제"); // ★ 추가
            System.out.println("5. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 정리

            if (menu == 1)
                customerListAndView(con);
            else if (menu == 2)
                inputCustomerAndView(con);
            else if (menu == 3)
                updateCustomer(con);   // ★ 추가
            else if (menu == 4)
                deleteCustomer(con);   // ★ 추가
            else if (menu == 5)
                break;
            else
                System.out.println("잘못된 선택입니다.");
        }

        System.out.println("프로그램을 종료합니다.");
    }

    public static void orderListAndView(Connection con) {
        ArrayList<Order> orderList = new ArrayList<Order>();
        String sql = "select 주문번호, 고객이름, 고객아이디, 배송지, 수량, 주문일자, 제품명  from 주문, 고객, 제품  where 주문.주문고객=고객.고객아이디 and 주문.주문제품=제품.제품번호";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Order order = null;
            while (rs.next()) {
                order = new Order();
                order.setOrderNum(rs.getString("주문번호"));
                order.setCustomerName(rs.getString("고객이름"));
                order.setCustomerId(rs.getString("고객아이디"));
                order.setShippingAdress(rs.getString("배송지"));
                order.setQuantity(rs.getInt("수량"));
                order.setShippingDate(rs.getDate("주문일자"));
                order.setProductName(rs.getString("제품명"));
                orderList.add(order);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        OrdersView.printHead();
        for (Order order : orderList) {
            OrdersView.printOrders(order);
        }

    }

    public static void customerListAndView(Connection con) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        try {
            String sql = "select * from 고객";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Customer customer = null;

            while (rs.next()) {
                customer = new Customer();
                customer.setCustomerid(rs.getString("고객아이디"));
                customer.setCustomername(rs.getString("고객이름"));
                customer.setAge(rs.getInt("나이"));
                customer.setLevel(rs.getString("등급"));
                customer.setJob(rs.getString("직업"));
                customer.setReward(rs.getInt("적립금"));
                customerList.add(customer);
            }

        } catch (SQLException e) {
            System.out.println("Statement or SQL Error");
        }

//        CustomerView를 사용해서 customerList에 저장된 Customer Entity의 정보들을 출력해 보세요.
        CustomerView customerView = new CustomerView();
        customerView.printHead();
        for (Customer customer: customerList){
            customerView.printCustomer(customer);
            System.out.println();
        }
        customerView.printFooter();
    }

//    고객정보 입력 및 입력 내용 출력
//    고객정보 DB의 고객테이블에 고객 Entity 추가

    public static void inputCustomerAndView(Connection con) {
        Scanner sc = new Scanner(System.in);
        InputCustomerInfoView inputCustomer = new InputCustomerInfoView();
        while (true){
            Customer customer = inputCustomer.inputCustomerInfo();
            CustomerView customerView = new CustomerView();
            customerView.printHead();
            customerView.printCustomer(customer);
            customerView.printFooter();

            String sql = "insert into 고객 values(?,?,?,?,?,?)";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, customer.getCustomerid());
                pstmt.setString(2, customer.getCustomername());
                pstmt.setInt(3, customer.getAge());
                pstmt.setString(4, customer.getLevel());
                pstmt.setString(5, customer.getJob());
                pstmt.setInt(6, customer.getReward());
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                System.out.println("Statement or SQL Error");
            }
            System.out.print("프로그램 종료를 원하면 e를 입력:");

            String input = sc.nextLine();

            if(input.equals("e")){
                break;
            }
        }
        System.out.println("프로그램이 종료 되었습니다. !!!");

    }
    // ========================== ★ 신규 추가 코드 시작 ==========================

    // ★ 고객정보 수정 기능 추가
    public static void updateCustomer(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n====== 고객 정보 수정 ======");
        System.out.print("수정할 고객 아이디 입력: ");
        String id = sc.nextLine();

        System.out.print("새 이름 입력: ");
        String name = sc.nextLine();

        System.out.print("새 나이 입력: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("새 등급 입력: ");
        String level = sc.nextLine();

        System.out.print("새 직업 입력: ");
        String job = sc.nextLine();

        System.out.print("새 적립금 입력: ");
        int reward = sc.nextInt();

        String sql = "update 고객 set 고객이름=?, 나이=?, 등급=?, 직업=?, 적립금=? where 고객아이디=?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, level);
            pstmt.setString(4, job);
            pstmt.setInt(5, reward);
            pstmt.setString(6, id);

            int result = pstmt.executeUpdate();
            if (result > 0) System.out.println("고객 정보가 성공적으로 수정되었습니다!");
            else System.out.println("해당 고객의 아이디를 찾을 수 없습니다.");
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("SQL 오류: " + e.getMessage());
        }
    }

    // ★ 고객정보 삭제 기능 추가
    public static void deleteCustomer(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n====== 고객 정보 삭제 ======");
        System.out.print("삭제할 고객 아이디 입력: ");
        String id = sc.nextLine();

        String sql = "delete from 고객 where 고객아이디 = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);

            int result = pstmt.executeUpdate();
            if (result > 0) System.out.println("고객 정보가 성공적으로 삭제되었습니다!");
            else System.out.println("해당 고객의 아이디를 찾을 수 없습니다.");
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("SQL 오류: " + e.getMessage());
        }
    }
    // ========================== ★ 신규 추가 코드 끝 ==========================
}
