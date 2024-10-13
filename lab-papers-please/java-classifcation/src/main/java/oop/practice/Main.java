package oop.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("src/main/resources/test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

//    Scanner scanner = new Scanner(System.in);
    List<Creature> creaturesList = mapper.readValue(data.toString(), new TypeReference<>() {
    });

    for (Creature creature: creaturesList) {
      JsonNode jsonNode = mapper.valueToTree(creature);
      switch (Sorting.sort(creature)) {
        case 1:
          starWars.individuals().add(jsonNode);
          break;
        case 2:
          hitchhikers.individuals().add(jsonNode);
          break;
        case 3:
          marvel.individuals().add(jsonNode);
          break;
        case 4:
          rings.individuals().add(jsonNode);
          break;
        default:
          System.out.println("Invalid input");
      }
    }

    //scanner.close();
    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);

    Display.show("StarWars");
    Display.show("HitchHicker");
    Display.show("Rings");
    Display.show("Marvel");

  }
}

record Universe(
    String name,
    List<JsonNode> individuals
) { }
