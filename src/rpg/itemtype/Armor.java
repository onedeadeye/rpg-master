package rpg.itemtype;
import rpg.*;

public class Armor extends Item {
    private int aDefense;

    public Armor(String name, int value, int defense) {
        super(name, value);
        aDefense = defense;
    }

    public static int Use(CompactStats stats, CompactModifiers mods, int damage, String name) {
        return Defend(stats, mods, damage, name);
    }

    private static int Defend(CompactStats stats, CompactModifiers mods, int damage, String name) {
        int calculatedDamage = damage;

        calculatedDamage = calculatedDamage - aDefense;

        if (calculatedDamage < 0) {
            calculatedDamage = 0;
        }

        GameSingleton.Say(name + " is defending with their " + iName + ", reducing the damage to " Integer.toString(calculatedDamage));

        return calculatedDamage;
    }
}