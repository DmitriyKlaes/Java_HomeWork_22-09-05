package ru.Geekbrains;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Task002 {
    public static void main(String[] args){
        String path = "Task002.json";
        JSONArray dataFile = readFile(path);
        parseData(dataFile);
    }
    static JSONArray readFile(String path){
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(path)){
            JSONArray dataFile = (JSONArray) parser.parse(reader);
            return dataFile;
        }
        catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    static void parseData(JSONArray data) {
        if (data != null) {
            StringBuilder builder = new StringBuilder();
            for (Object line : data) {
                JSONObject dictionary = (JSONObject) line;
                builder.append("Студент ")
                       .append(dictionary.get("фамилия"))
                       .append(" получил ")
                       .append(dictionary.get("оценка"))
                       .append(" по предмету ")
                       .append(dictionary.get("предмет"));
                System.out.println(builder);
                builder.setLength(0);
            }
        }
    }
}
