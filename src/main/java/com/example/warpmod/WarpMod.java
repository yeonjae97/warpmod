package com.example.warpmod;

import com.example.warpmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WarpMod.MOD_ID)
public class WarpMod implements Colorable{

    public static final String MOD_ID = "warpmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public WarpMod(){
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(iEventBus);
        MinecraftForge.EVENT_BUS.register(this);

    }

    @SubscribeEvent
    public void onEnable(FMLServerStartingEvent event) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String rawMessage = blue + "[Warp 플러그인이 활성화 중입니다]" + white;
        byte[] bytes = rawMessage.getBytes(StandardCharsets.UTF_8);
        String utf8Message = new String(bytes, StandardCharsets.UTF_8);
        LOGGER.info(utf8Message);
    }
    
    @SubscribeEvent
    public void onDisable(FMLServerStoppingEvent event) {
        String rawMessage = red + "[Warp 플러그인이 비활성화 중입니다]" + white;
        byte[] bytes = rawMessage.getBytes(StandardCharsets.UTF_8);
        String utf8Message = new String(bytes, StandardCharsets.UTF_8);
        LOGGER.info(utf8Message);
    }



}
