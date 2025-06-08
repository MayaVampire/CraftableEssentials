package net.mayavampire.craftableessentials;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CraftableEssentials.MODID)
public class CraftableEssentials {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "craftable_essentials";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger ();
    // Create a Deferred Register to hold Blocks which will all be registered under the "CraftableEssentials" namespace


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CraftableEssentials(IEventBus modEventBus , ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener ( this::commonSetup );

        // Register the Deferred Register to the mod event bus so block get registered
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (CraftableEssentials) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.


        // Register the item to a creative tab

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info ( "HELLO FROM COMMON SETUP" );

        LOGGER.info ( Config.magicNumberIntroduction + Config.magicNumber );


        // Add the example block item to the building block tab

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to cal
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info ( "HELLO from server starting" );
    }




        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info ( "HELLO FROM CLIENT SETUP" );
            LOGGER.info ( "MINECRAFT NAME >> {}" , Minecraft.getInstance ().getUser ().getName () );
        }
    }