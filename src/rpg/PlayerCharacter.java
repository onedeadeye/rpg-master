package rpg;

public class PlayerCharacter extends Actor {

    private CharacterClass cClass;

    private int cLevel;
    private int cExperience;

    public PlayerCharacter(String name, int level, CharacterClass newClass) {
        super(name, newClass.getStartingStats(), newClass.getStartingMods());
        cClass = newClass;
        cLevel = level;
    }

    private float EXPAtLevel(int level) {
        return((0.5f*level) + 10);
    }

    private void CheckExperience() {
        if (cExperience > EXPAtLevel(cLevel) + EXPAtLevel(cLevel + 1)) {
            cLevel += 1;
        }
        return;
    }

    public CharacterClass GetClass() {
        return cClass;
    }

    public int GetLevel() {
        return cLevel;
    }

    public void CheckStatus() {
        CheckExperience();
        CalculateStatics();
        CheckHealth();
    }
}