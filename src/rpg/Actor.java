package rpg;
import rpg.itemtype.*;

public class Actor {

    protected String aName;

    protected StatSheet aStats;

    private boolean fainted = false;
    private int aMaxHP;
    private int aHP;

    protected Weapon aWeapon;
    protected Armor aArmor;

    public Actor(String name, CompactStats stats, CompactModifiers mods) {
        aName = name;
        aStats = new StatSheet(stats, mods);
    }

    public String GetName() {
        return aName;
    }

    public CompactStats GetStats() {
        return aStats.GetStats();
    }

    public CompactModifiers GetMods() {
        return aStats.GetModifiers();
    }

    public void CheckStatus() {
        CheckHealth();
        CalculateStatics();
    }

    protected void CheckHealth() {
        if (aHP < aMaxHP) {
            fainted = true;
            GameSingleton.Say(aName + " has fainted!");
        } else {
            GameSingleton.Say(aName + " has " + aHP + "/" + aMaxHP + " remaining.");
        }
        return;
    }

    protected void CalculateStatics() {
        CompactStats stats = aStats.GetStats();
        aMaxHP = stats.statVitality;
    }

    public void TakeDamage(int damage) {
        aHP -= damage;
        CheckStatus();
    }

    public int Attack() {
        return aWeapon.Use(aStats.GetStats(), aStats.GetModifiers(), aName);
    }

    public int Defend(int damage) {
        return aArmor.Use(aStats.GetStats(), aStats.GetModifiers(), damage, aName);
    }

    public void SetWeapon(Weapon weapon) {
        aWeapon = weapon;
    }

    public void SetArmor(Armor armor) {
        aArmor = armor;
    }

    public boolean IsFainted() {
        return fainted;
    }
}