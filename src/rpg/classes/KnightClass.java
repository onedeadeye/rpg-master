package rpg.classes;
import rpg.*;

public final class KnightClass extends CharacterClass {
  
  private static float kLevelSpeed = 0f;
  private static CompactStats kStartingStats = new CompactStats(1, 1, 1, 1, 1, 1);
  private static CompactModifiers kStartingMods = new CompactModifiers(0, 0, 0, 0, 0, 0, 0);

  private KnightClass() {
    super("MissingNo", 0f);
  }

  public static CharacterClass MakeClass() {
    CharacterClass ourClass = new CharacterClass("Knight", kLevelSpeed);
    ourClass.setStartingStats(kStartingStats);
    ourClass.setStartingMods(kStartingMods);
    return ourClass;
  }

  public static void FirstSkill() {
    
  }

  public static void SecondSkill() {
    
  }

  public static void ThirdSkill() {
    
  }
  
}