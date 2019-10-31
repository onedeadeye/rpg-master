package rpg.commandline;

import java.util.Arrays;

import rpg.commandline.commands.*;
import rpg.*;
import rpg.renderengine.*;

public final class CLHandler {

    private CLHandler() {

    }

    public static void callCommand(String commandLine, Player player, World world) {
    	System.out.println(commandLine);
    	
    	String[] split = commandLine.split(" ");
    	
    	String cmd = split[0];
    	
    	String[] args = new String[] { "" }; // Sane default    	
    	if (split.length > 1) {
    		args = Arrays.copyOfRange(split, 1, split.length - 1);
    	}
    	
    	String lineArg = commandLine.substring(cmd.length() - 1).trim(); // The trim gets rid of the leading space
    	

        Game.say("Debug: Command is \"" + cmd + "\"");

        


        if (cmd.equals("move")) {
            new move(args, player, world);
        }

        if (cmd.equals("moveWorldSpace")) {
            new moveWorldSpace(args, player, world);
        }

        if (cmd.equals("say")) {
            new say(lineArg, player, world);
        }

        if (cmd.equals("listParty")) {
        	// We can safely pass null here because listParty doesn't care
            new listParty(null, player, world);
        }

        if (cmd.equals("listCommands")) {
            new listCommands();
        }
    }
}