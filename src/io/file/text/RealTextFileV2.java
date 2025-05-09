package io.file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RealTextFileV2 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("== writeString ==");
        System.out.println("writeString = " + writeString);

        Path path = Path.of(PATH);
        Files.writeString(path, writeString, UTF_8);
        List<String> lines = Files.readAllLines(path, UTF_8);
        System.out.println("== readString ==");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(i+1+ ":" + lines.get(i));
        }

        Stream<String> linesStream = Files.lines(path, UTF_8);
        linesStream.forEach(System.out::println);
        linesStream.close();
    }
}
