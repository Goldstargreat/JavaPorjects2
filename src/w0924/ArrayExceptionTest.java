package w0924;

// Runtime(Unchecked) Exception
// ArrayIndexOutOfBoundsException
public class ArrayExceptionTest {
    public static void main(String[] args) {
        int[] ary = {10, 20, 30};

        try {
            ary[3] = 40;
            for(int i = 0; i< ary.length; i++){
                System.out.print(ary[i] + '\t');
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("배열의 인덱스 번호가 인덱스 범위를 벗어났습니다. ");
        }
    }
}
