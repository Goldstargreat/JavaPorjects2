package w0917.PasswordGenerator;
import java.util.Scanner;
import static w0917.PasswordGenerator.Condition.checkPassword;

public class GeneratorPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("비밀번호는 영문 또는 한글만 입력 가능합니다.(최소 8글자 이상이어야 합니다.)");
        System.out.print("새로운 비밀번호를 입력하세요.: ");

        String password = sc.nextLine(); // password 변수를 선언

        if(checkPassword(password))
            System.out.println("비밀번호가 올바르게 생성되었습니다.");
        else
            System.out.println("오류! 비밀번호가 규칙에 맞지 않습니다.");
        sc.close();
    }
}
