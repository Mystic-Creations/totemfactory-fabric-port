package marcos.mysticcreationsteam.totemfactory.init;

import marcos.mysticcreationsteam.totemfactory.TotemFactory;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class TfFluidTags {
    public static final TagKey<Fluid> EXPERIENCE_FLUID = TagKey.create(Registries.FLUID, TotemFactory.asResource("experience_fluid"));
}
