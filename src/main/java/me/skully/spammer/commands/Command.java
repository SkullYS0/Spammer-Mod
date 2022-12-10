package me.skully.spammer.commands;

import me.skully.spammer.commands.cmds.*;
import net.minecraftforge.common.MinecraftForge;

import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Command {

    public static CopyOnWriteArrayList<Command> commands = new CopyOnWriteArrayList();
    private String name;
    private String description;
    private String usage;

    private Category category;
    private boolean toggle;
    public String getUsage() {
        return usage;
    }
    public String getName() {
        return name;
    }
    public Command(String name, String description, String usage, Category category){
        this.name = name;
        this.description = description;
        this.usage = usage;

        this.category = category;
    }

    public void send(String[] args){MinecraftForge.EVENT_BUS.register(this);}

    public boolean isToggled(){
        return this.toggle;
    }

    public void setToggled(boolean toggle){
        this.toggle = toggle;
    }

    public void toggle(){
        this.toggle = !toggle;
    }

    public enum Category {
        INFO,
        SPAM;

    }

    public String getDescription(){
        return this.description;
    }
    public Category getCategory(){
        return this.category;
    }

    public static void execcommads(){
        commands.add(new StartSpam());
        commands.add(new Help());
    }

}