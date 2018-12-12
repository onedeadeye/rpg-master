package rpg.commandline;
import rpg.commandline.commands.*;
import rpg.*;
import rpg.renderengine.*;

public final class CLHandler {

    private CLHandler() {

    }

    public static void CallCommand(String command, Player player, World world) {
        int commandEndIndex = 0;
        char[] chars = command.toCharArray();
        for (char c : chars) {
            if (c == chars[chars.length - 1]) {
                commandEndIndex++;
                break;
            } else {
                if (c == ' ') {
                    break;
                }
            }
            commandEndIndex++;
        }

        GameSingleton.Say("Command is " + Integer.toString(commandEndIndex) + " characters long");

        String splitCommand = "";
        String args = "";
        
        splitCommand = command.substring(0, commandEndIndex);
        args = command.substring(commandEndIndex, command.length());
        args = args.substring(1);

        String[] splitArgs = args.split("\\s+");

        //System.out.println("Calling " + splitCommand + " with args " + args);

        if (splitCommand.equals("move")) {
            new move(splitArgs, player, world);
        }

        if (splitCommand.equals("moveWorldSpace")) {
            new moveWorldSpace(splitArgs, player, world);
        }

        if (splitCommand.equals("say")) {
            new say(args, player, world);
        }

        if (splitCommand.equals("listParty")) {
            new listParty(args, player, world);
        }

        if (splitCommand.equals("listCommands")) {
            new listCommands();
        }
    }
}