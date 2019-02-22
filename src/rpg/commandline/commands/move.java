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
            if (player.Move(Integer.parseInt(args[0]), Integer.parseInt(args[1]), world)) {
                Game.Say("Moved " + player.GetName() + " by " + Integer.parseInt(args[0]) + ", " + Integer.parseInt(args[1]));
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            Game.Say("Incorrect parameters for command 'move', proper format is 'move <x> <y>'");
            return;
        }
    }
}