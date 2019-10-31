package rpg;

public class CharacterClass {

    private String cName;
    private float cLevelSpeed;
    
    protected CompactStats cStartingStats;
    protected CompactModifiers cStartingMods;

    public CharacterClass(String name, float levelSpeed) {
        cName = name;
        cLevelSpeed = levelSpeed;
    }

    public String getName() {
        return cName;
    }

    public float GetLevelSpeed() {
        return cLevelSpeed;
    }
    
    public CompactStats getStartingStats() {
      return cStartingStats;
    }

    public void setStartingStats(CompactStats stats) {
        cStartingStats = stats;
    }
  
    public CompactModifiers getStartingMods() {
      return cStartingMods;
    }

    public void setStartingMods(CompactModifiers mods) {
        cStartingMods = mods;
    }
}