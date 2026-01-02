package marcos.mysticcreationsteam.totemfactory.mixin;

import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public class TumbagaPiglinLikeable {
    @Inject(method = "isWearingGold", at = @At("HEAD"), cancellable = true)
    private static void onIsWearingGold(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir) {
        for(ItemStack itemStack : livingEntity.getArmorSlots()) {
            Item item = itemStack.getItem();
            if (item instanceof ArmorItem && ((ArmorItem)item).getMaterial().getName().equals(TotemFactory.MODID + ":tumbaga")) {
                cir.setReturnValue(true);
            }
        }
    }
}
