package marcos.mysticcreationsteam.totemfactory.mixin;

import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import marcos.mysticcreationsteam.totemfactory.createResources.CreateAdvancementHelper;
import marcos.mysticcreationsteam.totemfactory.init.TfAdvancements;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SpoutBlockEntity.class)
public abstract class ThousandTotemsAdvSpout {
    @Inject(method = "addBehaviours", at = @At("TAIL"))
    private void addCustomAdvancementBehaviours(List<BlockEntityBehaviour> behaviours, CallbackInfo ci) {
        CreateAdvancementHelper.registerAwardables(
            (SmartBlockEntity)(Object)this,
            behaviours,
            TfAdvancements.THOUSAND_TOTEMS
        );
    }

    @Unique
    private int totemsCreated = 0;

    @Inject(method = "process", at = @At("TAIL"))
    private void countTotems(CallbackInfo ci) {
        SpoutBlockEntity self = (SpoutBlockEntity)(Object)this;
        ItemStack result = self.getOutputItem(); // name varies slightly

        if (result.is(Items.TOTEM_OF_UNDYING)) {
            totemsCreated += result.getCount();
        }

        if (totemsCreated >= 1000) {
            CreateAdvancementHelper.award(
                (SmartBlockEntity) self,
                TfAdvancements.THOUSAND_TOTEMS
            );
            totemsCreated = 0;
        }
    }
}


