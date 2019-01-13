package rpg;

import rpg.classes.*;
import rpg.commandline.CLHandler;
import rpg.renderengine.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Say("Welcome to the pre-alpha version of rpg-master!");
		Say("What is your name?");
		String input = "";
		input = scan.nextLine();
		Player player = new Player(input);
		Say("Hello, " + player.GetName());
		Say("This game has you lead a band of intrepid explorers across the world");
		Say("What is your first adventurer's name?");
		input = scan.nextLine();
		PlayerCharacter newCharacter = new PlayerCharacter(input, 1, KnightClass.MakeClass());
		KnightClass.InitializeClassGear(newCharacter);
		player.AddCharacter(newCharacter);
		player.ListPartyStatus();
		player.AddCharacter(newCharacter);

		World world = new World("test world");
		Engine engine = new Engine(player, world);

		gameLoop(engine, world, player, scan);

		scan.close();
	}

	public static void Say(String input) {

		// Sleep for this number of milliseconds
		long waitDuration = 10;
		char[] inputAsCharArray = input.toCharArray();

		try {

			// oOoOoO fancy foreach loop (easier to read)
			for (char c : inputAsCharArray) {
				System.out.print(c);
				System.out.flush(); // Ensure  smooth output
				TimeUnit.MILLISECONDS.sleep(waitDuration);
			}
		} catch (InterruptedException ex) {

		}

		// Note: Could also just call println() with no args (and save two bytes of
		// memory lol)
		System.out.print('\n');

		return;
	}

	public static void gameLoop(Engine engine, World world, Player player, Scanner scan) {
		while (true) {
			engine.RenderNoBorders();
			// BattleLoop(player.GetPartyFighter(), EnemyDict.GoblinEnemy);
			String input = scan.nextLine();
			CLHandler.CallCommand(input, player, world);
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