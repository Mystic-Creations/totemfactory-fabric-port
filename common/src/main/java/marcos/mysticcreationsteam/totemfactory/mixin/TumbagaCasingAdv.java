package marcos.mysticcreationsteam.totemfactory.mixin;

import com.simibubi.create.content.kinetics.deployer.ManualApplicationRecipe;
import marcos.mysticcreationsteam.totemfactory.init.TfAdvancements;
import marcos.mysticcreationsteam.totemfactory.init.TfBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
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
            Advancement adv = serverPlayer.server.getAdvancements()
                .getAdvancement(TfAdvancements.TUMBAGA_CASING);

            if (adv != null) {
                serverPlayer.getAdvancements().award(adv, "crafted");
            }
        }
    }
}
