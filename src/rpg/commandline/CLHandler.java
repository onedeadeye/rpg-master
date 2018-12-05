package rpg.commandline;
import rpg.commandline.commands.*;
import rpg.*;
import rpg.renderengine.*;

public final class CLHandler {

    private CLHandler() {

    }

    public static void CallCommand(String command, Player player, World world) {
        int commandEndIndex = 0;
        loop:
        for (char c : command.toCharArray()) {
            if (c == ' ') {
                break loop;
            }
            commandEndIndex++;
        }
        String splitCommand = command.substring(0, commandEndIndex);
        String args = command.substring(commandEndIndex, command.length());

        args = args.substring(1);

        String[] splitArgs = args.split("\\s+");

        System.out.println("Calling " + splitCommand + " with args " + args);

        if (splitCommand == "move") {
            System.out.println("moving");
            new move(splitArgs, player, world);
        }

        if (splitCommand == "say") {
            System.out.println("saying");
            new say(args, player, world);
        }

        if (splitCommand == "listParty") {
            System.out.println("listing");
            new listParty(args, player, world);
        }
    }
}