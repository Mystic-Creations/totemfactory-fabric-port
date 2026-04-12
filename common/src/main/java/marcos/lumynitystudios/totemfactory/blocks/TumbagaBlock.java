package marcos.lumynitystudios.totemfactory.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class TumbagaBlock extends Block {
    public TumbagaBlock() {
        super(Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).sound(SoundType.METAL).strength(4, 6).requiresCorrectToolForDrops());
    }
}
