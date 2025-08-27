package w0827;

public class DynamicArray {
    public static void main(String[] args) {
        // 1> 3개의 행을 지닌 가변 배열을 선언한다
        int [][] dynamicArray = new int [3][];

        // 2> 각 행의 열 크기를 할당한다.
        dynamicArray[0] = new int[2];
        dynamicArray[1] = new int[3];
        dynamicArray[2] = new int[1];

        // 3> 데이터를 입력한다.
        dynamicArray[0][0] = 1;
        dynamicArray[0][1] = 2;

        dynamicArray[1][0] = 3;
        dynamicArray[1][1] = 4;
        dynamicArray[1][2] = 5;

        dynamicArray[2][0] = 6;

        // 4> 입력된 값을 출력한다.
        System.out.println("Dyammic Array: ");
        for(int i = 0; i < dynamicArray.length; i++){
            for(int j = 0; j < dynamicArray[i].length; j++){
                System.out.print(dynamicArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
