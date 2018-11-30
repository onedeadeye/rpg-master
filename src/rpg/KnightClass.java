public class KnightClass extends CharacterClass {
  
  public KnightClass(String name, float levelSpeed) {
    super(name, levelSpeed);
    cStartingStats = new CompactStats(1, 1, 1, 1, 1, 1);
    cStartingMods = new CompactMods(0, 0, 0, 0, 0, 0, 0);
  }
  
}
