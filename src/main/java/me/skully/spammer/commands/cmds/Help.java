package me.skully.spammer.commands.cmds;

import me.skully.spammer.commands.Command;
import me.skully.spammer.utils.ChatUtils;

import java.awt.*;

public class Help extends Command {
    public Help(){
        super("Help", "SHOW A HELP", ".help",Category.INFO);
    }

    @Override
    public void send(String[] args) {
        for (Command c : commands) {
            ChatUtils.sendMessage("=--------- "+ c.getCategory().name() +" ---------=");
            ChatUtils.sendMessage("=------- "+c.getName() +" NAME -------=");
            ChatUtils.sendMessage("=------- "+ c.getUsage()+" USAGE -------=");
            ChatUtils.sendMessage("=------- "+ c.getDescription()+" DESCRIPTION -------=");
        }
        ChatUtils.sendMessage("</> DEVELOPER @SkullYS0 | TG | skully#8077 | DS </>");
    }

}
