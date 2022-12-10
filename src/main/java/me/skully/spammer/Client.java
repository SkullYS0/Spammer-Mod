package me.skully.spammer;

import me.skully.spammer.commands.Command;
import me.skully.spammer.listeners.cmds;
import me.skully.spammer.utils.HWIDUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "spammer",
        name = "Spammer",
        version = "2"
)
public class Client {
    public static Client INSTANCE;
    public static final String MODID = "spammer";
    public static final String NAME = "Spammer";
    private static Logger logger;
    HWIDUtils hwid = new HWIDUtils();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        INSTANCE = this;
        Command.execcommads();
        hwid.check();
        MinecraftForge.EVENT_BUS.register(new cmds());
    }
}
