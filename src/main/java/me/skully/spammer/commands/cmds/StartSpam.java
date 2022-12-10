package me.skully.spammer.commands.cmds;

import me.skully.spammer.commands.Command;
import me.skully.spammer.utils.ChatUtils;
import me.skully.spammer.utils.Generator;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class StartSpam extends Command {

    boolean enabled = true;

    public StartSpam(){
        super("Spammer", "Start a spam. [stop/sum of a symbols], [time], [text]", ".spam", Category.SPAM);
    }

    public void main(String args[]) {

        ArrayList<String> arrLis = new ArrayList<String>(Arrays.asList(args));

        arrLis.remove(args[0]);
        arrLis.remove(args[1]);
        arrLis.remove(args[2]);

        new Thread(new Runnable() {
            public void run() {
                while (enabled) {
                    try {
                        String text = "";

                        for (String s : arrLis)
                        {
                            text += s + " ";
                        }
                        Thread.sleep(Long.parseLong(args[2]));
                        System.out.println(args);
                        Minecraft.getMinecraft().player.connection.sendPacket(new CPacketChatMessage(text + " " + Generator.generateRandomWord(Integer.parseInt(args[1]))));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void send(String[] args) {
        if(args.length > 1) {
        if(args[1].equalsIgnoreCase("stop") || args[1].equalsIgnoreCase("exit") || args[1].equalsIgnoreCase("����") || args[1].equalsIgnoreCase("����")) {
            enabled = false;
            ChatUtils.sendMessage("Stopped");
            }else if(args.length > 3){
            enabled = true;
            main(args);
        }
        } else{
            ChatUtils.sendMessage("Please see .help usage message");
        }
    }
}