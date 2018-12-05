package rpg;

public class PlayerCharacter extends Actor {

    private CharacterClass cClass;

    private int cExperience;

    public PlayerCharacter(String name, int level, CharacterClass newClass) {
        super(name, level, newClass.getStartingStats(), newClass.getStartingMods());
        cClass = newClass;
    }

    private float EXPAtLevel(int level) {
        return((0.5f*level) + 10);
    }

    private void CheckExperience() {
        if (cExperience > EXPAtLevel(aLevel) + EXPAtLevel(aLevel + 1)) {
            aLevel += 1;
        }
        return;
    }

    public void CheckStatus() {
        CheckExperience();
        CalculateStatics();
        CheckHealth();
    }
}