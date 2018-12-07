package rpg;
import rpg.*;
import rpg.itemtype.*;

public class Enemy extends Actor {

    private float weaponDropChance = 0.5f;
    private float armorDropChance = 0.5f;

    public Enemy(String name, int level, CompactStats stats, CompactModifiers mods) {
        super(name, level, stats, mods);
    }

    public void CheckStatus() {
        CalculateStatics();
        CheckHealth();
    }

    public int DefeatXP() {
        return 10 * (aLevel * aLevel);
    }

    public Weapon DefeatWeapon() {
        if (Math.random() * 100 = weaponDropChance * 100) {
            return aWeapon;
        } else {
            return null;
        }
    }

    public Armor DefeatArmor() {
        if (Math.random() * 100 <= armorDropChance * 100) {
            return aArmor;
        } else {
            return null;
        }
    }
}