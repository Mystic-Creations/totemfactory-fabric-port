package marcos.mysticcreationsteam.totemfactory.mixin;

import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import marcos.mysticcreationsteam.totemfactory.createResources.CreateAdvancementHelper;
import marcos.mysticcreationsteam.totemfactory.createResources.TotemFactoryDeployerExtension;
import marcos.mysticcreationsteam.totemfactory.init.TfAdvancements;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(DeployerBlockEntity.class)
public abstract class DeployerInjectionMixin implements TotemFactoryDeployerExtension {
    @Unique private int totemfactory$totemsCreated = 0;

    @Inject(method = "addBehaviours", at = @At("TAIL"), remap = false)
    private void addCustomAdvancementBehaviours(List<BlockEntityBehaviour> behaviours, CallbackInfo ci) {
        CreateAdvancementHelper.registerAwardables(
            (SmartBlockEntity) (Object) this,
            behaviours,
            TfAdvancements.THOUSAND_TOTEMS,
            TfAdvancements.FIRST_TOTEM
        );
    }

    @Override
    public int totemfactory$getTotemsCreated() {
        return this.totemfactory$totemsCreated;
    }

    @Override
    public void totemFactory$setTotemsCreated(int created) {
        this.totemfactory$totemsCreated = created;
    }

    @Inject(method = "read", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/kinetics/base/KineticBlockEntity;read(Lnet/minecraft/nbt/CompoundTag;Lnet/minecraft/core/HolderLookup$Provider;Z)V"))
    private void loadCreatedTotems(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket, CallbackInfo ci) {
        if (compound.contains("totemfactory:totems_created")) {
            totemfactory$totemsCreated = compound.getInt("totemfactory:totems_created");
        }
    }

    @Inject(method = "write", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/kinetics/base/KineticBlockEntity;write(Lnet/minecraft/nbt/CompoundTag;Lnet/minecraft/core/HolderLookup$Provider;Z)V"))
    private void saveCreatedTotems(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket, CallbackInfo ci) {
        compound.putInt("totemfactory:totems_created", totemfactory$totemsCreated);
    }
}
