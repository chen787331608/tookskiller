package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnPlayerInteract {

    public static final OnPlayerInteract INSTANCE = new OnPlayerInteract();

    public static BlockPos tp_pos = new BlockPos(0, 0, 0);

    @SubscribeEvent( priority = EventPriority.HIGH )
    public void onPlayerRightClick( PlayerInteractEvent.RightClickBlock e ) {

        EntityPlayer p = e.getEntityPlayer();

        if( p.getHeldItemMainhand().getItem() == Items.WHEAT_SEEDS) {

            // p.setSpawnPoint( e.getPos(), true );
            tp_pos = e.getPos();
            p.sendStatusMessage( new TextComponentString(TextFormatting.RED + "#LAU:" + TextFormatting.WHITE + " Teleport point set at " + e.getPos() ), true );
        }
    }

    @SubscribeEvent ( priority = EventPriority.HIGH )
    public void onPlayerLeftClick( PlayerInteractEvent.LeftClickEmpty e ) {

        EntityPlayer p = e.getEntityPlayer();

        if( p.getHeldItemMainhand().getItem() == Items.WHEAT_SEEDS ) {

            BlockPos bed_pos = p.getBedLocation( p.dimension );
            BlockPos c = tp_pos;
            double px = c.getX() + 0.5;
            double py = c.getY() + 1;
            double pz = c.getZ() + 0.5;

            System.out.println(bed_pos);

            MinecraftServer s = FMLCommonHandler.instance().getMinecraftServerInstance();
            s.getCommandManager().executeCommand( s, "/tp " + p.getName() + " " + px + " " + py + " " + pz );
            p.sendStatusMessage( new TextComponentString( TextFormatting.RED + "#LAU:" + TextFormatting.WHITE + " Telporting to " + c ), true );
        }
    }
}
