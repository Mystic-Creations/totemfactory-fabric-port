package marcos.mysticcreationsteam.totemfactory.init;

import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import marcos.mysticcreationsteam.totemfactory.createResources.TfSpriteShifts;
import marcos.mysticcreationsteam.totemfactory.blocks.TumbagaBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static marcos.mysticcreationsteam.totemfactory.TotemFactory.REGISTRATE;

public class TfBlocks {
    public static Supplier<Block> TUMBAGA_BLOCK = register("tumbaga_block", TumbagaBlock::new);
    public static final BlockEntry<CasingBlock> TUMBAGA_CASING = REGISTRATE.block("tumbaga_casing", CasingBlock::new)
        .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
        .transform(BuilderTransformers.casing(() -> TfSpriteShifts.TUMBAGA_CASING))
        .item(BlockItem::new)
        .build()
        .register();

    public static void load() {}
    public static void clientLoad() {}

    @ExpectPlatform
    public static Supplier<Block> register(String registryName, Supplier<Block> item) {
        throw new IllegalStateException();
    }
}