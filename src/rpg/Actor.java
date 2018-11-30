package rpg;

public class Actor {

    protected String aName;
    protected int aLevel;

    protected StatSheet aStats;

    private boolean fainted = false;
    private int aMaxHP;
    private int aHP;

    private Weapon aWeapon;

    public Actor(String name, int level, CompactStats stats, CompactModifiers mods) {
        aName = name;
        aLevel = level;
        aStats = new StatSheet(stats, mods);
    }

    public void CheckStatus() {
        CheckHealth();
        CalculateStatics();
    }

    protected void CheckHealth() {
        if (aHP < aMaxHP) {
            fainted = true;
        }
        return;
    }

    protected void CalculateStatics() {
        CompactStats stats = aStats.GetStats();
        aMaxHP = aLevel * stats.statVitality;
    }

    public void SetWeapon(Weapon weapon) {
        aWeapon = weapon;
    }
}