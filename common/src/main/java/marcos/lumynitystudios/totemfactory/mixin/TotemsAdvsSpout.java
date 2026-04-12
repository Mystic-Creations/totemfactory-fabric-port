package marcos.lumynitystudios.totemfactory.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import marcos.lumynitystudios.totemfactory.createResources.CreateAdvancementHelper;
import marcos.lumynitystudios.totemfactory.init.TfAdvancements;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SpoutBlockEntity.class)
public abstract class TotemsAdvsSpout {
    @Inject(method = "addBehaviours", at = @At("TAIL"), remap = false)
    private void addCustomAdvancementBehaviours(List<BlockEntityBehaviour> behaviours, CallbackInfo ci) {
        CreateAdvancementHelper.registerAwardables(
            (SmartBlockEntity)(Object)this,
            behaviours,
            TfAdvancements.THOUSAND_TOTEMS,
            TfAdvancements.FIRST_TOTEM
        );
    }

    @Unique
    private int totemfactory$totemsCreated = 0;

    @Inject(method = "whenItemHeld", at = @At("TAIL"), remap = false)
    private void countTotems(CallbackInfoReturnable<BeltProcessingBehaviour.ProcessingResult> cir, @Local ItemStack result) {
        SpoutBlockEntity self = (SpoutBlockEntity)(Object)this;

        if (result.is(Items.TOTEM_OF_UNDYING)) {
            totemfactory$totemsCreated += result.getCount();
        }

        if (totemfactory$totemsCreated >= 1) {
            CreateAdvancementHelper.award(self, TfAdvancements.FIRST_TOTEM);
        }

        if (totemfactory$totemsCreated >= 1000) {
            CreateAdvancementHelper.award(self, TfAdvancements.THOUSAND_TOTEMS);
            totemfactory$totemsCreated = 0;
        }
    }

    @Inject(method = "read", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/blockEntity/SmartBlockEntity;read(Lnet/minecraft/nbt/CompoundTag;Lnet/minecraft/core/HolderLookup$Provider;Z)V"))
    private void loadCreatedTotems(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket, CallbackInfo ci) {
        if (compound.contains("totemfactory:totems_created")) {
            totemfactory$totemsCreated = compound.getInt("totemfactory:totems_created");
        }
    }

    @Inject(method = "write", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/blockEntity/SmartBlockEntity;write(Lnet/minecraft/nbt/CompoundTag;Lnet/minecraft/core/HolderLookup$Provider;Z)V"))
    private void saveCreatedTotems(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket, CallbackInfo ci) {
        compound.putInt("totemfactory:totems_created", totemfactory$totemsCreated);
    }
}


