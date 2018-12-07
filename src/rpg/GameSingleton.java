package rpg;
import rpg.classes.*;
import rpg.renderengine.*;
import rpg.commandline.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameSingleton {

    private static GameSingleton game = new GameSingleton();

    private GameSingleton() {}

    public static GameSingleton getInstance() {
        return game;
    }

    public static void Say(String input) {
        long waitDuration = 10;
        try {
            for (int index = 0; index <  input.length(); index++) {
                System.out.print(input.charAt(index));
                TimeUnit.MILLISECONDS.sleep(waitDuration);
            }
        } catch (InterruptedException ex) {

        }

        System.out.print('\n');

        return;
    }

    public static void GameLoop(Engine engine, World world, Player player, Scanner scan) {
        while (true) {
            engine.RenderNoBorders();
            String input = scan.nextLine();
            CLHandler.CallCommand(input, player, world);
        }
    }

    public static void BattleLoop(PlayerCharacter player, Enemy enemy) {
        CompactStats playerStats = player.GetStats();
        CompactModifiers playerMods = player.GetMods();

        CompactStats enemyStats = enemy.GetStats();
        CompactModifiers enemyMods = enemy.GetMods();

        boolean playerFirst = false;

        Say(player.GetName() + " and " + enemy.GetName() + " have entered a battle!");

        while (true) {

            if (playerStats.statSpeed > enemyStats.statSpeed) {
                playerFirst = true;
                Say(player.GetName() + " has the initiative!");
            } else {
                Say(enemy.GetName() + " has the initiative!");
            }

            if (playerFirst) {
                enemy.Defend(player.Attack());
                player.Defend(enemy.Attack());
            } else {
                player.Defend(enemy.Attack());
                enemy.Defend(player.Attack());
            }

            if (player.IsFainted()) {
                Say("Battle ends in defeat!");
                break;
            }

            if (enemy.IsFainted()) {
                Say("Battle ends in victory!");
                
            }
        }
    }
}