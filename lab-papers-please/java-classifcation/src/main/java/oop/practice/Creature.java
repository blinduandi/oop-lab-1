public class Creature{
    private int id;
    private boolean isHumanoid;
    private string planet;
    private int age;
    private ArrayList<string> traits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public void setHumanoid(boolean humanoid) {
        isHumanoid = humanoid;
    }

    public string getPlanet() {
        return planet;
    }

    public void setPlanet(string planet) {
        this.planet = planet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<string> getTraits() {
        return traits;
    }

    public void setTraits(ArrayList<string> traits) {
        this.traits = traits;
    }
}