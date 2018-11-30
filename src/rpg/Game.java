package rpg;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to the pre-alpha version of rpg-master");
        System.out.println("what is your name?");
        Player player = new Player("test");
        System.out.println("Hello, " + player.GetName());
        
        CompactStats stats = new CompactStats(10, 10, 10, 10, 10, 10);
        CompactModifiers mods = new CompactModifiers(0, 0, 0, 0, 0, 0, 0);
        Character newCharacter = new Character("joe shmoe", 1, new KnightClass());
    }
}