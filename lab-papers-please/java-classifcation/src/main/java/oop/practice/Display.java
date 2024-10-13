public class Display {
    public static void show(string name = "StarWars") throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String namelower =  name.toLowerCase();
        File inputFile = new File("src/main/resources/output/"+namelower+".json");
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("---------"+name+"---------");
        for(JsonNode entry : data){

            FileManager.printEntry(entry);

        }
        System.out.println("-----------------------------");
    }
}