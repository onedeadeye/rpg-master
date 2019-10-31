package rpg;
import java.util.*;
import rpg.renderengine.*;
import rpg.itemtype.*;

public class Player {

    private String pName;
    private ArrayList<PlayerCharacter> pMembers = new ArrayList<>();

    private int pXPos = 0;
    private int pYPos = 0;

    private ArrayList<Weapon> pWeaponInventory = new ArrayList<>();
    private ArrayList<Armor> pArmorInventory = new ArrayList<>();

    public Player (String name) {
        pName = name;
    }

    public void addCharacter(PlayerCharacter newChar) {
        pMembers.add(newChar);
    }

    public String getName() {
        return pName;
    }

    public boolean move(int x, int y, World world) {
        if (world.queryInBound(x, y)) {
            pXPos += x;
            pYPos += y;
            Game.say("Moved player to " + Integer.toString(pXPos) + Integer.toString(pYPos));
            return true;
        } else {
            Game.say("Position " + Integer.toString(pXPos) + ", " + Integer.toString(pYPos) + " is out of map bounds");
            return false;
        }
    }

    public boolean moveWorldSpace(int x, int y, World world) {
        if (world.queryInBound(x, y)) {
            pXPos = x;
            pYPos = y;
            return true;
        } else {
            return false;
        }
    }

    public int getXPos() {
        return pXPos;
    }

    public int getYPos() {
        return pYPos;
    }

    public void listPartyStatus() {
        Game.say("Status of " + pName + "'s party:");
        for (int i = 0; i < pMembers.size(); i++) {
            Game.say(pMembers.get(i).aName + " - Level " + pMembers.get(i).getLevel() + " " + pMembers.get(i).getCharacterClass().getName());
        }
    }

    public void listInventory() {
        Game.say(pName + "'s inventory:");
        for (int i = 0; i < pWeaponInventory.size(); i++) {
            Game.say(pWeaponInventory.get(i).iName);
        }
    }

    public void addWeapon(Weapon weapon) {
        pWeaponInventory.add(weapon);
    }

    public void addArmor(Armor armor) {
        pArmorInventory.add(armor);
    }

    public ArrayList<Weapon> getWeaponInventory() {
        return pWeaponInventory;
    }

    public ArrayList<Armor> getArmorInventory() {
        return pArmorInventory;
    }

    public void sellItem(String itemName) {

    }

    public void addConsumable() {
        //TODO: fix this
    }

    public PlayerCharacter getPartyFighter() {
        return pMembers.get(0);
    }
}