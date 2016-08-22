package ua.goit.java.util;

import java.io.*;
import java.nio.charset.Charset;

public class UtilReadWrite {
    public void saveText(String filePath, String text) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream(filePath), Charset.forName("UTF-8") ))){
            bufferedWriter.write(text);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readText(String filePath) {
        File file = new File(filePath);

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(file), Charset.forName("UTF-8")))){
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new String(stringBuilder);
    }
}

