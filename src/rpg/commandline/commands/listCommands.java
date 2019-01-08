package rpg.commandline.commands;
import rpg.commandline.*;
import rpg.*;

public class listCommands extends Command {

    public listCommands () {
        Game.Say("listCommands - No arguments. Does what you are reading now.");
        Game.Say("listInventory - No arguments.Lists the contents of your inventory sorted by item type");
        Game.Say("listParty - No arguments. Lists your party name, and the name/level/class of your party members");
        Game.Say("move <x> <y> - Moves the player by (x, y) relative to their position");
        Game.Say("moveWorldSpace <x> <y> - Moves the player to position (x, y) in world space");
        Game.Say("say <message> - Prints your party name and <message> to the console. Will be used for multiplayer");
    }

}