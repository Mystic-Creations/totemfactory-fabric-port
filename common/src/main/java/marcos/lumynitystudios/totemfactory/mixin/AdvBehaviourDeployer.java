package marcos.lumynitystudios.totemfactory.mixin;

import com.simibubi.create.content.kinetics.deployer.DeployerBlock;
import marcos.lumynitystudios.totemfactory.createResources.AdvancementBehavior;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DeployerBlock.class)
public abstract class AdvBehaviourDeployer {
    @Inject(method = "setPlacedBy", at = @At("TAIL"))
    private void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack, CallbackInfo ci) {
        AdvancementBehavior.setPlacedBy(pLevel, pPos, pPlacer);
    }
}
