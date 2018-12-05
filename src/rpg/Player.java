package rpg;
import java.util.*;
import rpg.renderengine.*;

public class Player {

    private String pName;
    List<PlayerCharacter> pMembers = new ArrayList<>();

    private int pXPos = 0;
    private int pYPos = 0;

    public Player (String name) {
        pName = name;
    }

    public void AddCharacter(PlayerCharacter newChar) {
        pMembers.add(newChar);
    }

    public String GetName() {
        return pName;
    }

    public boolean Move(int x, int y, World world) {
        if (world.QueryInBound(x, y)) {
            pXPos += x;
            pYPos += y;
            return true;
        } else {
            return false;
        }
    }

    public boolean MoveWorldSpace(int x, int y, World world) {
        if (world.QueryInBound(x, y)) {
            pXPos = x;
            pYPos = y;
            return true;
        } else {
            return false;
        }
    }

    public int GetXPos() {
        return pXPos;
    }

    public int GetYPos() {
        return pYPos;
    }

    public void ListPartyStatus() {
        GameSingleton.Say("Status of " + pName + "'s party:");
        for (int i = 0; i < pMembers.size(); i++) {
            GameSingleton.Say(pMembers.get(i).aName + " - Level " + pMembers.get(i).aLevel + " " + pMembers.get(i).getClass().getName());
        }
    }
}