package rpg.commandline.commands;
import rpg.*;
import rpg.commandline.*;
import rpg.renderengine.*;

public class say extends Command {

    public say(String args, Player player, World world) {
        Game.say(player.getName() + ": " + args);
    }

}