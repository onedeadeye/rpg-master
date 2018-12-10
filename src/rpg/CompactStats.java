package rpg;

public class CompactStats {
    public int statStrength;
    public int statDexterity;
    public int statSpeed;
    public int statVitality;
    public int statDefense;
    public int statIntuition;

    public CompactStats(int strength, int dexterity, int speed, int vitality, int defense, int intuition) {
        statStrength = strength;
        statDexterity = dexterity;
        statSpeed = speed;
        statVitality = vitality;
        statDefense = defense;
        statIntuition = intuition;
    }

    public int GetTotal() {
        return statStrength + statDexterity + statSpeed + statVitality + statDefense + statIntuition;
    }
}