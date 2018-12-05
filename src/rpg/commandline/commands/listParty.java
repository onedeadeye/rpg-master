package rpg.commandline.commands;
import rpg.*;
import rpg.commandline.*;
import rpg.renderengine.*;

public class listParty extends Command {

    public listParty(String args, Player player, World world) {
        player.ListPartyStatus();
    }

}