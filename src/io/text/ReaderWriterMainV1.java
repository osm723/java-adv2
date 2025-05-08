package io.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        byte[] writeStringBytes = writeString.getBytes(UTF_8);
        System.out.println("writeStringBytes = " + writeString);
        System.out.println("writeStringBytes = " + Arrays.toString(writeStringBytes));

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writeStringBytes);
        fos.close();

        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readAllBytes = fis.readAllBytes();
        fis.close();
        String readString = new String(readAllBytes, UTF_8);
        System.out.println("readAllBytes = " + Arrays.toString(readAllBytes));
        System.out.println("readString = " + readString);
    }
}
