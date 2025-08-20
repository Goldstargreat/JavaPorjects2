package w0820;

public class Array2Test {
    public static void main(String[] args) {
        int[][] arr2 = new int[2][3];
        int cnt = 1;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = cnt++;
            }
        }
        // arr2 출력
        System.out.println("arr2의 내용: ");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\narr3의 내용: ");
        // arr3 배열 선언 및 출력
        int[][] arr3 = {{1, 3, 5}, {7, 8, 9}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = cnt++;
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

