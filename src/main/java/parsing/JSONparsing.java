package parsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class JSONparsing {
    public static void main(String[] args) throws Exception {
        // parsing file
        Object obj = new JSONParser().parse(new FileReader("src/main/java/parsing/file.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting subject
        String subject = (String) jo.get("Subject");


        System.out.println(subject);
        JSONArray paintersList = (JSONArray) jo.get("painter");
        Iterator Itr = paintersList.iterator();

// Выводим в цикле данные массива
        while (Itr.hasNext()) {
            JSONObject test = (JSONObject) Itr.next();
            System.out.println("Name: " + test.get("name")  +"\nCountry: " + test.get("country") + "\n");

        }
    }

}