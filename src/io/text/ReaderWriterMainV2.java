package io.text;

import java.io.*;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV2 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("writeString = " + writeString);

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);

        osw.write(writeString);
        osw.close();

        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);

        int ch;
        StringBuilder readString = new StringBuilder();
        while ((ch = isr.read()) != -1) {
            readString.append((char) ch);
        }
        isr.close();

        System.out.println("readString = " + readString);
    }
}
