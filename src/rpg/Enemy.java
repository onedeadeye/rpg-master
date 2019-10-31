package rpg;
import rpg.itemtype.*;

public class Enemy extends Actor {

    private float weaponDropChance = 0.5f;
    private float armorDropChance = 0.5f;

    public Enemy(String name, CompactStats stats, CompactModifiers mods, Weapon weapon, Armor armor) {
        super(name, stats, mods);
        setWeapon(weapon);
        setArmor(armor);
    }

    public void checkStatus() {
        calculateStatics();
        checkHealth();
    }

    public int defeatXP() {
        return 10 * (aStats.getStats().getTotal());
    }

    public Weapon defeatWeapon() {
        if (Math.random() * 100 == weaponDropChance * 100) {
            return aWeapon;
        } else {
            return null;
        }
    }

    public Armor defeatArmor() {
        if (Math.random() * 100 <= armorDropChance * 100) {
            return aArmor;
        } else {
            return null;
        }
    }
}