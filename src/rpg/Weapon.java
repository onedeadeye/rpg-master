package rpg;

public class Weapon extends Item {
    private int wDamage;
    private boolean wIsMelee;
    private boolean wIsMagical;

    public Weapon(String name, int value, float weight, int damage, boolean melee, boolean magical) {
        super(name, value, weight);
        wDamage = damage;
        wIsMelee = melee;
        wIsMagical = magical;
    }

    public int Use(CompactStats stats, CompactModifiers mods) {
        return Attack(stats, mods);
    }

    private int Attack(CompactStats stats, CompactModifiers mods) {
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

        return calculatedDamage;
    }
}