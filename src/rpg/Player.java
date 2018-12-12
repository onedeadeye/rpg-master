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
            GameSingleton.Say("Moved player to " + Integer.toString(pXPos) + Integer.toString(pYPos));
            return true;
        } else {
            GameSingleton.Say("Position " + Integer.toString(pXPos) + ", " + Integer.toString(pYPos) + " is out of map bounds");
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
            GameSingleton.Say(pMembers.get(i).aName + " - Level " + pMembers.get(i).GetLevel() + " " + pMembers.get(i).GetClass().GetName());
        }
    }

    public void ListInventory() {
        GameSingleton.Say(pName + "'s inventory:");
        for (int i = 0; i < pWeaponInventory.size(); i++) {
            GameSingleton.Say(pWeaponInventory.get(i).iName);
        }
    }

    public void AddWeapon(Weapon weapon) {
        pWeaponInventory.add(weapon);
    }

    public void AddArmor(Armor armor) {
        pArmorInventory.add(armor);
    }

    public ArrayList<Weapon> GetWeaponInventory() {
        return pWeaponInventory;
    }

    public ArrayList<Armor> GetArmorInventory() {
        return pArmorInventory;
    }

    public void SellItem(String itemName) {

    }

    public void AddConsumable() {
        //TODO: fix this
    }

    public PlayerCharacter GetPartyFighter() {
        return pMembers.get(0);
    }
}