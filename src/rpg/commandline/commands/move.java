package rpg.commandline.commands;
import rpg.commandline.Command;
import rpg.*;
import rpg.renderengine.*;

public class move extends Command {

    public move(String[] args, Player player, World world) {
        // try {
            
        // } catch (Exception ex) {
        //     System.out.println("that didn't work bud");
        // }
        try {
            if (player.move(Integer.parseInt(args[0]), Integer.parseInt(args[1]), world)) {
                Game.say("Moved " + player.getName() + " by " + Integer.parseInt(args[0]) + ", " + Integer.parseInt(args[1]));
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            Game.say("Incorrect parameters for command 'move', proper format is 'move <x> <y>'");
            return;
        }
    }
}