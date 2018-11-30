package rpg;

public class CharacterClass {

    private String cName;
    private float cLevelSpeed;
    
    private CompactStats cStartingStats;
    private CompactModifiers cStartingMods;

    public CharacterClass(String name, float levelSpeed) {
        cName = name;
        cLevelSpeed = levelSpeed;
    }

    public String GetName() {
        return cName;
    }

    public float GetLevelSpeed() {
        return cLevelSpeed;
    }
    
    public CompactStats getStartingStats() {
      return cStartingStats();
    }
  
    public CompactModifiers getStartingMods() {
      return cStartingMods();
    }
}