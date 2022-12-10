package me.skully.spammer.utils;

import me.skully.spammer.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

import java.awt.*;

public class ChatUtils {

    static final String prefix = Client.NAME + "| ";
    static Minecraft mc = Minecraft.getMinecraft();

    public static void sendMessage(String message){
        mc.player.sendMessage(new TextComponentString(prefix + message));
    }

}
