package rpg;

public class StatSheet {
    private int statStrength;
    private int statDexterity;
    private int statSpeed;
    private int statVitality;
    private int statDefense;
    private int statIntuition;

    private float modifierPhysicalAttack;
    private float modifierRangedAttack;
    private float modifierMagicalAttack;
    private float modifierPhysicalDefense;
    private float modifierRangedDefense;
    private float modifierMagicalDefense;
    private float modifierSpellCost;

    public StatSheet(CompactStats stats, CompactModifiers mods) {
        statStrength = stats.statStrength;
        statDexterity = stats.statDexterity;
        statSpeed = stats.statSpeed;
        statVitality = stats.statVitality;
        statDefense = stats.statDefense;
        statIntuition = stats.statIntuition;

        modifierPhysicalAttack = mods.modifierPhysicalAttack;
        modifierRangedAttack = mods.modifierRangedAttack;
        modifierMagicalAttack = mods.modifierMagicalAttack;
        modifierPhysicalDefense = mods.modifierPhysicalDefense;
        modifierRangedDefense = mods.modifierRangedDefense;
        modifierMagicalDefense = mods.modifierMagicalDefense;
        modifierSpellCost = mods.modifierSpellCost;
    }

    public void setStats(int strength, int dexterity, int speed, int vitality, int defense, int intuition) {
        statStrength = strength;
        statDexterity = dexterity;
        statSpeed = speed;
        statVitality = vitality;
        statDefense = defense;
        statIntuition = intuition;
    }

    public CompactStats getStats() {
        return new CompactStats(statStrength, statDexterity, statSpeed, statVitality, statDefense, statIntuition);
    }

    public void setModifiers(float physicalAtt, float rangedAtt, float magicalAtt, float physicalDef, float rangedDef, float magicalDef, float spellCost) {
        modifierPhysicalAttack = physicalAtt;
        modifierRangedAttack = rangedAtt;
        modifierMagicalAttack = magicalAtt;
        modifierPhysicalDefense = physicalDef;
        modifierRangedDefense = rangedDef;
        modifierMagicalDefense = magicalDef;
        modifierSpellCost = spellCost;
    }

    public CompactModifiers getModifiers() {
        return new CompactModifiers(modifierPhysicalAttack, modifierRangedAttack, modifierMagicalAttack, modifierPhysicalDefense, modifierRangedDefense, modifierMagicalDefense, modifierSpellCost);
    }
}