package rpg.dictionaries;
import rpg.Enemy;
import rpg.*;

public final class EnemyDict {

    private static CompactStats weakStats = new CompactStats(1, 1, 1, 1, 1, 1);
    private static CompactModifiers weakMods = new CompactModifiers(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);

    public static Enemy GoblinEnemy = new Enemy("Goblin", weakStats, weakMods, WeaponDict.GoblinSwordWeapon, ArmorDict.GoblinHideArmor);
}