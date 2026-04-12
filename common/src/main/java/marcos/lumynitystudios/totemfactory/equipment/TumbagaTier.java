package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.init.TfItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class TumbagaTier implements Tier {
    public static final TumbagaTier SWORD = new TumbagaTier(5f);
    public static final TumbagaTier AXE = new TumbagaTier(9f);
    public static final TumbagaTier HOE = new TumbagaTier(1f);
    public static final TumbagaTier PICKAXE = new TumbagaTier(3f);
    public static final TumbagaTier SHOVEL = new TumbagaTier(3.5f);

    private final float attackDamageBonus;

    public TumbagaTier(float attackDamageBonus) {
        this.attackDamageBonus = attackDamageBonus;
    }

    @Override
    public int getUses() { //USES
        return 220;
    }

    @Override
    public float getSpeed() { //MINING SPEED
        return 12.0f;
    }

    @Override
    public float getAttackDamageBonus() { //BASE DAMAGE
        return this.attackDamageBonus;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_IRON_TOOL;
    }

    @Override
    public int getEnchantmentValue() { //ENCHANTMENT VALUE
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(TfItems.TUMBAGA_ALLOY.get());
    }
}
