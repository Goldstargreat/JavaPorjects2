package w0924;
// Runtime(Unchecked) Exception
// ArrayIndexOutOfBoundsException
// ArithmeticException
public class ArrayArithmeticExceptionTest {

    public static void main(String[] args) {
        int[] ary = {10, 20, 30};

        try {
            ary[0] = ary[2] / 0;
            ary[3] = 40;

            for(int i = 0; i < ary.length; i++){
                System.out.print(ary[i] + "\t");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 인덱스 번호가 인덱스 범위를 벗어났습니다. ");
        } catch (ArithmeticException e) {
            System.out.println("나누는 수는 0일 수 없습니다.");
        } catch (Exception e) {
            System.out.println("임의의 예외가 발생했습니다.");
        } finally {
            System.out.println("프로그램이 종료됩니다.");
        }
    }
}
