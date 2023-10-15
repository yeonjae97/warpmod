package com.example.warpmod.commands;

import com.example.warpmod.WarpMod;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.sun.jna.IntegerType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;

public class WarpCommand {


    public WarpCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("워프")
                .then(Commands.argument("x", IntegerArgumentType.integer())
                .then(Commands.argument("y", IntegerArgumentType.integer())
                .then(Commands.argument("z", IntegerArgumentType.integer())
                .executes((command) -> {
                    ServerWorld world = command.getSource().getWorld();
                    ServerPlayerEntity player = command.getSource().asPlayer();

                int x = command.getArgument("x", Integer.class);
                int y = command.getArgument("y", Integer.class);
                int z = command.getArgument("z", Integer.class);

                player.setPositionAndUpdate(x,y,z);
                String pos = "(" + x + ", " + y + ", " + z + ")";
                command.getSource().sendFeedback(new StringTextComponent(pos + "으로 텔레포트 되었습니다."), true);

            return 1;
        })))));
    }

//    private int warp(CommandSource source) throws CommandSyntaxException {
//        ServerPlayerEntity player = source.asPlayer();
//        int x = source.
//
//        boolean hasHomepos = player.getPersistentData().getIntArray(WarpMod.MOD_ID + "homepos").length != 0;
//
//        if(hasHomepos) {
//            int[] playerPos = player.getPersistentData().getIntArray(WarpMod.MOD_ID + "homepos");
//            player.setPositionAndUpdate(playerPos[0], playerPos[1], playerPos[2]);
//
//            source.sendFeedback(new StringTextComponent(""), true);
//            return 1;
//        } else {
//            source.sendFeedback(new StringTextComponent("No Home Position has been set!"), true);
//            return -1;
//        }
//
//    }
}
