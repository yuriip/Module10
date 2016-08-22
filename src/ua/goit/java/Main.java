package ua.goit.java;

import ua.goit.java.cryptography.EncriptDecript;
import ua.goit.java.util.TextFileProcessor;

public class Main {

    public static void main(String[] args) {
        String message = "Java is a general-purpose computer programming language.";

        EncriptDecript encriptDecript = new EncriptDecript(3);
        TextFileProcessor textFileProcessor = new TextFileProcessor();

        String filePath = "d:/message.txt";

        try {
            textFileProcessor.saveText(filePath, encriptDecript.encrypt(message));
            System.out.println(encriptDecript.decrypt(textFileProcessor.readText(filePath)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
