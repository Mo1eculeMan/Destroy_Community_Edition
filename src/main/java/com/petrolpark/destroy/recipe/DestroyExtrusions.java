package com.petrolpark.destroy.recipe;

import com.petrolpark.destroy.block.DestroyBlocks;
import com.petrolpark.destroy.block.FastCoolingMoltenPillarBlock;
import com.petrolpark.destroy.util.BlockExtrusion;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class DestroyExtrusions {
    
    public static void register() {
        // Vanilla
        BlockExtrusion.register(Blocks.QUARTZ_BLOCK, (state, direction) -> Blocks.QUARTZ_PILLAR.defaultBlockState().setValue(BlockStateProperties.AXIS, direction.getAxis()));
        BlockExtrusion.register(Blocks.PURPUR_BLOCK, (state, direction) -> Blocks.PURPUR_PILLAR.defaultBlockState().setValue(BlockStateProperties.AXIS, direction.getAxis()));

        // Destroy
        BlockExtrusion.register(DestroyBlocks.CORDITE_BLOCK.get(), (state, direction) -> DestroyBlocks.EXTRUDED_CORDITE_BLOCK.getDefaultState().setValue(BlockStateProperties.AXIS, direction.getAxis()));
        BlockExtrusion.register(DestroyBlocks.MOLTEN_STAINLESS_STEEL.get(), (state, direction) -> DestroyBlocks.STAINLESS_STEEL_RODS.getDefaultState().setValue(BlockStateProperties.AXIS, direction.getAxis()).setValue(FastCoolingMoltenPillarBlock.MOLTEN, true));
        BlockExtrusion.register(DestroyBlocks.MOLTEN_BOROSILICATE_GLASS.get(), (state, direction) -> DestroyBlocks.BOROSILICATE_GLASS_FIBER.getDefaultState().setValue(BlockStateProperties.AXIS, direction.getAxis()).setValue(FastCoolingMoltenPillarBlock.MOLTEN, true));
        BlockExtrusion.register(DestroyBlocks.MASHED_POTATO_BLOCK.get(), (state, direction) -> DestroyBlocks.RAW_FRIES_BLOCK.getDefaultState().setValue(BlockStateProperties.AXIS, direction.getAxis()));
        BlockExtrusion.register(Blocks.CLAY, (state, direction) -> DestroyBlocks.CLAY_MONOLITH.getDefaultState().setValue(RotatedPillarBlock.AXIS, direction.getAxis()));
        BlockExtrusion.register(DestroyBlocks.PORKCHOP_BLOCK.get(), (state, direction) -> DestroyBlocks.BACON_BLOCK.getDefaultState().setValue(BlockStateProperties.AXIS, direction.getAxis()));
    };
};
