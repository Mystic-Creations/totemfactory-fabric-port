package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.init.TfItems;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaShovel extends ShovelItem {
    public TumbagaShovel() {
        super(new Tier() {
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
                return 3.5f;
            }

            @Override
            public int getLevel() { //TOOL LEVEL
                return 2;
            }

            @Override
            public int getEnchantmentValue() { //ENCHANTMENT VALUE
                return 14;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(TfItems.TUMBAGA_ALLOY.get());
            }
        }, 0.0f, -3.0f, new Properties().stacksTo(1).rarity(Rarity.COMMON));
        //f - Attack Damage Modifier (final_dmg = base_damage + f)
        //g - Attack Speed Modifier (final_speed = g + 4.0)
    }
}
