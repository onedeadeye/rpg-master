package rpg;

import rpg.classes.*;
import rpg.commandline.CLHandler;
import rpg.renderengine.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		say("Welcome to the pre-alpha version of rpg-master!");
		say("What is your name?");
		String input = "";
		input = scan.nextLine();
		Player player = new Player(input);
		say("Hello, " + player.getName());
		say("This game has you lead a band of intrepid explorers across the world");
		say("What is your first adventurer's name?");
		input = scan.nextLine();
		PlayerCharacter newCharacter = new PlayerCharacter(input, 1, KnightClass.makeClass());
		KnightClass.initializeClassGear(newCharacter);
		player.addCharacter(newCharacter);
		player.listPartyStatus();
		player.addCharacter(newCharacter);

		World world = new World("test world");
		Engine engine = new Engine(player, world);

		gameLoop(engine, world, player, scan);

		scan.close();
	}

	public static void say(String input) {

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
			engine.renderNoBorders();
			// BattleLoop(player.GetPartyFighter(), EnemyDict.GoblinEnemy);
			String input = scan.nextLine();
			CLHandler.callCommand(input, player, world);
		}
	}

	public static void battleLoop(PlayerCharacter player, Enemy enemy) {
		int playerSpeed = player.getStats().statSpeed;

		int enemySpeed = enemy.getStats().statSpeed;

		boolean playerFirst = false;

		say(player.getName() + " and " + enemy.getName() + " have entered a battle!");

		if (player.isFainted()) {
			say(player.getName() + " has fainted and is unable to battle!");
		}

		while (true) {

			if (playerSpeed > enemySpeed) {
				playerFirst = true;
				say(player.getName() + " has the initiative!");
			} else {
				say(enemy.getName() + " has the initiative!");
			}

			if (playerFirst) {
				enemy.defend(player.attack());
				player.defend(enemy.attack());
			} else {
				player.defend(enemy.attack());
				enemy.defend(player.attack());
			}
			player.checkStatus();
			enemy.checkStatus();

			if (player.isFainted()) {
				say("Battle ends in defeat!");
				break;
			}

			if (enemy.isFainted()) {
				say("Battle ends in victory!");

			}
		}
	}

}