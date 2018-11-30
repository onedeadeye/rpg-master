package rpg;
import java.util.*;

public class Player {

    private String pName;
    List<Character> pMembers = new ArrayList<>();

    public Player (String name) {
        pName = name;
    }

    public void AddCharacter(Character newChar) {
        pMembers.add(newChar);
    }

    public String GetName() {
        return pName;
    }
}