package rpg.commandline.commands;
import rpg.commandline.Command;
import rpg.*;
import rpg.renderengine.*;

public class moveWorldSpace extends Command {

    public moveWorldSpace(String[] args, Player player, World world) {
        // try {
            
        // } catch (Exception ex) {
        //     System.out.println("that didn't work bud");
        // }
        player.MoveWorldSpace(Integer.parseInt(args[0]), Integer.parseInt(args[1]), world);
        
        GameSingleton.Say("Moved " + player.GetName() + " to " + Integer.parseInt(args[0]) + ", " + Integer.parseInt(args[1]));
    }
}