package rpg;
import rpg.classes.*;
import rpg.renderengine.*;
import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GameSingleton.Say("Welcome to the pre-alpha version of rpg-master!");
        GameSingleton.Say("What is your name?");
        String input = "";
        input = scan.nextLine();
        Player player = new Player(input);
        GameSingleton.Say("Hello, " + player.GetName());
        GameSingleton.Say("This game has you lead a band of intrepid explorers across the world");
        GameSingleton.Say("What is your first adventurer's name?");
        input = scan.nextLine();
        PlayerCharacter newCharacter = new PlayerCharacter(input, 1, KnightClass.MakeClass());
        KnightClass.InitializeClassGear(newCharacter);
        player.AddCharacter(newCharacter);
        player.ListPartyStatus();
        player.AddCharacter(newCharacter);

        World world = new World("test world");
        Engine engine = new Engine(player, world);

        GameSingleton.GameLoop(engine, world, player, scan);

        scan.close();
    }

}