package rpg.classes;
import rpg.*;
import rpg.itemtype.*;
import rpg.dictionaries.*;

public final class KnightClass extends CharacterClass {
  
  private static float kLevelSpeed = 0f;
  private static CompactStats kStartingStats = new CompactStats(1, 1, 1, 1, 1, 1);
  private static CompactModifiers kStartingMods = new CompactModifiers(0, 0, 0, 0, 0, 0, 0);
  private static Weapon kStartingWeapon = WeaponDict.FistsWeapon;
  private static Armor kStartingArmor = ArmorDict.CivClothesArmor;


  private KnightClass() {
    super("MissingNo", 0f);
  }

  public static CharacterClass MakeClass() {
    CharacterClass ourClass = new CharacterClass("Knight", kLevelSpeed);
    ourClass.setStartingStats(kStartingStats);
    ourClass.setStartingMods(kStartingMods);
    return ourClass;
  }

  public static void InitializeClassGear(PlayerCharacter ch) {
    ch.SetWeapon(kStartingWeapon);
    ch.SetArmor(kStartingArmor);
  }

  public static void FirstSkill() {
    
  }

  public static void SecondSkill() {
    
  }

  public static void ThirdSkill() {
    
  }
  
}