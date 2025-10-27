package MVC_JDBC_Test.View;
import MVC_JDBC_Test.Entity.Customer;

public class PrintCustomerInfoView {

    // 고객 정보를 출력하는 메서드
    public void printCustomerInfo(Customer customer) {
        System.out.println("======================================");
        System.out.println("======== 고객 정보 확인 화면 =========");
        System.out.println("======================================");
        System.out.printf("고객 아이디 : %s\n", customer.getCustomerid());
        System.out.printf("고객 이름   : %s\n", customer.getCustomername());
        System.out.printf("나이        : %d\n", customer.getAge());
        System.out.printf("등급        : %s\n", customer.getLevel());
        System.out.printf("직업        : %s\n", customer.getJob());
        System.out.printf("적립금      : %d\n", customer.getReward());
        System.out.println("======================================");
    }
}

