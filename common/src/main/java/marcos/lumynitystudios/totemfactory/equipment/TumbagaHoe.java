package marcos.lumynitystudios.totemfactory.equipment;

import marcos.lumynitystudios.totemfactory.init.TfItems;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TumbagaHoe extends HoeItem {
    public TumbagaHoe() {
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
                return 1;
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
        }, -1, -1.0f, new Properties().stacksTo(1).rarity(Rarity.COMMON));
        //i - Attack Damage Modifier (final_dmg = base_damage + f), sometimes it's weird and you need to make it -1
        //f - Attack Speed Modifier (f = desired_speed - 4.0)
    }
}