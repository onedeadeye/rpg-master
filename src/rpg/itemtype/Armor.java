package rpg.itemtype;
import rpg.*;

public class Armor extends Item {

    public Armor(String name, int value, int defense) {
        super(name, value);
    }

    public int use(CompactStats stats, CompactModifiers mods, int damage, String name) {
        return defend(stats, mods, damage, name);
    }

    private int defend(CompactStats stats, CompactModifiers mods, int damage, String name) {
        int calculatedDamage = damage;

        calculatedDamage = calculatedDamage - stats.statDefense;

        if (calculatedDamage < 0) {
            calculatedDamage = 0;
        }

        Game.say(name + " is defending with their " + iName + ", reducing the damage to " + Integer.toString(calculatedDamage));

        return calculatedDamage;
    }
}