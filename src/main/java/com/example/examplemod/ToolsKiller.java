package com.example.examplemod;

import com.example.examplemod.block.ModBlocks;
import com.example.examplemod.item.ModItems;
import com.example.examplemod.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = ToolsKiller.MODID, name = ToolsKiller.NAME, version = ToolsKiller.VERSION)
public class ToolsKiller {
    public static final String MODID = "toolskill";
    public static final String NAME = "Tools Killer";
    public static final String VERSION = "${version}";

    private static Logger logger;

    @Mod.Instance(MODID)
    public static ToolsKiller instance;

    @SidedProxy(serverSide = "com.example.examplemod.proxy.CommonProxy", clientSide = "com.example.examplemod.proxy.ClientProxy")
    public static CommonProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info(NAME + " is loading!");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.addSmelting(ArticleStacks.DIRT_STACK_1, ArticleStacks.DIAMOND_STACK_1, 1000f);
        GameRegistry.addSmelting(ArticleStacks.WHEAT_SEED, ArticleStacks.EXPERIENCE_BOTTLE, 1000f);

        GameRegistry.addSmelting(ModBlocks.oreCopper, new ItemStack(ModItems.ingotCopper), 1.0f);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(OnPlayerInteract.INSTANCE);

    }


    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }

    @Mod.EventBusSubscriber
    public static class MyForgeEventHandler {
        @SubscribeEvent
        public static void pickupItem(EntityItemPickupEvent event) {
//            logger.info("event-test:实体被捡起");
        }
    }


}
