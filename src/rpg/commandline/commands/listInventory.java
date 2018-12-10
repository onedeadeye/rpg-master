package rpg.commandline.commands;
import rpg.*;
import rpg.commandline.*;
import rpg.renderengine.*;

public class listInventory extends Command {

    public listInventory(String args, Player player, World world) {
        player.ListPartyStatus();
    }

}