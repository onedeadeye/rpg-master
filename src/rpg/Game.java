package rpg;
import rpg.classes.*;
import rpg.renderengine.*;
import rpg.commandline.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    
    private static GameSingleton game = GameSingleton.getInstance();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        game.Say("Welcome to the pre-alpha version of rpg-master!");
        game.Say("What is your name?");
        String input = "";
        input = scan.nextLine();
        Player player = new Player(input);
        game.Say("Hello, " + player.GetName());
        game.Say("This game has you lead a band of intrepid explorers across the world");
        game.Say("What is your first adventurer's name?");
        input = scan.nextLine();
        PlayerCharacter newCharacter = new PlayerCharacter(input, 1, KnightClass.MakeClass());
        player.AddCharacter(newCharacter);
        player.ListPartyStatus();
        player.AddCharacter(newCharacter);

        World world = new World("test world");
        Engine engine = new Engine(player, world);

        game.GameLoop(engine, world, player, scan);

        scan.close();
    }

}