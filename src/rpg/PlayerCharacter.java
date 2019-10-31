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

    private float expAtLevel(int level) {
        return((0.5f*level) + 10);
    }

    private void checkExperience() {
        if (cExperience > expAtLevel(cLevel) + expAtLevel(cLevel + 1)) {
            cLevel += 1;
        }
        return;
    }

    public CharacterClass getCharacterClass() {
        return cClass;
    }

    public int getLevel() {
        return cLevel;
    }

    public void checkStatus() {
        checkExperience();
        calculateStatics();
        checkHealth();
    }
}