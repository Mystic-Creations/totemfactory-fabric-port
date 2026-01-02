package marcos.mysticcreationsteam.totemfactory.createResources;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public final class CreateAdvancementHelper {

    private CreateAdvancementHelper() {}

    public static void registerAwardables(
        SmartBlockEntity be,
        List<BlockEntityBehaviour> behaviours,
        ResourceLocation... advancements
    ) {
        for (BlockEntityBehaviour behaviour : behaviours) {
            if (behaviour instanceof AdvancementBehavior ab) {
                ab.add(advancements);
                return;
            }
        }

        behaviours.add(new AdvancementBehavior(be, advancements));
    }

    public static void award(SmartBlockEntity be, ResourceLocation advancement) {
        AdvancementBehavior behaviour =
            be.getBehaviour(AdvancementBehavior.TYPE);

        if (behaviour != null) {
            behaviour.awardPlayer(advancement);
        }
    }

    public static void awardIfNear(
        SmartBlockEntity be,
        ResourceLocation advancement,
        int range
    ) {
        AdvancementBehavior behaviour =
            be.getBehaviour(AdvancementBehavior.TYPE);

        if (behaviour != null) {
            behaviour.awardPlayerIfNear(advancement, range);
        }
    }
}
