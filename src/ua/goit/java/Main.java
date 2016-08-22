package ua.goit.java;

import ua.goit.java.cryptography.EncriptDecript;
import ua.goit.java.util.UtilReadWrite;

public class Main {

    public static void main(String[] args) {
        String message = "Java is a general-purpose computer programming language.";

        EncriptDecript encriptDecript = new EncriptDecript(3);
        UtilReadWrite utilReadWrite = new UtilReadWrite();

        String filePath = "d:/message.txt";

        try {
            utilReadWrite.saveText(filePath, encriptDecript.encrypt(message));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(encriptDecript.decrypt(utilReadWrite.readText(filePath)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
