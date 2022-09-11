package ru.Geekbrains;

public class Task001 {
    public static void main(String[] args) {
        String str = "{\"name\":\"Ivanov\", \"country\":\"Moscow\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String[] strList = str.replaceAll("[{}\" ]", "").split(",");
        StringBuilder sb = new StringBuilder("select * from students where ");
        int length = sb.length();
        int index;
        for (String s : strList) {
            index = s.indexOf(":");
            if (s.substring(index + 1).equals("null")) continue;
            if (length != sb.length()) sb.append(" and ");
            sb.append(s, 0, index)
              .append(" = ")
              .append("'")
              .append(s.substring(index + 1))
              .append("'");
        }
        System.out.println(sb);
    }
}
