package marcos.lumynitystudios.totemfactory.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.deployer.BeltDeployerCallbacks;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import marcos.lumynitystudios.totemfactory.createResources.CreateAdvancementHelper;
import marcos.lumynitystudios.totemfactory.createResources.TotemFactoryDeployerExtension;
import marcos.lumynitystudios.totemfactory.init.TfAdvancements;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeltDeployerCallbacks.class)
public class TotemsAdvsDeployer {

    @Inject(method = "activate", at = @At("TAIL"), remap = false)
    private static void countTotems(
        TransportedItemStack stack, TransportedItemStackHandlerBehaviour handler, DeployerBlockEntity blockEntity, Recipe<?> recipe, CallbackInfo ci,
        @Local(ordinal = 0) ItemStack result
    ) {
        if (!result.is(Items.TOTEM_OF_UNDYING))
            return;

        //noinspection RedundantCast
        TotemFactoryDeployerExtension extension = (TotemFactoryDeployerExtension) (Object) blockEntity;
        extension.totemFactory$setTotemsCreated(extension.totemfactory$getTotemsCreated() + result.getCount());

        if (extension.totemfactory$getTotemsCreated() >= 1) {
            CreateAdvancementHelper.award(blockEntity, TfAdvancements.FIRST_TOTEM);
        }

        if (extension.totemfactory$getTotemsCreated() >= 1000) {
            CreateAdvancementHelper.award(blockEntity, TfAdvancements.THOUSAND_TOTEMS);
            extension.totemFactory$setTotemsCreated(0);
        }
    }
}

