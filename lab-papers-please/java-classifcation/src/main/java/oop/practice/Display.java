package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Display {
    public static void show(String name) throws IOException, IOException {
        System.out.println("\n");
        ObjectMapper mapper = new ObjectMapper();
        String namelower =  name.toLowerCase();
        File inputFile = new File("D:/oop/oop-lab-1/lab-papers-please/output/"+namelower+".json");
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("---------"+name+"---------");
        for(JsonNode entry : data){

            printEntry(entry);

        }
        System.out.println("-----------------------------");
    }
    static void printEntry(JsonNode entry) {
        int id = entry.has("id") ? entry.get("id").asInt() : -1;

        String planet = entry.has("planet") ? entry.get("planet").asText() : "no data";

        BooleanState isHumanoid = BooleanState.UNKNOWN;

        if (entry.has("isHumanoid")) {
            isHumanoid = entry.get("isHumanoid").asBoolean() ? BooleanState.TRUE : BooleanState.FALSE;
        }

        int age = entry.has("age") ? entry.get("age").asInt() : -1;

        JsonNode traits = entry.has("traits") ? entry.get("traits") : null;
        System.out.println("\n");
        System.out.println("ID: " + id);
        System.out.println("Is Humanoid: " + isHumanoid);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + (age > 0 ? age : "UNKNOWN"));
        System.out.println("Traits: " + (traits != null ? traits : "UNKNOWN"));

    }

}
enum BooleanState {
    TRUE,
    FALSE,
    UNKNOWN
}