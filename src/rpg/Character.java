package rpg;

public class Character extends Actor {

    private Class cClass;

    private int cExperience;

    public Character(String name, int level, CompactStats stats, CompactModifiers mods, Class newClass) {
        super(name, level, stats, mods);
        cClass = newClass;
    }

    private void CheckExperience() {
        if (cExperience > (aLevel * aLevel) * (cClass.GetLevelSpeed() + 1) + 100 * aLevel) {
            aLevel += 1;
            //TODO make this for real
        }
        return;
    }

    public void CheckStatus() {
        CheckExperience();
        CalculateStatistics();
        CheckHealth();
    }
}