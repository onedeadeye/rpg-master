package rpg;
import rpg.renderengine.*;
import rpg.commandline.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import rpg.dictionaries.*;

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
            BattleLoop(player.GetPartyFighter(), EnemyDict.GoblinEnemy);
            //String input = scan.nextLine();
            //CLHandler.CallCommand(input, player, world);
        }
    }

    public static void BattleLoop(PlayerCharacter player, Enemy enemy) {
        int playerSpeed = player.GetStats().statSpeed;

        int enemySpeed = enemy.GetStats().statSpeed;

        boolean playerFirst = false;

        Say(player.GetName() + " and " + enemy.GetName() + " have entered a battle!");

        if (player.IsFainted()) {
            Say(player.GetName() + " has fainted and is unable to battle!");
        }

        while (true) {

            if (playerSpeed > enemySpeed) {
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
            player.CheckStatus();
            enemy.CheckStatus();

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