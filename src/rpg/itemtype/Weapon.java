package rpg.itemtype;
import rpg.*;

public class Weapon extends Item {
    private int wDamage;
    private boolean wIsMelee;
    private boolean wIsMagical;

    public Weapon(String name, int value, int damage, boolean melee, boolean magical) {
        super(name, value);
        wDamage = damage;
        wIsMelee = melee;
        wIsMagical = magical;
    }

    public int use(CompactStats stats, CompactModifiers mods, String name) {
        return attack(stats, mods, name);
    }

    private int attack(CompactStats stats, CompactModifiers mods, String name) {
        int calculatedDamage = wDamage;

        if (wIsMelee) {
            calculatedDamage = calculatedDamage * ((stats.statStrength / 100) + 1);
            calculatedDamage = Math.round(calculatedDamage * (mods.modifierPhysicalAttack + 1));
        } else {
            calculatedDamage = Math.round(calculatedDamage * (mods.modifierRangedAttack + 1));
        }

        if (wIsMagical) {
            calculatedDamage = calculatedDamage * ((stats.statIntuition / 100) + 1);
            calculatedDamage = Math.round(calculatedDamage * (mods.modifierMagicalAttack + 1));
        }

        Game.say(name + " is attacking for " + Integer.toString(wDamage) + " damage with their " + iName);

        return calculatedDamage;
    }
}