package marcos.mysticcreationsteam.totemfactory.mixin;

import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.deployer.BeltDeployerCallbacks;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import marcos.mysticcreationsteam.totemfactory.createResources.CreateAdvancementHelper;
import marcos.mysticcreationsteam.totemfactory.init.TfAdvancements;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeltDeployerCallbacks.class)
public class ThousandTotemsAdvDeployer {

    @Inject(
        method = "onItemReceived",
        at = @At("TAIL")
    )
    private static void countTotems(
        TransportedItemStack s, TransportedItemStackHandlerBehaviour i, DeployerBlockEntity blockEntity, CallbackInfoReturnable<BeltProcessingBehaviour.ProcessingResult> cir
    ) {
        ItemStack result = stack.stack;

        if (!result.is(Items.TOTEM_OF_UNDYING))
            return;

        CreateAdvancementHelper.incrementAndAward(
            deployer,
            TfAdvancements.THOUSAND_TOTEMS,
            result.getCount(),
            1000
        );
    }
}

