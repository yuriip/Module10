package ua.goit.java.cryptography;

public class EncriptDecript {
    private int offset;

    public EncriptDecript(int offset) {
        this.offset = offset;
    }

    public String encrypt(String text) throws IllegalArgumentException {
        if (!isTextValid(text)) {
            throw new IllegalArgumentException("Пустая строка. Введите не пустую строку");
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            res.append(encryptChar(text.charAt(i)));
        }

        return new String(res);
    }

    public String decrypt(String text) throws IllegalArgumentException {
        if (!isTextValid(text)) {
            throw new IllegalArgumentException("Пустая строка. Введите не пустую строку");
        }
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            res.append(decryptChar(text.charAt(i)));
        }

        return new String(res);
    }

    private char encryptChar(char c) {
        return c == Character.MAX_VALUE ? '\0' : (char) (c + offset);
    }

    private char decryptChar(char c) {
        return c == '\0' ? Character.MAX_VALUE : (char) (c - offset);
    }

    private boolean isTextValid(String text) {
        return text != null && !text.isEmpty();
    }
}
