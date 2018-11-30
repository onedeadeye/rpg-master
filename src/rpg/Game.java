package rpg;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to the pre-alpha version of textrpg");
        System.out.println("what is your name?");
        Player player = new Player("test");
        System.out.println("Hello, " + player.GetName());
    }
}