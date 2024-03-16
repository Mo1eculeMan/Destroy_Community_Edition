package com.petrolpark.destroy.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.petrolpark.destroy.block.DestroyBlocks;
import com.petrolpark.destroy.fluid.DestroyFluids;
import com.simibubi.create.content.fluids.OpenEndedPipe;
import com.simibubi.create.infrastructure.config.AllConfigs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;

@Mixin(OpenEndedPipe.class)
public abstract class OpenEndedPipeMixin {

    @Shadow
    private Level world;

    @Shadow
    private BlockPos outputPos;
    
    @Inject(
        method = "Lcom/simibubi/create/content/fluids/OpenEndedPipe;provideFluidToSpace(Lnet/minecraftforge/fluids/FluidStack;Z)Z",
        at = @At("HEAD"),
        cancellable = true,
        remap = false
    )
    private void inProvideFluidToSpace(FluidStack stack, boolean simulate, CallbackInfoReturnable<Boolean> cir) {
        if (
            world != null
            && world.isLoaded(outputPos)
            && world.getBlockState(outputPos).canBeReplaced()
            && stack.getFluid().isSame(DestroyFluids.MOLTEN_STAINLESS_STEEL.get())
            && AllConfigs.server().fluids.pipesPlaceFluidSourceBlocks.get()
        ) {
            if (simulate && stack.getAmount() == 1000) world.setBlockAndUpdate(outputPos, DestroyBlocks.MOLTEN_STAINLESS_STEEL.getDefaultState());
            cir.setReturnValue(true); //TODO FluidHelper mixin
            cir.cancel();
        };
    };
};
