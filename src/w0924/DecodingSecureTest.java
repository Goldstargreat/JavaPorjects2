package w0924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DecodingSecureTest {
    // secure1.txt 파일에서 암호화된 메시지를 읽어와 복호화하는 프로그램
    public static void main(String[] args) {
        // try-with-resources 구문을 사용하여 BufferedReader가 자동으로 닫히도록 함
        try (BufferedReader br = new BufferedReader(new FileReader("D:/FileTest/secure1.txt"))) {
            String line;
            System.out.println("--- Decoding secure1.txt ---");
            System.out.println("Decoded Messages:");

            // 파일의 끝까지 한 줄씩 읽기
            while ((line = br.readLine()) != null) {
                String decodedStr = "";
                // 읽어온 줄의 각 문자를 순회하며 복호화
                for (int i = 0; i < line.length(); i++) {
                    int code = (int) line.charAt(i);
                    // 암호화 시 100을 더했으므로, 복호화 시 100을 뺌
                    code = code - 100;
                    decodedStr = decodedStr + (char) code;
                }
                System.out.println(decodedStr);
            }
            System.out.println("--- Decoding Complete ---");

        } catch (IOException e) {
            // 파일을 찾을 수 없거나 읽기 오류 발생 시 처리
            System.out.println("File Read Error: " + e.getMessage());
        }
    }
}