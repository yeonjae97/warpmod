package com.example.warpmod.events;

import com.example.warpmod.WarpMod;
import com.example.warpmod.commands.ReturnHomeCommand;
import com.example.warpmod.commands.SetHomeCommand;
import com.example.warpmod.commands.WarpCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = WarpMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());
        new WarpCommand(event.getDispatcher());
        ConfigCommand.register(event.getDispatcher());
    }



    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event){
        if(!event.getOriginal().getEntityWorld().isRemote()){
            event.getPlayer().getPersistentData().putIntArray(WarpMod.MOD_ID+"homepos",
                    event.getOriginal().getPersistentData().getIntArray(WarpMod.MOD_ID + "homepos"));
        }
    }
}
