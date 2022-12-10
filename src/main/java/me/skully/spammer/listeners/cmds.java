package me.skully.spammer.listeners;

import me.skully.spammer.commands.Command;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class cmds {

    @SubscribeEvent
    public void onMessage(ClientChatEvent e) {
        String args[] = e.getMessage().split(" ");
        for(Command cmd : Command.commands) {
            if(Objects.equals(args[0] ,  cmd.getUsage())) {
                e.setCanceled(true);
                cmd.send(args);
            }
        }
    }

}