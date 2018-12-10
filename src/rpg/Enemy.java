package rpg;
import rpg.itemtype.*;

public class Enemy extends Actor {

    private float weaponDropChance = 0.5f;
    private float armorDropChance = 0.5f;

    public Enemy(String name, CompactStats stats, CompactModifiers mods, Weapon weapon, Armor armor) {
        super(name, stats, mods);
        SetWeapon(weapon);
        SetArmor(armor);
    }

    public void CheckStatus() {
        CalculateStatics();
        CheckHealth();
    }

    public int DefeatXP() {
        return 10 * (aStats.GetStats().GetTotal());
    }

    public Weapon DefeatWeapon() {
        if (Math.random() * 100 == weaponDropChance * 100) {
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