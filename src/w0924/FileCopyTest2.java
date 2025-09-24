package w0924;

import java.io.*;

public class FileCopyTest2 {

    public static void copyFile(){ throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        fr = new FileReader("D:/FileTest/Mydata1.txt");
        br = new BufferedReader(br);
        fw = new FileWriter();
        String line;

            while ((line = br.readLine() != null)){
                fw.write(line + "\n");
            }
            br.close();
            fw.close();
            System.out.println();



                public static void main(String[] args){
                copyFile();
        }
    }
}

