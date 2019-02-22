package rpg.itemtype;
import rpg.*;

public class Armor extends Item {

    public Armor(String name, int value, int defense) {
        super(name, value);
    }

    public int Use(CompactStats stats, CompactModifiers mods, int damage, String name) {
        return Defend(stats, mods, damage, name);
    }

    private int Defend(CompactStats stats, CompactModifiers mods, int damage, String name) {
        int calculatedDamage = damage;

        calculatedDamage = calculatedDamage - stats.statDefense;

        if (calculatedDamage < 0) {
            calculatedDamage = 0;
        }

        Game.Say(name + " is defending with their " + iName + ", reducing the damage to " + Integer.toString(calculatedDamage));

        return calculatedDamage;
    }
}