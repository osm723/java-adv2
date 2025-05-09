package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("file.exists() = " + file.exists());
        boolean created = file.createNewFile();
        System.out.println("created = " + created);

        boolean dirCreated = directory.mkdir();
        System.out.println("dirCreated = " + dirCreated);

        //boolean deleted = file.delete();
        //System.out.println("deleted = " + deleted);

        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("directory.isDirectory() = " + directory.isDirectory());
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.length() = " + file.length());

        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("renamed = " + renamed);

        System.out.println("newFile.lastModified() = " + new Date(newFile.lastModified()));
    }
}
