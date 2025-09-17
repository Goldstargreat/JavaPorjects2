package w0917.FileWriteTest;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest01 {
    public static void main(String[] args) {
        FileWriter fw = null;
        String line = null;
        try {
            fw = new FileWriter("D:/File Test/MyData2.txt");
            line = "아이브 장원영";
            fw.write(line +"\n");
            line = "도널드 트럼프";
            fw.write(line +"\n");
            line = "해리 트루먼";
            fw.write(line +"\n");
        } catch (IOException e) {
            System.out.println("FileWriter Generation Error ");
        }
        try {
            fw.close();
        } catch (IOException e) {
            System.out.println("FileWriter Generation close Error");
        }
    }
}
