package com.example.warpmod.commands;

import com.example.warpmod.Colorable;
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

public class WarpCommand implements Colorable {


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
                String pos = "(" + green + x + ", " + blue + y + ", " + yellow + z + ")";
                command.getSource().sendFeedback(new StringTextComponent(pos + "으로 텔레포트 되었습니다."), true);

            return 1;
        })))));
    }

}
