import java.util.ArrayList;

public class fsafa {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();

animals.add("fox");

animals.add(0, "squirrel");

animals.add("deer");

animals.set(2, "groundhog");

animals.add(1, "mouse");

System.out.println(animals.get(2) + " and " + animals.get(3));
    }
}
