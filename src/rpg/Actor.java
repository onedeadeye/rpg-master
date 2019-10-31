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

    public String getName() {
        return aName;
    }

    public CompactStats getStats() {
        return aStats.getStats();
    }

    public CompactModifiers GetMods() {
        return aStats.getModifiers();
    }

    public void checkStatus() {
        checkHealth();
        calculateStatics();
    }

    protected void checkHealth() {
        if (aHP < aMaxHP) {
            fainted = true;
            Game.say(aName + " has fainted!");
        } else {
            Game.say(aName + " has " + aHP + "/" + aMaxHP + " remaining.");
        }
        return;
    }

    protected void calculateStatics() {
        CompactStats stats = aStats.getStats();
        aMaxHP = stats.statVitality;
    }

    public void takeDamage(int damage) {
        aHP -= damage;
        checkStatus();
    }

    public int attack() {
        return aWeapon.use(aStats.getStats(), aStats.getModifiers(), aName);
    }

    public int defend(int damage) {
        return aArmor.use(aStats.getStats(), aStats.getModifiers(), damage, aName);
    }

    public void setWeapon(Weapon weapon) {
        aWeapon = weapon;
    }

    public void setArmor(Armor armor) {
        aArmor = armor;
    }

    public boolean isFainted() {
        return fainted;
    }
}