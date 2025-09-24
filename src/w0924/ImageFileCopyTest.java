package w0924;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//이미지 파일은 1byte 씩 입력 받아서 1byte 씩 출력
public class ImageFileCopyTest {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("C:/Users/AI-510-155/Pictures/python.png");
            fos = new FileOutputStream("D:/FileTest/CopyImageFile1.jpg");

            int ch;
            while ((ch = fis.read()) != -1){
                fos.write(ch);
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not Found");;
        } catch (IOException e) {
            System.out.println("Reading Character Error");
        }

        try {
            fis.close();
            fos.close();
            System.out.println("File Copied Successfully");
        } catch (IOException e) {
            System.out.println("Closing File IOStream Error");
        }
    }
}
