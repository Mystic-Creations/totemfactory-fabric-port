package marcos.lumynitystudios.totemfactory.mixin;

import com.simibubi.create.content.kinetics.deployer.ManualApplicationRecipe;
import marcos.lumynitystudios.totemfactory.init.TfAdvancements;
import marcos.lumynitystudios.totemfactory.init.TfBlocks;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ManualApplicationRecipe.class)
public class TumbagaCasingAdv {
    @Inject(method = "awardAdvancements", at = @At("HEAD"))
    private static void award(Player player, BlockState placed, CallbackInfo ci) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        if (TfBlocks.TUMBAGA_CASING.has(placed)) {
            AdvancementHolder adv = serverPlayer.server.getAdvancements()
                .get(TfAdvancements.TUMBAGA_CASING);

            if (adv != null) {
                serverPlayer.getAdvancements().award(adv, "crafted");
            }
        }
    }
}
