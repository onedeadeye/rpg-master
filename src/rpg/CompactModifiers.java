package rpg;

public class CompactModifiers {
    public float modifierPhysicalAttack;
    public float modifierRangedAttack;
    public float modifierMagicalAttack;
    public float modifierPhysicalDefense;
    public float modifierRangedDefense;
    public float modifierMagicalDefense;
    public float modifierSpellCost;

    public CompactModifiers(float physicalAtt, float rangedAtt, float magicalAtt, float physicalDef, float rangedDef, float magicalDef, float spellCost) {
        modifierPhysicalAttack = physicalAtt;
        modifierRangedAttack = rangedAtt;
        modifierMagicalAttack = magicalAtt;
        modifierPhysicalDefense = physicalDef;
        modifierRangedDefense = rangedDef;
        modifierMagicalDefense = magicalDef;
        modifierSpellCost = spellCost;
    }
}