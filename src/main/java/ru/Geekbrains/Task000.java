package ru.Geekbrains;

import java.io.File;
import java.util.Objects;

public class Task000 {
    public static void main(String[] args) {
        String path = "C:/Windows";
        File folder = new File(path);
        fileExtensions(folder);
    }
    static void fileExtensions(File folder) {
        int index;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        try {
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                if (file.isFile()) {
                    index = file.getName().lastIndexOf('.');
                    if (index != -1){ // Проверка на то, что у файла есть расширение
                        sb.append(count)
                          .append(" Расширение файла \"")
                          .append(file.getName(), 0, index)
                          .append("\": ")
                          .append(file.getName(), index + 1, file.getName().length());
                    } else {
                        sb.append(count)
                          .append(" Расширение файла \"")
                          .append(file.getName())
                          .append("\": Отсутствует");
                    }
                    System.out.println(sb);
                    sb.setLength(0);
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Путь не найден");
        }
    }
}
